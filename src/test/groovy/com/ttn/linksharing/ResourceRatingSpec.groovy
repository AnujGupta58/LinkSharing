package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ResourceRatingSpec extends Specification implements DomainUnitTest<ResourceRating> {

    def "validating resourceRating"() {

        when:
        ResourceRating resourceRating = new ResourceRating(score: score, user: user,resource: resource)


        then:
        resourceRating.validate() == result

        where:
        score | user       | resource|result
         5     | new User() | new LinkResource()|true
    }

}
