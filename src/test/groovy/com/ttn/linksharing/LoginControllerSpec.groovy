package com.ttn.linksharing

import com.ttn.linksharing.LoginController
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class LoginControllerSpec extends Specification implements ControllerUnitTest<LoginController>, DomainUnitTest<User> {

    def "check logout"() {
        when: "user being logged in"
        controller.logoutAction()

        then:
        response.forwardedUrl == '/login/index'
    }

    @Unroll
    def "check login"() {
        setup:
        User user = new User(email: "anujgupta@tothenew.com", password: "qwerty", isActive: true, confirmPassword: "qwerty", admin: false, photo: null, firstName: "firstadmin", lastName: "lastadmin")
        user.save()
//        User user1 = new User(email: "abc@tothenew.com", password: "qwerty1", isActive: false, confirmPassword: "qwerty", admin: false, photo: null, firstName: "firstadmin", lastName: "lastadmin")
//        user1.save()

        when:
        controller.loginhandler(username, password)


        then:
        response.redirectUrl == "/login/index"
      //  response.text == "Your Account is not Active"

        where:
        username                 | password
        "anujgupta@tothenew.com" | "qwerty"
       // "abc@tothenew.com"       | "qwerty1"
    }

}
