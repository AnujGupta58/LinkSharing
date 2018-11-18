package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceCO
import com.ttn.linksharing.VO.UserVO
import com.ttn.linksharing.VO.TopicVO
import grails.transaction.Transactional


class UserController {

    def auth(){
        def user=User.findByEmailAndPassword(params.email,params.password)
        if(user)
        {
            session.user=user
            flash.message="Hello ${user.email}"
            redirect(controller: 'user',action:'index')
        }
    }

  /*  def fetchImage(){
        User user=User.findById(params.id)
        if(user){
            if(user.photo){
                render(user.photo)
            }
        }
    }*/


    def index() {
        /*    List UnReadItemLeft=User.getUnReadResource(co,session.user)
            render "UnReadResources --->  ${UnReadItemLeft}"*/
            render (view: "index")
    }

    def show(Integer id) {
        Topic topic = Topic.get(id)
        if (topic) {
            if (topic.visibility == Topic.Visibility.PUBLIC) {
                render "Success"
            } else {
                User user = session.user
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                if (subscriptionCount) {
                    render "success"
                } else {
                    redirect(controller: 'login', action: 'index')
                }
            }
        }
        else {
            redirect(controller: 'login', action: 'index')
        }
    }

    @Transactional
    def updateUserInfo(){
        User user=User.findByEmail(session.user.email)
        user.firstName=params.firstName
        user.lastName=params.lastName
        user.photo=params.photo
        if(user.save(flush:true)){
            log.info("updated successfully")
            flash.message='fields updated successfully'
//            return true
            redirect(action: "profile")
        }
        else{
            log.info("cannot update")
            user.errors.allErrors.collect {message(code: it)}.join(",")
            return false
        }
    }

    @Transactional
    def changePassword(){
        User user=User.findByEmail(session.user.email)
        user.password=params.password
        user.confirmPassword=params.confirmpassword
        if(user.save(flush:true)){
            flash.message="Password updated Successfully"
            log.info("updated successfully")
            redirect(controller: 'user', action: 'profile')
        }
        else{
            flash.error="Password cannot be updated"
            log.info("cannot update")
            user.errors.allErrors.collect {message(code: it)}.join(",")
            redirect(controller: 'user', action: 'profile')
        }

    }

    def profile(){
        User user=User.findByEmail(session.user.email)
        UserVO userInfo= new UserVO(name: user.getFullName(),email: user.email,topicCount: user.topics.size(),resourceCount: user.resources.size(),subscriptionCount: user.subscriptions.size())

        List topicList=Topic.findAllByCreatedBy(user)
        List<TopicVO> userTopicList=[]
        topicList.each {
            userTopicList.add(new TopicVO(id: it.id, name: it.name,email: it.createdBy.email, createdBy: it.createdBy, visibility: it.visibility,resourcesCount: it.resources.size(),subscriptionsCount: it.subscriptions.size()))
        }

        List resourceList=Resource.findAllByCreatedBy(user)
        List<ResourceCO> userResourceList=[]
        resourceList.each {
            userResourceList.add(new ResourceCO(resourceId: it.id,topicId: it.topic.id, topicName: it.topic.name,description: it.description,createdBy: it.createdBy.getFullName()))
        }

        render(view:'/user/profile', model: [userInfo:userInfo,userTopicList:userTopicList,userResourceList:userResourceList])
    }



    def showAllUsers(){
        List<User> users= User.findAllByAdmin(false)
        List<UserVO> userList=[]
        users.each{
            userList.add(new UserVO(id: it.id, name: it.getFullName(),email: it.email, isActive: it.isActive,topicCount: it.topics.size(),resourceCount: it.resources.size(),subscriptionCount: it.subscriptions.size()))
        }
        render (view: '/user/userList', model: [userList:userList])
    }

    def changeActive(Long id){
        User user = User.get(id)
        if(user.isActive){
            user.isActive=false
            if(user.save(flush:true)){
                flash.message="User is deactivated"
                log.info("User is deactivated")
                redirect(controller: 'user' , action: 'showAllUsers')
                return true
            }
            else{
                flash.error="Error in deactivating"
                log.info("Error in deactivating")
                return false
            }
        }
        else {
            user.isActive=true
            if(user.save(flush:true)){
                flash.message="User is Activated"
                log.info("User is Activated")
                redirect(controller: 'user' , action: 'showAllUsers')
                return true
            }
            else{
                flash.error="Error in Activating"
                log.info("Error in Activating")
                return false
            }
        }
    }
}
