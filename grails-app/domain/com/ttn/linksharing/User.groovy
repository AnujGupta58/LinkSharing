package com.ttn.linksharing

import com.ttn.linksharing.CO.SearchCO
import com.ttn.linksharing.VO.RatingInfoVO
import com.ttn.linksharing.VO.SubscriptionVO
import com.ttn.linksharing.VO.TopicVO
import groovy.beans.Bindable

class User {

    String email
    String password
    String confirmPassword
    String firstName
    String lastName
    byte[] photo
    boolean admin
    boolean isActive
    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(unique: true, blank: false, email: true, nullable: false, bindable: true)
        // Email should be unique, email type, not null, not blank
        password(size: 5..10, nullable: false, blank: false, bindable: true, validator: { val, obj ->
            if (obj.confirmPassword) {
                return (val == obj.confirmPassword) ? true : ['mismatch.password']
            }
        })
        // Password should be not null, not blank and minimum 5 charactes
        firstName(nullable: false, bindable: true)
        lastName(nullable: false, bindable: true)
        //FirstName,LastName shoule not be null and not blank
        photo(nullable: true, bindable: true)
        // Photo, Admin and Active field can be null
        admin(nullable: true, bindable: true)
        /*   confirmPassword(size: 5..10, bindable: true, nullable: false, blank: false, validator: { val, obj ->
               if (val != obj.password) {
                   return 'password mismatch'
               }
               return true
           })*/
        dateCreated(date: Date, nullable: true)
        lastUpdated(date: Date, nullable: true)
    }

    static mapping = {
        photo(sqlType: 'longblob')
        sort 'id': 'desc'
        topics cascade: 'all-delete-orphan'
        // [sort: 'id' , order: 'desc']
    }

    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem]
    // User hasMany topics,subscriptions,readingItems and resources -

    static transients = ['fullName', 'confirmPassword']

    String getFullName() {
        [firstName, lastName].findAll { it }.join(" ")
    }

/*    static List getUnReadResource(SearchCO co, User user) {
        List unReaditem = ReadingItemVO.createCriteria().list(max: 9, offset: 0) {
            projections {
                eq("isRead", false)
                createAlias("resource", 'r')
                if (co.q) {
                    ilike("r.description", "%${co.q}%")
                }
                eq('user', user)
                //groupProperty("user")
            }
        }
        return unReaditem
    }*/

    static List<ReadingItem> getUnReadResource(User user) {
        List<ReadingItem> unReaditem = ReadingItem.createCriteria().list() {
            projections {
                eq("isRead", false)
                createAlias("resource", 'r')
                property('r.topic')
                eq('user',user)
                //groupProperty("user")
            }
        }
        return unReaditem
    }



    List getUserTopics() {
        List topic = Topic.findAllByCreatedBy(this)
        return topic
    }

/*    List<SubscriptionVO> getSubscribedTopic() {

        if (this.subscriptions) {
            List<SubscriptionVO> subscribedTopic = []
            this.subscriptions.each {
                subscribedTopic.add(new SubscriptionVO(topicId: it.topic.id, topicName: it.topic.name, createdByName: it.topic.createdBy.getFullName(),createdByemail: it.topic.createdBy.email,resourceCount: it.topic.resources.size(),subscriptionCount: it.topic.subscriptions.size()))
            }
        }
        return subscribedTopic
    }*/

    List<SubscriptionVO> getSubscribedTopic(User user){
        List<Subscription> subscribedTopic = Subscription.findAllByUser(user)
        List<SubscriptionVO> userSubscribedTopic = []
        subscribedTopic.each {
            userSubscribedTopic.add(new SubscriptionVO(topicName: it.topic.name,createdByName: it.user.firstName,createdByemail: it.user.email,resourceCount: it.topic.resources.size(),subscriptionCount: it.topic.subscriptions.size(),visibility: it.topic.visibility,seriousness: it.seriousness))
        }
        return userSubscribedTopic
    }

    Integer getSubscriptionCount() {
        if (this.subscriptions) {
            return this.subscriptions.size()
        } else {
            return 0
        }
    }

    def canDeleteResource(Long id) {
        Resource resource = Resource.get(id)
        if (resource) {
            if (resource.delete(flush: true)) {
                log.info("deleted")
                return true
            } else {
                resource.errors.allErrors.collect { message(code: it).join(",") }
                log.info("unable to delete")
                return false
            }
        } else {
            log.info("no resource found")
            return false
        }

    }

    static boolean isSubscribed(Long id) {
        Topic topic = Topic.findById(id)
        Subscription subscription = Subscription.findByTopic(topic)
        if (subscription) {
//            log.info("Subscription found")
            return true
        } else {
//            log.info("Subscription not found")
            return false
        }
    }


    @Override
    public String toString() {
        return getFirstName()
    }
}
