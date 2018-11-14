package com.ttn.linksharing

class UserController {

    def auth(){
        def user=User.findByEmailAndPassword(params.email,params.password)
        if(user)
        {
            session.user=user
            flash.message="Hello ${user.email}"
            redirect(controller: 'user',action:'index')
        }
    }
    def index() {
        /*    List UnReadItemLeft=User.getUnReadResource(co,session.user)
            render "UnReadResources --->  ${UnReadItemLeft}"*/
            render (view: "index")
    }

    def show(Integer id) {
        Topic topic = Topic.get(id)
        if (topic) {
            if (topic.visibility == Topic.Visibility.PUBLIC) {
                render "Success"
            } else {
                User user = session.user
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                if (subscriptionCount) {
                    render "success"
                } else {
                    redirect(controller: 'login', action: 'index')
                }
            }
        }
        else {
            redirect(controller: 'login', action: 'index')
        }
    }

    def showAllUsers(){
        List<User> users= User.findAllByAdmin(false)
        users.each{
            println users.email
            println users.firstName
        }
        render (view: '/user/userList')
    }
}
