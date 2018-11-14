package com.ttn.linkSharing

import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
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
                out>>body()<<(readingItem.isRead="Mark As Read")
            }
            else{
                out>>body()<<(readingItem.isRead="Mark As UnRead")
            }
        }
    }

    def trendingTopics={
        out<< render(template: '/topic/trendingTopic')
    }

    def userImage ={

    }

    def canDeleteResource={ attrs,body ->
        if(session.user){
            User user=session.user
            Long id=attrs.Id
            if(user.canDeleteResource(id)){
                out>>body()<<("Delete")
            }
        }
    }

    def subscriptionCount={attrs,body->
        Long userID=attrs.userId
        Long topicID=attrs.topicID
        if(userID){
            out << Subscription.countByUser(User.get(userID))
        }
        else if (topicID){
            out<< Subscription.countByTopic(Topic.get(topicID))
        }
        else{
            out<< log.info("error")
        }
    }

    def resourceCount={ attrs,body->
        Long userID=attrs.userId
        Long topicID=attrs.topicID
        if(userID){
            out << Resource.countByCreatedBy(User.get(userID))
        }
        else if (topicID){
            out<< Resource.countByTopic(Topic.get(topicID))
        }
        else{
            out<< log.info("error")
        }
    }

    def topicCount={ attrs,body->
        User user = User.get(attr.user)
        if (user){
            out << Topic.countByCreatedBy(user)
        }

    }
}
