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
}
