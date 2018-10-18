package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification implements DomainUnitTest<User> {
    @Unroll
    def "validate constraints on user"() {
        when:
        User user = new User(email: email, password: password, confirmPassword: confirmPassword, firstName: firstName,
                lastName: lastName, photo: photo, admin: admin, isActive: isActive)

        then:
        user.validate() == result

        where:
        email           | password   | confirmPassword | firstName | lastName | photo         | admin | isActive | result
        "test@test.com" | "password" | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | true
        ""              | "password" | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | false
        null            | "password" | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | false
        "test"          | "password" | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | false
        "test@test.com" | ""         | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | false
        "test@test.com" | null       | "password"      | "first"   | "last"   | "photo".bytes | true  | true     | false

    }
}
