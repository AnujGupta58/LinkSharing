package com.ttn.linksharing

import com.ttn.linksharing.CO.TopicCO
import grails.transaction.Transactional

@Transactional
class DocumentResourceController {

    def index() { }

    def create(TopicCO co){
        User user = session.user
        if (session.user) {
            Topic topic = Topic.get(co.id)
            Resource documentResource = new DocumentResource(topic: topic, createdBy: user, description: co.description, filepath: co.filepath)
            if(documentResource.save(flush: true, failOnError: true)){
                flash.message="Link Resource created successfully ${documentResource}"
                log.info("Link Resource created successfully ${documentResource}")
                redirect(controller:'user', action:'index')
            }
            else{
                documentResource.errors.allErrors.collect {message(code: it)}.join(",")
                flash.message="Link Resource not created ${documentResource}"
                redirect(controller:'user', action:'index')
            }
        }
        else{
            flash.message="User is not logged in"
            redirect(controller: 'login',action: 'index')
        }

    }

    def download(){
        Resource resource= Resource.get(params.id)
        if(resource && (resource.createdBy==session.user || resource.createdBy.isAdmin() || resource.topic.canViewedBy(session.user))){
            File file =new File("/home/anuj/LinkSharing/grails-app/assets/images/Avatar.png")
            byte[] orderPDF = file.getBytes()
            response.setHeader("Content-disposition", "attachment; filename=" + file.name)
            response.contentLength = orderPDF.length
            response.outputStream << orderPDF
        }
    }

/*    def createOrderPDF() {
        byte[] orderPDF = ... // create the bytes from some source
        response.setHeader("Content-disposition", "attachment; filename=" + fileName)
        response.contentType = contentType
        response.contentLength = bytes.length
        response.outputStream << bytes
    }*/
}
