package com.ttn.linksharing.VO

import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enumeration.Seriousness
import com.ttn.linksharing.enumeration.Visibility
import grails.validation.Validateable

class   TopicVO implements Validateable {

    Long id
    String name
    String email
    Visibility visibility
    Seriousness seriousness
    Integer subscriptionsCount
    Integer resourcesCount
    boolean isSubscribed
    User createdBy
    Integer topicCount
}
