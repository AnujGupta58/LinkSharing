package com.ttn.linksharing

class ReadingItem {
    User user
    boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated


    static constraints = {
        resource(nullable: false,unique: ['user'])          // ReadingItemVO resource should be unique per user
        user(nullable: false)
        isRead(nullable: false)             // User,isRead and resource cannot be null for readingItem
        dateCreated(date: Date,nullable: true)
        lastUpdated(date: Date,nullable: true)
    }
}
