package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.VO.RatingInfoVO


abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated


    static constraints = {
        dateCreated(date: Date, nullable: true)
        lastUpdated(date: Date, nullable: true)
    }
    static mapping = {
        description(sqlType: 'text')
    }
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static transients = ['ratinginfo']

/*     RatingInfoVO getRatingInfo(){
        List result = ResourceRating.createCriteria().list {
            projections{
                count("topic", 'topicCount')
                sum("score")
                avg("score")
            }
            groupProperty('topicCount',"topic")
        }
        new RatingInfoVO(totalVotes: result[0], totalScore: result[1], averageScore: result[2])
    }*/

    static List totalVotes() {
            List totalVoteCount = ResourceRating.createCriteria().list{
                projections {
                    count()
                }
                createAlias("resource",'r')
                groupProperty('r.topic')
                groupProperty('r.createdBy')
            }
        return totalVoteCount
    }

    static Integer totalScore(){
        Integer totalScoreCount= ResourceRating.createCriteria().get {
            projections{
                sum("score")
            }
        }
        return totalScoreCount
    }

    static Integer AvgScore(){
        Integer Avg=ResourceRating.createCriteria().get {
            projections{
                avg("score")
            }
        }
        return Avg
    }

    static namedQueries={
        search{ ResourceSearchCO rco ->
            if(rco.topicId){
                eq('topicId',rco.topicId)
            }
            if(rco.visibility)
            {
                eq('PUBLIC',rco.visibility)
            }

        }
    }

}

