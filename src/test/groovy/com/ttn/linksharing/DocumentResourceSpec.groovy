package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DocumentResourceSpec extends Specification implements DomainUnitTest<DocumentResource> {

    def "Check filePath"() {
        when:
        DocumentResource documentResource = new DocumentResource(filepath: "/home/anuj/Desktop/Document")

        then:
        documentResource.toString().equals("filePath /home/anuj/Desktop/Document")
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
