package com.ttn.linksharing

class ResourceRatingController {

    def index() { }

    def save(){
        Resource resource=Resource.findByCreatedBy(session.user)
        ResourceRating resourceRating = new ResourceRating(resource: resource,user: session.user, score: params.score)
        if(resourceRating.save(flush:true,failOnError:true)){
            log.info("resource rating is done")
        }
        else{
            resourceRating.errors.allErrors.collect {message(code: it)}.join(",")
            log.info("unable to give rating")
        }
    }
}
