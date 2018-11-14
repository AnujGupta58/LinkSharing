package com.ttn.linksharing.VO

import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Visibility
import grails.validation.Validateable

class   TopicVO implements Validateable {

    Long id
    String name
    Visibility visibility
    Integer count
    User createdBy
}
