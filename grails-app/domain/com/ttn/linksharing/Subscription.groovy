package com.ttn.linksharing

import com.ttn.linksharing.enums.Seriousness

class Subscription {
    static Seriousness convertSeriousness(String seriousness) {
            seriousness.valueOf(seriousness)
    }

    Seriousness seriousness
    User user;
    Topic topic
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user(nullable: false)                        //User,topic, seriousness should not be null
        topic(nullable: false,unique: 'user')        /*User should not be able to subscribe to topic multiple times */
        seriousness(nullable: false)
       // user(unique: 'topic')
        dateCreated(date: Date,nullable: true)
        lastUpdated(date: Date,nullable: true)
    }

    static mapping = {
        seriousness defaultValue:"'SERIOUS'"
        topic lazy: false
        user lazy: false

    }
}
