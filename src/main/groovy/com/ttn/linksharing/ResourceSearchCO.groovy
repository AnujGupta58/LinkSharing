package com.ttn.linksharing

class ResourceSearchCO extends SearchCO{
    Long topicId
    Topic.Visibility visibility

    static namedQueries={
        search{ResourceSearchCO rco ->
            if(rco.topicId){
                eq('topicId',rco.topicId)
            }
            if(rco.visibility)
            {
                eq('Visibility',rco.visibility)
            }

        }
    }
}
