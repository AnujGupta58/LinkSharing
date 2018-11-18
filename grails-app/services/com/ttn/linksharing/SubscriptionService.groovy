package com.ttn.linksharing



class SubscriptionService {

    def serviceMethod() {

    }

    def get(Long id){
        Subscription.get(id)
    }

   /* def save(Long id,String seriousness){

    }*/

    def update(Long id){
        def subscription = Subscription.get(id)
        subscription.seriousness= "CASUAL"
        subscription.save(flush:true)
    }

    def delete(Long id){
        Subscription subscription = Subscription.get(id)
        subscription.delete(flush:true,failOnError:true)
    }
}
