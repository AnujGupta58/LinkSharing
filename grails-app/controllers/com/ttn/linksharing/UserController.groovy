package com.ttn.linksharing

class UserController {

    def index() {
        render "User Dashboard"
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
        } else {
            redirect(controller: 'login', action: 'index')
        }
    }
}
