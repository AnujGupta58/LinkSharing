package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {

    def "Check URL"() {
        when:
        LinkResource linkResource = new LinkResource(url: "https://www.google.com/")

        then:
        linkResource.toString().equals("url https://www.google.com/")

   /*     where:
        url                       | res
        "https://www.google.com/" | true
*/
    }

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
