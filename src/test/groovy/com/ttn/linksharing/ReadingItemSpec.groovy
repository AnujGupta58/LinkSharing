package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReadingItemSpec extends Specification implements DomainUnitTest<ReadingItem> {

    def "Validating ReadingItem"() {

        when:
        ReadingItem readingItem = new ReadingItem(user: user, isRead: isRead,resource: resource )

        then:
        readingItem.validate() == result

        where:
        user       | isRead |resource| result
        new User() | true   |new LinkResource() |true
    }

}
