package com.ttn.linksharing

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
        email(unique: true, blank: false, email: true,nullable: false)          // Email should be unique, email type, not null, not blank
        password(size: 5..10, nullable: false, blank: false)    //Password should be not null, not blank and minimum 5 charactes
        firstName(nullable: false)
        lastName(nullable: false)                               //FirstName,LastName shoule not be null and not blank
        photo(nullable: true)                                   // Photo, Admin and Active field can be null
        admin(nullable: true)
        confirmPassword(size: 5..10, bindable:true, nullable: false, blank: false, validator: { val, obj ->
            if (val != obj.password) {
                return 'password mismatch'
            }
            return true
        })
        dateCreated(date: Date,nullable: true)
        lastUpdated(date: Date,nullable: true)
    }

    static mapping = {
        photo(sqlType: 'longblob')
        sort 'id':'desc'
       // [sort: 'id' , order: 'desc']
    }

    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,readingItems:ReadingItem]
                                        // User hasMany topics,subscriptions,readingItems and resources -

    static transients = ['fullName','confirmPassword']

    String getFullName(){
        [firstName,lastName].findAll{it}.join(",")
    }

    @Override
    public String toString() {
        return "Username=${email}"
    }
}
