package com.ttn.linksharing

import grails.transaction.Transactional


class SubscriptionController {

    SubscriptionService subscriptionService
    def index() {
        render "Subscription index"
    }

    @Transactional
    def save(Long id,String seriousness){
        Topic topic=Topic.get(id)
        User user=session.user
        if(session.user){
            Subscription subscription=new Subscription(user: user,topic: topic,seriousness: Subscription.convertSeriousness(seriousness))
            if(subscription.save(flush:true)){
                render "subscription saved successfully"
            } else{
                render "invalid"
            }
        }
        else{
            redirect(controller: 'login', action: 'index')
        }
    }

    @Transactional
    def update(Long id){
        subscriptionService.update(id)
        render "Success ${subscription.seriousness}"
    }


    def delete(Long id){
        subscriptionService.delete(id)
        redirect(controller: 'topic' , action: 'show')
//        render"Subscription Deleted"
    }
}
