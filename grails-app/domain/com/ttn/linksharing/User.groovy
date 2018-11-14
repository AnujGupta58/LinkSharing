package com.ttn.linksharing

import com.ttn.linksharing.CO.SearchCO
import com.ttn.linksharing.VO.RatingInfoVO
import groovy.beans.Bindable

@Bindable
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
        email(unique: true, blank: false, email: true, nullable: false, bindable:true)
        // Email should be unique, email type, not null, not blank
        password(size: 5..10, nullable: false, blank: false, bindable:true,validator: { val, obj ->
            if (obj.confirmPassword) {
                    return (val==obj.confirmPassword) ? true : ['mismatch.password']
            }
        })
        // Password should be not null, not blank and minimum 5 charactes
        firstName(nullable: false, bindable:true)
        lastName(nullable: false, bindable:true)                               //FirstName,LastName shoule not be null and not blank
        photo(nullable: true, bindable:true)                                   // Photo, Admin and Active field can be null
        admin(nullable: true, bindable:true)
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
        // [sort: 'id' , order: 'desc']
    }

    static hasMany = [topics: Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem]
    // User hasMany topics,subscriptions,readingItems and resources -

    static transients = ['fullName', 'confirmPassword']

    String getFullName() {
        [firstName, lastName].findAll { it }.join(" ")
    }

    static List getUnReadResource(SearchCO co,User user) {
        List unReaditem = ReadingItem.createCriteria().list(max: 9, offset: 0) {
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
    }

    List<Topic> getSubscribedTopic(){
        List<Topic> subscribedTopic=[]
        if(this.subscriptions)
            this.subscriptions.each{
                subscribedTopic.add(it.topic)
            }
        return subscribedTopic
    }

    Integer getSubscriptionCount(){
        if(this.subscriptions){
            return this.subscriptions.size()
        }
        else {
            return 0
        }
    }

    def canDeleteResource(Long id){
        Resource resource= Resource.get(id)
        if(resource){
            if(resource.delete(flush:true)){
                log.info("deleted")
                return true
            }
            else{
                resource.errors.allErrors.collect {message(code:it).join(",")}
                log.info("unable to delete")
                return false
            }
        }
        else {
            log.info("no resource found")
            return false
        }

    }

    def isSubscribed(Long id){
        Topic topic =Topic.findById(id)
        Subscription subscription= Subscription.findByTopic(topic)
        if(subscription){
            log.info("Subscription found")
            return true
        }
        else{
            log.info("Subscription not found")
        }
     /*   List<Subscription> subscription= Subscription.createCriteria().list {
            projections{

            }

        }*/

    }


    @Override
    public String toString() {
        return getFirstName()
    }
}
