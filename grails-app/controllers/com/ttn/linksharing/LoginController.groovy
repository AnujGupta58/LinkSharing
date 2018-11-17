package com.ttn.linksharing

import com.ttn.linksharing.CO.UserCO
import grails.transaction.Transactional


class LoginController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        log.info("i am in login action")
        if (session.user) {
            //render (view: "index")
            forward controller: 'User', action: 'index'
        } else {
            //render ">>>>>>>>${session["user"]}"
        }
    }


    @Transactional
    def register() {
       User user = new User([firstName: params.firstName, lastName: params.lastName, email: params.email, password: params.password, confirmPassword: params.confirmPassword, photo: params.photo])
//        user.properties=params
      //  UserCO user = new UserCO( firstName: params.firstName, lastName: params.lastName, email: params.email, password: params.password, confirmPassword: params.confirmPassword, photo: params.photo )
      //  user.isActive=true
        log.info("${params}")
        if (user.save()) {
            //render (view: "_register")
            session.user=user
            forward(controller:'user' , action:'index')
            flash.message = " User Registered Successfully"
        } else {
            render "Error ${user.errors.allErrors.collect { message(code: it) }.join(", ")}"
        }
        render(view: "index", model: [firstName: firstName, lastName: lastName, email: email, password: password, confirmPassword: confirmPassword, photo: photo])
    }

    def loginhandler(String username, String password) {
        User user = User.findByEmailAndPassword(username, password)
        if (user) {
            user.isActive=true
            if (user.isActive) {
                session["user"] = user
                flash.message="User logged in successfully"
                redirect(controller: 'user', action: 'index')
                return false
            } else {
                flash.message = "Your Account is not Active"
                render(view: 'index')
            }
        } else {
            flash.message = "User not Found"
            render(view: 'index')
            // (flash.error = "User..... not..... found")
        }
        render(view: "index", model: [username: username, password: password])
    }

    def forgotPassword() {
        User user = User.findByEmail(params.email)
        if (user) {
            session.user=user
            user.password=params.password
            user.confirmPassword=params.confirmpassword
            if(user.save(flush:true)) {
//                flash.message = "Password changed Successfully"
                forward(controller: 'user', action: 'index')
            }
        } else {
            flash.error = "Unable to change Password"
//            render "password not changed"
        }
        render(view: 'forgotPassword' , model: [email: 'email',password: 'password',confirmPassword: 'confirmpassword'])
    }

    def logout() {
        session.invalidate()
//        redirect(action: loginhandler())
        forward action: 'index'
    }
}
