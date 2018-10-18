package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class SubscriptionSpec extends Specification implements DomainUnitTest<Subscription> {
    @Unroll
    def "Validating Specifications"() {

        when:
        Subscription subscription = new Subscription(user: user, seriousness: seriousness, topic: topic)

        then:
        subscription.validate() == result

        where:
        user       | seriousness                           | topic       | result
        new User() | Subscription.Seriousness.CASUAL       | new Topic() | true
        new User() | Subscription.Seriousness.SERIOUS      | new Topic() | true
        new User() | Subscription.Seriousness.VERY_SERIOUS | new Topic() | true


    }

}
