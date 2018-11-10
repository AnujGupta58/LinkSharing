package com.ttn.linksharing.CO

import com.ttn.linksharing.Topic
import grails.validation.Validateable

class ResourceSearchCO extends SearchCO implements Validateable{
    Long topicId
    Topic.Visibility visibility

    static namedQueries={
        search{ResourceSearchCO rco ->
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
