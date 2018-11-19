package com.ttn.linksharing

import com.ttn.linksharing.VO.SubscriptionVO
import com.ttn.linksharing.VO.TopicVO
import com.ttn.linksharing.VO.UserVO
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

    def subscriptionList(){
        List<Subscription> subscriptionList = Subscription.findAllByUser(session.user)
        List<SubscriptionVO> subscribedTopics=[]
        subscriptionList.each {
            subscribedTopics.add(new SubscriptionVO(createdByName: it.topic.createdBy.firstName,createdByemail: it.topic.createdBy.email))
        }

        render(view: '_subscriptions', model: [subscribedTopics:subscribedTopics])
    }
}

