package com.ttn.linksharing

class LinkResourceController {

    def index() {
        render("LinkResourceController index")
    }

    def create() {
        User user = session.user
        if (session.user) {
            Topic topic = Topic.findByName(params.name)
            Resource linkResource = new LinkResource(topic: topic, createdBy: user, description: params.description, url: params.link)
            linkResource.save(flush: true, failOnError: true)
            render "LinkResource created successsfully"
        }
    }
}
