package com.ttn.linksharing

class TopicController {

    def index() {

    }

    def saveTopic(Topic topic,String seriousness){
//        log.info topic.read(1)

        Topic topic1=new Topic(params)
        topic1.read()
       /* if(topic1.save(failOError:true,flush:true))
        {
            flash.message="Success"
        }
        else{
            log.info "topic1 not saved due to ${topic1.errors.allErrors}"
        }
*/
        Topic.Visibility.valueOf(seriousness)

    }
}

