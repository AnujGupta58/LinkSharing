package com.ttn.linksharing

class ReadingItemController {

    def index() {
        render "ReadingItemController Index Action"
    }

    def changeIsRead(Long Id, Boolean isRead) {
        //ReadingItem readingItem=ReadingItem.get(Id)
        //readingItem.isRead=isRead
        if (User.executeUpdate("update ReadingItem r set r.isRead=:isRead where r.id=:Id", [isRead: isRead, Id: Id])) {
            render "SUCCESS"
        } else {
            render "Invalid Input"
        }
    }

    def save(Long id) {
        User user = session.user
       // log.info("Current Logged In User : ${user?.firstName}")
        Resource resource = Resource.get(id)
        if(session.user){
            ReadingItem readingItem=new ReadingItem(user: user, resource: resource, isRead: params.isRead)
            if(readingItem.save(flush: true,failOnError: true)){
                render "ReadingItem Saved Successfully"
            }
        }
    }
}
