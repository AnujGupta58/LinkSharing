package com.ttn.linksharing

import com.ttn.linksharing.CO.ResourceSearchCO
import com.ttn.linksharing.VO.RatingInfoVO


abstract class Resource {

    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastUpdated

    abstract getType();

    abstract deleteFile();

    static constraints = {
        dateCreated(date: Date, nullable: true)
        lastUpdated(date: Date, nullable: true)
    }
    static mapping = {
        description(sqlType: 'text')
        readingItems cascade: 'all-delete-orphan'
        ratings cascade: 'all-delete-orphan'
    }
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]
    static belongsTo = [topic: Topic, createdBy: User]
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
        List totalVoteCount = ResourceRating.createCriteria().list {
            projections {
                count()
            }
            createAlias("resource", 'r')
            groupProperty('r.topic')
            groupProperty('r.createdBy')
        }
        return totalVoteCount
    }

    static Integer totalScore() {
        Integer totalScoreCount = ResourceRating.createCriteria().get {
            projections {
                sum("score")
            }
        }
        return totalScoreCount
    }

    static Integer AvgScore() {
        Integer Avg = ResourceRating.createCriteria().get {
            projections {
                avg("score")
            }
        }
        return Avg
    }

    static List getTopPost() {
        List topPost = ResourceRating.createCriteria().list {
            projections {
                createAlias('resource', 'r')
                groupProperty('r.id')
                count('r.id', 'count')
            }
            order('count', 'desc')
        }
        return topPost
    }

    static List getrecentShare() {
        List recentShare = Resource.createCriteria().list {
            projections {
                order("dateCreated", "desc")
            }
            maxResults(3)
        }
        return recentShare
    }

    def canViewBy() {
        if (this.topic.canViewedBy(session.user)) {
            log.info("resource can be viewed")
        }

    }


    static namedQueries = {
        search { ResourceSearchCO rco ->
            if (rco.topicId) {
                eq('topicId', rco.topicId)
            }
            if (rco.visibility) {
                eq('PUBLIC', rco.visibility)
            }

        }
    }

}

