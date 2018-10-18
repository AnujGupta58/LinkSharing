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
}
