package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.VO.TopicVO

class TopicController {

    TopicService topicService
    def index() {
        render"Topic Index"
    }

    def show(Long id) {
        def info=topicService.getInfo(id)
        if(info){
            render(view: 'showTopic',model: [topicVO:info])
        }

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

