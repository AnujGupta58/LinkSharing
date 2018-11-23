package com.ttn.linksharing

import com.ttn.linksharing.CO.TopicCO
import grails.transaction.Transactional


class LinkResourceController {

    def index() {
        render("LinkResourceController index")
    }

    def viewLink(){
        LinkResource link=LinkResource.get(params.id)
        if(link){
            render(link.url)
        }
    }

    @Transactional
    def create(TopicCO co) {
        User user = session.user
        if (session.user) {
            Topic topic = Topic.get(co.id)
            if(topic){
                Resource linkResource = new LinkResource(topic: topic, createdBy: user, description: co.description, url: co.link)
                if(linkResource.save(flush: true, failOnError: true)){
                    flash.message="Link Resource created successfully ${linkResource}"
                    log.info("Link Resource created successfully ${linkResource}")
                    redirect(controller:'user', action:'index')
                }
                else{
                    linkResource.errors.allErrors.collect {message(code: it)}.join(",")
                    flash.message="Link Resource not created ${linkResource}"
                    redirect(controller:'user', action:'index')
                }
            }

        }
        else{
            flash.message="User is not logged in"
            redirect(controller: 'login',action: 'index')
        }
    }
}
