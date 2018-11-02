package com.ttn.linksharing

import com.ttn.linksharing.VO.TopicVO

class Topic {
    enum Visibility {
        PRIVATE, PUBLIC

    }

    static String convertVisibilty(String visibility) {
        valueOf(visibility)
    }
    String name;
    Visibility visibility
    User createdBy
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
    }

    static hasMany = [subscriptions: Subscription, resources: Resource]

    /*void afterInsert(){

        withNewSession {
            Subscription subscription=new Subscription(topic: this,seriousness: Subscription.Seriousness.VERY_SERIOUS,user:this.createdBy)
            subscription.save(failOnError:true)

        }
    }*/

    static List getTrendingTopics(){
        List ResourceCount = Resource.createCriteria().list {
            projections {
                createAlias("topic", "t")
                count("topic", 'counting')
                property("t.name")
            }
            groupProperty("topic")
            order('counting', 'desc')
            order("b.name",'desc')
            maxResults(5)
        }
        return ResourceCount
    }
}

// Visibility is enum type so for constraints we need to change enum to list to check for each values
