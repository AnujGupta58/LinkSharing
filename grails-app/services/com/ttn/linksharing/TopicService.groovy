package com.ttn.linksharing

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

    def show(Long id){
        Topic topic = Topic.get(id)
    }
}
