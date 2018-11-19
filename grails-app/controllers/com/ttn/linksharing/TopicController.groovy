package com.ttn.linksharing

import com.ttn.linksharing.DTO.EmailDTO
import com.ttn.linksharing.VO.ResourceVO
import com.ttn.linksharing.VO.UserVO
import com.ttn.linksharing.VO.TopicVO

//@Transactional
class TopicController {

    TopicService topicService

    def index() {
        render "Topic Index"
    }

    def show(Long id) {
        Topic topic = Topic.findById(id)
        TopicVO topicVO = new TopicVO(id: id, name: topic.name, createdBy: topic.createdBy, visibility: topic.visibility, subscriptionsCount: topic.subscriptions.size(), resourcesCount: topic.resources.size())

        List<Subscription> subscribedUsers = Subscription.findAllByTopic(topic)
        List<UserVO> subscribedUsersList = []
        subscribedUsers.each {
            subscribedUsersList.add(new UserVO(name: it.user.firstName, email: it.user.email, subscriptionCount: it.user.subscriptionCount, resourceCount: it.user.resources.size()))
        }

        List<Resource> resourceList = Resource.findAllByTopic(topic)
        List<ResourceVO> topicResource = []
        resourceList.each {
            topicResource.add(new ResourceVO(resourceId: it.id, topicName: it.topic.name, description: it.description, createdByName: it.createdBy.firstName, createdByEmail: it.createdBy.email, isLink: it.getType()))
        }

        render(view: 'showTopic', model: [topicVO: topicVO, subscribedUsersList: subscribedUsersList, topicResource: topicResource])
    }

    def delete(Long id) {
        Topic topic = Topic.get(id)
        if (topic) {
            topic.delete()
            flash.message = 'Topic Deleted'
            log.info('Topic Deleted')
            redirect(controller: 'user', action: 'profile')

        } else {
            flash.error = "Topic not found"
            log.info("Topic not found")
            render("Topic not found")
        }

    }

    def topicResource(Long topicId) {
        Topic topic = Topic.get(topicId)
        List<Resource> resources = []
        if (topic.isPublic(topic)) {
            List resource = Resource.findAllByTopic(topic)
            resource.each {
                resources.add(it)
            }
        } else if (session.user && Subscription.findByUserAndTopic(session.user, topic)) {
            List resource = Resource.findAllByTopic(topic)
            resource.each {
                resources.add(it)
            }
        }
        render(view: 'res',)
    }

    def save() {
        User user = session.user
        log.info("Current Logged In User : ${user?.firstName}")
        if (session.user) {
            Topic topic = new Topic(name: params.topicName, visibility: params.visibility, createdBy: user)
            if (topic.save(flush: true, failOnError: true)) {
                flash.message = "Topic Saved Successfully"
                redirect(controller: 'user', action: 'index')
            } else {
                flash.error = "Topic not saved successfully"
                topic.errors.allErrors.collect { message(code: it) }.join(",")
            }
        }
    }

    def editTopic() {
        User user = session.user
        Topic topic = Topic.get(params.id)
        if (topic) {
            topic.name = params.name
            topic.visibility = params.visibility
            if (topic.save(flush: true)) {
                flash.message = "Topic name and visibility updated succcessfully"
                log.info("Topic name and visibility updated succcessfully")
                redirect(controller: 'user', action: 'profile')
            } else {
                flash.error = 'topic.errors.allErrors.collect{message(code: it)}.join(",")'
                log.info("Topic cannot be updated")
            }
        } else {
            flash.error = "Topic not found"
        }
    }

    def inviteAction(EmailDTO emailDTO,Long id){
        Topic topic = Topic.get(id)
        if(topic && session.user){
            sendMail {
                to "${emailDTO.to}"
                subject "${emailDTO.subject}"
                text"${emailDTO.model}"
            }
        }
    }
}

