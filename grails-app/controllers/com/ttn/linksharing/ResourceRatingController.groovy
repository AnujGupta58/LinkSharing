package com.ttn.linksharing

import grails.transaction.Transactional


class ResourceRatingController {

    def index() { }

    @Transactional
    def save(){
        Resource resource=Resource.findByCreatedBy(session.user)
        ResourceRating resourceRating = new ResourceRating(resource: resource,user: session.user, score: params.score)
        if(resourceRating.save(flush:true,failOnError:true)){
            flash.message="Rating is successfully saved"
            log.info("resource rating is done")
        }
        else{
            resourceRating.errors.allErrors.collect {message(code: it)}.join(",")
            flash.error="Unable to rate"
            log.info("unable to give rating")
        }
    }
}
