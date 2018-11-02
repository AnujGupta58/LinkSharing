package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.CO.SearchCO
import com.ttn.linksharing.VO.RatingInfoVO


class ResourceController {

    def index() {
        render "index"
    }

    def trying(){
        render "text"
    }
    def delete(Long id) {
        Resource resource = Resource.get(id)
        try {
            if (resource.id == id) {
                resource.delete()
                render "Resource Deleted"
            }
        } catch (Exception e) {
            e.printStackTrace()
        }

    }

    def show(){
        List votes=Resource.totalVotes()
        Integer score=Resource.totalScore()
        Integer avgscore=Resource.AvgScore()
        List counter=Topic.getTrendingTopics()
        render "TOTAL SCORE ${score} and VOTES ${votes} and AVG_SCORE ${avgscore}   and TRENDING TOPICS ${counter}"

      /*  RatingInfoVO ratingInfo=Resource.getRatingInfo()
        render "Info  ${ratingInfo}"*/
    }

    def topPost(){
        if(session.user)
        {
            List votes=Resource.totalVotes()
            render "TOP POST --> ${votes}"
        }
    }

    def search(){
      //  Resource resource = Resource.findByTopic(Topic.findByVisibility(Topic.Visibility.PUBLIC))
        if(SearchCO.q)
        {
            ResourceSearchCO.visibility= Topic.Visibility.PUBLIC
        }
    }
}
