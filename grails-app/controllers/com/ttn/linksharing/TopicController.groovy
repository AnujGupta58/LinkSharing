package com.ttn.linksharing

class TopicController {

    def index() {
        render"Topic Index"
    }

    def show(Long id) {
        Topic topic = Topic.get(id)
        render "Data collected ${topic.name}"
    }

    def delete(Long id) {
        Topic topic = Topic.load(id)
        log.info("//////////////////////${topic}")
        topic.delete()
        render "Deleted"
    }

    def save() {
        if(session.user){
            Topic topic=new Topic(name: params.name,visibility: params.visibility,createdBy: user)
            if(topic.save(flush: true,failOnError: true)){
                render "Topic Saved Successfully"
            }
        }
    }
}

