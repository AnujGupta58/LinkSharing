package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceCO
import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.VO.ResourceVO
import grails.transaction.Transactional



class ResourceController {

    def index() {
        render "index"
    }

    @Transactional
    def create() {
        User user = session.user
        if (session.user) {
            Topic topic = Topic.findByCreatedBy(user)
            Resource linkResource = new LinkResource(description: params.description, createdBy: user, topic: topic, url: params.url)
            linkResource.save(flush: true, failOnError: true)
            render "Resource created successfully"
        }
    }

    def delete(Long id) {
        Resource resource = Resource.get(id)
        try {
            if (resource) {
                if(resource.delete()){
                    resource.deleteFile()
                    //render "Resource Deleted"
                    flash.message="Resource Deleted"
                    log.info("Resource Deleted")
                    redirect(controller:'user',action:'index')
                }
                else {
                    flash.error="Resource cannot be Deleted"
                    log.info("Resource cannot be Deleted")
                }
            }
            else {
                flash.message="Resource not found"
                log.info("Resource not found")
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    def show() {
      /*  List votes=Resource.totalVotes()
        Integer score=Resource.totalScore()
        Integer avgscore=Resource.AvgScore()
        List counter=Topic.getTrendingTopics()*/
      //  render "TOTAL SCORE ${score} and VOTES ${votes} and AVG_SCORE ${avgscore}   and TRENDING TOPICS ${counter}"

        /*  RatingInfoVO ratingInfo=Resource.getRatingInfo()
          render "Info  ${ratingInfo}"*/

        Resource resource = Resource.findById(params.id)
        ResourceVO resourceDisplay= new ResourceVO(resourceId: resource.id, topicName: resource.topic.name, description: resource.description, createdByName: resource.createdBy.firstName,createdByEmail: resource.createdBy.email, isLink: resource.getType())
        render(view: '/resource/showResource',model: [resourceDisplay:resourceDisplay])
    }

    def topPost() {
        if (session.user) {
            List votes = Resource.totalVotes()
            render "TOP POST --> ${votes}"
        }
    }

 /*   def recentShare(){
        List resource= Resource.getrecentShare()
        List<ResourceVO> recentShares=[]
        resource.each {
            recentShares.add(new ResourceVO(topicName: resource.topic.name, description: resource.description, createdByName: resource.createdBy.firstName,createdByEmail: resource.createdBy.email))
        }

        render(view: '/layouts/main', model: [recentShares:recentShares])
    }*/

    def search(ResourceSearchCO resourceSearchCO) {
        //  Resource resource = Resource.findByTopic(Topic.findByVisibility(Topic.Visibility.PUBLIC))
        if (resourceSearchCO.q) {
            ResourceSearchCO.visibility = Topic.Visibility.PUBLIC
        }
        else{
            flash.error="criteria not set"
        }
    }

    def viewLink(Long id){
        LinkResource linkResource = Resource.get(id)
        if(linkResource){
            redirect(url:linkResource.url)
        }
    }

    def updateDescription(){
        Resource resource = Resource.get(params.id)
        if(resource){
            resource.description=params.description
            if(resource.save(flush:true)){
                flash.message="Description updated Successfully"
                log.info("Description updated Successfully")
                redirect(controller: 'user',action: 'profile')
            }
            else{
                flash.error="Description can't be updated"
                log.info("Description can't be updated")
                resource.errors.allErrors.collect{message(code: it)}.join(",")
                redirect(controller: 'user',action: 'profile')
            }
        }
        else {
            flash.error="resource not found"
            log.info("resource not found")
            redirect(controller: 'user',action: 'profile')
        }
    }


}
