package com.ttn.linksharing

class LoginController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        log.info("i am in login action")
        if (session.user) {
            render (view: "index")
            //forward controller: 'User', action: 'index'
        } else {
            //render ">>>>>>>>${session["user"]}"
        }
    }

 /*   def test(){
        render(view:'homePage')
    }*/
//    firstName:params.firstName,lastName:params.lastName,email:params.email,password: params.password,confirmPassword:params.confirmPassword,photo:params.photo
    def register() {
        User user =new User(params)
//        user.properties=params
        log.info("params here---------------->>>>>> ${params.email}")
        if (user.save()) {
            //render (view: "_register")
            flash.message=" User Registered Successfully"
        } else {
            render "Error ${user.errors.allErrors.collect {message(code:it)}.join(", ")}"
        }
        render(view: "index", model: [firstName:firstName,lastName:lastName,email:email,password: password,confirmPassword:confirmPassword,photo:photo])
    }

    def loginhandler(String username, String password) {
        User user = User.findByEmailAndPassword(username, password)
        if (user) {
            if (user.isActive) {
                session["user"] = user
                redirect(controller: 'user', action: 'index')
                return false
            } else {
                flash.message = "Your Account is not Active"
                render(view: 'index')
            }
        } else {
            flash.message ="User not Found"
            render(view: 'index')
            // (flash.error = "User..... not..... found")
        }
        render(view: "index", model: [username:username,password:password])
    }

    def forgotPassword(){
        User user=User.findByEmail(params.email)
        if(user)
        {
            session.user=user
            flash.message="Password changed Successfully"
            forward(controller:'user',action:'index')
        }
        else
        {
            flash.error="Unable to change Password"
        }
        render(view: 'forgotPassword')
    }
    def logout() {
        session.invalidate()
//        redirect(action: loginhandler())
        forward action: 'index'
    }
}
