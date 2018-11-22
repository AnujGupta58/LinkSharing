package com.ttn.linksharing

import com.ttn.linksharing.VO.ResourceVO
import grails.transaction.Transactional


class LoginController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        log.info("In login action")
        if (session.user) {
            //render (view: "index")
            forward controller: 'User', action: 'index'
        } else {
            log.info("In login index display recent share and top post")
            List<Resource> resource= Resource.getrecentShare()
            List<ResourceVO> recentShares=[]
            resource.each {
                recentShares.add(new ResourceVO(topicId: it.topic.id, topicName: it.topic.name, description: it.description, createdByName: it.createdBy.firstName,createdByEmail: it.createdBy.email))
            }

            List<Resource> resources = Resource.getTopPost()
            List<ResourceVO> topPosts=[]
            resources.each {
                topPosts.add(new ResourceVO(topicName: it[1],description: it[2]))
            }
            render(view: '/login/index', model: [recentShares:recentShares,topPosts:topPosts])
        }
    }


    @Transactional
    def register(User user) {
//        user.properties=params
      //  UserVO user = new UserVO( firstName: params.firstName, lastName: params.lastName, email: params.email, password: params.password, confirmPassword: params.confirmPassword, photo: params.photo )
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
        render(view: "index", model: [user :user])
    }

    def loginhandler(String username, String password) {

        User user = User.findByEmailAndPassword(username, password)
        if (user) {
//            user.isActive=true
            if (user.isActive) {
                session["user"] = user
                flash.message="User logged in successfully"
                redirect(controller: 'user', action: 'index')
                return false
            } else {
                flash.error = "Your Account is not Active"
                render(view: 'index')
            }
        } else {
            flash.error = "Username and Passowrd is incorrect "
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
            else {
                flash.error = "Unable to change Password"
            }
        } else {
            flash.error = "User not found"
//            render "password not changed"
        }
        render(view: 'forgotPassword' , model: [email: 'email',password: 'password',confirmPassword: 'confirmpassword'])
    }

    def forgotPasswordPage(){
        render(view: '/login/forgotPassword')
    }

    def logout() {
        session.invalidate()
//        redirect(action: loginhandler())
        forward action: 'index'
        session.invalidate()
    }
}
