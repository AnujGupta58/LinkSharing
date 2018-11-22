package com.ttn.linksharing

import grails.transaction.Transactional


class ReadingItemController {

    def index() {
        render "ReadingItemController Index Action"
    }

    def changeIsRead(Long Id, Boolean isRead) {
        //ReadingItemVO readingItem=ReadingItemVO.get(Id)
        //readingItem.isRead=isRead
        if (User.executeUpdate("update ReadingItemVO r set r.isRead=:isRead where r.id=:Id", [isRead: isRead, Id: Id])) {
            render "SUCCESS"
        } else {
            render "Invalid Input"
        }
    }

    @Transactional
    def save(Long id) {
        User user = session.user
       // log.info("Current Logged In User : ${user?.firstName}")
        Resource resource = Resource.get(id)
        if(session.user){
            ReadingItem readingItem=new ReadingItem(user: user, resource: resource, isRead: params.isRead)
            if(readingItem.save(flush: true,failOnError: true)){
                render "ReadingItemVO Saved Successfully"
            }
        }
    }
}
