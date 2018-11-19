package com.ttn.linksharing

import com.ttn.linksharing.DTO.EmailDTO

class EmailSenderController {

    def index() { }

    def sendEmail(EmailDTO emailDTO){
        sendMail{
            to emailDTO.to
            subject emailDTO.subject
            text emailDTO.view
        }
        flash.message="Message sent at" + new Date()
        redirect(controller:'user' , action:'profile')
    }
}
