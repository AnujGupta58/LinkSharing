package com.ttn.linksharing

abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated


    static constraints = {
        dateCreated(date: Date,nullable: true)
        lastUpdated(date: Date,nullable: true)
    }
static mapping = {
    description(sqlType: 'text' )
}
    static hasMany = [ratings:ResourceRating,readingItems:ReadingItem]

    Integer totalVotes(){
        Topic topic = Topic.get(1)
        List sub = Subscription.findAllByTopic(topic)

    }

    Integer totalScore(){
        Resource resource
        ResourceRating resourceRating = ResourceRating.countByScore()
        return 1
    }
}

