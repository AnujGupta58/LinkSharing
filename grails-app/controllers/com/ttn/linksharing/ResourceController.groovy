package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.CO.SearchCO
import com.ttn.linksharing.VO.RatingInfoVO


class ResourceController {

    def index() {
        render "index"
    }

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
            if (resource.id == id) {
                resource.delete()
                //render "Resource Deleted"
                redirect(controller:'user',action:'index')
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    def show() {
        /*List votes=Resource.totalVotes()
        Integer score=Resource.totalScore()
        Integer avgscore=Resource.AvgScore()
        List counter=Topic.getTrendingTopics()
        render "TOTAL SCORE ${score} and VOTES ${votes} and AVG_SCORE ${avgscore}   and TRENDING TOPICS ${counter}"*/

        /*  RatingInfoVO ratingInfo=Resource.getRatingInfo()
          render "Info  ${ratingInfo}"*/
        render(view: '/resource/showResource',model: [resource:response])
    }

    def topPost() {
        if (session.user) {
            List votes = Resource.totalVotes()
            render "TOP POST --> ${votes}"
        }
    }

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
}
