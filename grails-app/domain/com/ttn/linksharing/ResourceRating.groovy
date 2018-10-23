package com.ttn.linksharing

class ResourceRating {
    User user
    Resource resource
    // Range score = 1..5
    Integer score
    Date dateCreated
    Date lastUpdated


    static constraints = {
        user(nullable:false)                   // ResourceRating can be given by a user only one time for a resource
        resource(nullable:false,unique: 'user')                   // ResourceRating can be given by a user only one time for a resource
        score(nullable: false, range: 1..5)        //  Resource score should not be more than 5 and less than 1
        dateCreated(nullable: true)
        lastUpdated(nullable: true)

    }
}
