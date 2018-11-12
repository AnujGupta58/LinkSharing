package com.ttn.linkSharing

import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.User

class LinkSharingtaglibTagLib {

    static namespace = "ls"
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def markAsRead={ attrs,body ->
        User user=session.user
        def resources=attrs.resource
        if(user && resources){
            ReadingItem readingItem = ReadingItem.findByUserAndResource(user,resources)
            if(readingItem.isRead){
                out>>body(readingItem.isRead="Mark As Read")
            }
            else{
                out>>body(readingItem.isRead="Mark As UnRead")
            }
        }
    }

    def trendingTopics={
        out<< render(template: '/topic/trendingTopic')
    }


}
