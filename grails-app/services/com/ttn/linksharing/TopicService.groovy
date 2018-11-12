package com.ttn.linksharing

import com.ttn.linksharing.VO.TopicVO
import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    def save(){

    }

    def delete(Long id){
        Topic topic = Topic.load(id)
        log.info("//////////////////////${topic}")
        topic.delete()
    }

    def getInfo(Long id){
        Topic topic = Topic.findById(id)
        if(topic){
            TopicVO topicVO =new TopicVO(id: id, name: topic.name,createdBy: topic.createdBy,visibility: topic.visibility,count: topic.subscriptions.size())
            return topicVO
        }
       // return topicVO
    }
}
