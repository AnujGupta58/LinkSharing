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
}
