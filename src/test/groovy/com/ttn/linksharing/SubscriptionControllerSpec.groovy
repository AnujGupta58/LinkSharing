package com.ttn.linksharing

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class SubscriptionControllerSpec extends Specification implements ControllerUnitTest<SubscriptionController> {

    Class[] getDomainClassesToMock() {
        [User, Topic, Subscription]
    }

    def "Testing of subscription save"() {
        setup:
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.convertSeriousness(seriousness))
        subscription.save(flush: true)

        when:
        controller.save(id, seriousness)

        then:
        response.text == "subscription saved successfully"

        where:
        id=1
        seriousness="PRIVATE"
    }

    def "Testing of subscription update"() {
        setup:
        Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.convertSeriousness(seriousness))
        subscription.save(flush: true)

        when:
        controller.update(id)

        then:
        response.text=="Success ${subscription.seriousness}"

        where:
        id=1
    }

    def "Testing of subscription delete"() {


    }
}
