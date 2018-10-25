package com.ttn.linksharing

class UserController {

    def index() {
        render "User Dashboard"
    }

    def show(int id){
        Topic topic=Topic.findById(id)
        if(topic)
        {
            if(topic.visibility.PUBLIC)
            {
                render "Success"
            }
            else {
                render"visibility type not found"
            }
        }
        else {
            redirect(controller: 'login', action: 'index')
        }
    }
}
