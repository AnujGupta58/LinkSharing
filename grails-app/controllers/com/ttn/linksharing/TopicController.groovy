package com.ttn.linksharing

import com.ttn.linksharing.CO.TopicCO
import grails.transaction.Transactional


//@Transactional
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

    def delete(){
        Topic topic =Topic.findById(params.id)
        if(topic){
            if(topic.delete(flush: true)){
                flash.message='Topic Deleted'
                log.info('Topic Deleted')
                redirect(controller:'user',action:'profile')
            }
            else{
                topic.errors.allErrors.collect{message(code: it)}.join(",")
                log.info("Cannot delete topic")
                render("Cannot delete topic")
            }
        }
        else{
            log.info("Topic not found")
            render("Topic not found")
        }

    }

    def topicResource(Long topicId) {
        Topic topic = Topic.get(topicId)
        List<Resource> resources = []
        if (topic.isPublic(topic)) {
            List resource = Resource.findAllByTopic(topic)
            resource.each {
                resources.add(it)
            }
        } else if (session.user && Subscription.findByUserAndTopic(session.user, topic)) {
            List resource = Resource.findAllByTopic(topic)
            resource.each {
                resources.add(it)
            }
        }
        render(view:'res' , )
    }

    def save() {
        User user = session.user
        log.info("Current Logged In User : ${user?.firstName}")
        if(session.user){
            Topic topic=new Topic(name: params.topicName,visibility: params.visibility,createdBy: user)
            if(topic.save(flush: true,failOnError: true)){
                flash.message= "Topic Saved Successfully"
                redirect(controller: 'user', action: 'index')
            }
            else {
                flash.error="Topic not saved successfully"
                topic.errors.allErrors.collect{message(code: it)}.join(",")
            }
        }
    }

    def editTopic(){
        User user =session.user
        Topic topic =Topic.get(params.id)
        if(topic){
            topic.name=params.name
//            topic.visibility=params.visibility
            if(topic.save(flush:true)){
                flash.message="Topic name and visibility updated succcessfully"
                log.info("Topic name and visibility updated succcessfully")
                redirect(controller: 'user', action: 'profile')
            }
            else {
                flash.error='topic.errors.allErrors.collect{message(code: it)}.join(",")'
                log.info("Topic cannot be updated")
            }
        }
        else{
            flash.error="Topic not found"
        }
    }
}

