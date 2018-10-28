package com.ttn.linksharing


class SubscriptionController {

    def index() {
        render "Subscription index"
    }


    def save(Long id,String seriousness){
        Topic topic=Topic.get(id)
       // log.info("!!!!!!!!!!!!!!!!!!!!${topic}!!!!!!!!!")
        User user=session.user
        if(user){
            Subscription subscription=new Subscription(user: user,topic: topic,seriousness: Subscription.convertSeriousness(seriousness))
            subscription.save(flush:true)
            render "subscription saved successfully"
        }
        else{
            redirect(controller: 'login', action: 'index')
        }
    }

    def update(Long id){
        def subscription = Subscription.get(id)
        subscription.seriousness= "CASUAL"
        subscription.save(flush:true)
        render "Success ${subscription.seriousness}"
        log.info subscription.seriousness
    }

    def delete(Long id){
        Subscription subscription=Subscription.get(id)
      //  subscription..add( )
        subscription.delete()
        render"Subscription Deleted"
    }
}
