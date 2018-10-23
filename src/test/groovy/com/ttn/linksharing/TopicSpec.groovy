package com.ttn.linksharing


import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TopicSpec extends Specification implements DomainUnitTest<Topic> {


    def "validating topic"() {
        when:
        Topic topic = new Topic(name: name, visibility: visibility, createdBy: user)


        then:
        topic.validate() == result

        where:
        name   | visibility               | user       | result
        "Java" | Topic.Visibility.PRIVATE | new User() | true
    }

    def "Check toString of topic"() {
            given:
            User user = new User(email: "user@tothenew.com", confirmPassword: "qwerty", password: "qwerty", firstName: "userfirst", lastName: "userlast", admin: false, isActive: false, photo: null)
            when:
            Topic topic = new Topic(name: "Topic1", createdBy: user)
            then:
            topic.toString().equals("Name of Topic: Topic1 and username Username=user@tothenew.com ")
    }
}
