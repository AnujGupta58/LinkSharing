package com.ttn.linksharing

import com.ttn.linksharing.LoginController
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class LoginControllerSpec extends Specification implements ControllerUnitTest<LoginController> {

    def "check login"(){
        when: "user being logged in"
        controller.logoutAction()

        then:
        response.redirectUrl== '/login/index'
    }

}
