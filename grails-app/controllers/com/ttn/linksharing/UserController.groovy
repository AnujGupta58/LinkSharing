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
        render "User Dashboard"
    }



    def show(Integer id) {
        Topic topic = Topic.get(id)
//        println topic.read(1L)
        if (topic) {
            if (topic.visibility == Topic.Visibility.PUBLIC) {
                render "Success of Visibilty Public"
            } else {
                User user = session.user
                log.info(session.user)
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                log.info(">>>>>>>>>>>>>>>${Subscription.countByUser(user)}@@@@@@@@")
                log.info(">>>>>>>>>>>>>>>${subscriptionCount}>>>>>>>>>>>")
                if (subscriptionCount) {
                    render "success"
                } else {
                    log.info">>>>>>>>>>>>>>>>>inside"
                    redirect(controller: 'login', action: 'index')
                }
            }
        } else {
            redirect(controller: 'login', action: 'index')
        }

    }
}
