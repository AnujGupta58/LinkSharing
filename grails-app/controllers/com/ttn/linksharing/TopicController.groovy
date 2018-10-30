package com.ttn.linksharing

class TopicController {

    TopicService topicService
    def index() {
        render"Topic Index"
    }

    def show(Long id,ResourceSearchCO resourceSearchCO) {
        Topic topic = Topic.get(id:  id,resources: resourceSearchCO)
        render "Data collected ${resourceSearchCO.topicId }"
    }

    def delete(Long id) {
        topicService.delete(id)
        render "Deleted"
    }

    def save() {
        User user = session.user
        log.info("Current Logged In User : ${user?.firstName}")
        if(session.user){
            Topic topic=new Topic(name: params.name,visibility: params.visibility,createdBy: user)
            if(topic.save(flush: true,failOnError: true)){
                render "Topic Saved Successfully"
            }
        }
    }
}

