package com.ttn.linksharing

class Topic {
    enum Visibility {
        PRIVATE,PUBLIC
    }

    String name;
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated


    static constraints = {
        name(nullable: false,blank: false,unique: ['createdBy'])          //Topic name should be not null, not blank
        visibility(nullable: false,blank: false, inList: Visibility.values() as List)  //Visibility should not be null
        createdBy(nullable: false)              // Created by should not be null
        dateCreated(date: Date,nullable: true)
        lastUpdated(date: Date,nullable: true)

    }

    static hasMany = [subscriptions:Subscription,resources:Resource]
}







// Visibility is enum type so for constraints we need to change enum to list to check for each values
