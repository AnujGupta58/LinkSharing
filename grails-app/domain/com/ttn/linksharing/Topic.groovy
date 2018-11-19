package com.ttn.linksharing

import com.ttn.linksharing.VO.TopicVO
import com.ttn.linksharing.enumeration.Seriousness
import com.ttn.linksharing.enumeration.Visibility

class Topic {
    String name
    User createdBy
    Visibility visibility
    Date dateCreated
    Date lastUpdated

    @Override
    String toString() {
        return "Topic: ${name} "
    }
    static constraints = {
        name(nullable: false, blank: false, unique: ['createdBy'])          //Topic name should be not null, not blank
        visibility(nullable: false, blank: false, inList: Visibility.values() as List)  //Visibility should not be null
        createdBy(nullable: false)              // Created by should not be null
        dateCreated(date: Date, nullable: true)
        lastUpdated(date: Date, nullable: true)

    }
    static mapping = {
        sort name: 'asc'
        subscriptions cascade: 'all-delete-orphan'
        resources cascade: 'all-delete-orphan'

    }

    static hasMany = [subscriptions: Subscription, resources: Resource]
    //static belongsTo = [createdBy: User]

    void afterInsert() {

        withNewSession {
            Subscription subscription = new Subscription(topic: this, seriousness: Seriousness.VERY_SERIOUS, user: this.createdBy)
            subscription.save(failOnError: true)

        }
    }

    static List getTrendingTopics() {
        List ResourceCount = Resource.createCriteria().list {
            projections {
                createAlias("topic", "t")
                count("topic", 'counting')
                property("t.name")
            }
            groupProperty("topic")
            order('counting', 'desc')
            order("b.name", 'desc')
            maxResults(5)
        }
        return ResourceCount
    }

    def isPublic(Topic topic) {
        if (topic.visibility.PUBLIC) {
            log.info("Topic is public")
            return true
        } else {
            log.info("Topic is private")
            return false
        }
    }

    def canViewedBy(User user) {
        Subscription subscription = Subscription.findByUserAndTopic(user, this)
        if (isPublic(this) || subscription || user.isAdmin()) {
            log.info("Can be viewed by ${user}")
            return true
        } else {
            log.info("cannot be viewed")
            return false
        }
    }

    def isSubscribed() {
//        Topic topic = Topic.findById()
        Subscription subscription = Subscription.findByTopicAndUser(this, session.user)
        if (subscription) {
            return true
        } else {
            return false
        }
    }
}

// Visibility is enumeration type so for constraints we need to change enumeration to list to check for each values
// topic.canViewBy()