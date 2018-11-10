package com.ttn.linksharing.VO

import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import grails.validation.Validateable

class   TopicVO implements Validateable {

    Long id
    String name
    Topic.Visibility visibility
    Integer count
    User createdBy
}
