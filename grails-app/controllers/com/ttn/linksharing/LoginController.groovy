package com.ttn.linksharing

class LoginController {

    def index() {
            log.info("login INDEX action")

//        render ">>>>>>>>${session["user"]}"
    }

    def register() {
        User user = new User(params)
        if (user.save(flush: true)) {
            render(params)
            render "success"
            render "Registered Successfully"
        }
      /*  else{

        }*/
    }

    def loginhandler(String username, String password) {
        User user = User.findByEmailAndPassword(username, password)

        if (user) {
            if (user.isActive) {
                session["user"] = user
                redirect(controller: 'login', action: 'index')
            } else {
                render "Your Account is not Active"
            }
        } else {
            render "User not Found"
            // (flash.error = "User..... not..... found")
        }
    }

    def logoutAction() {
        session.invalidate()
//        redirect(action: loginhandler())
        forward action: 'index'
    }
}
