package linksharing

import com.ttn.linksharing.DocumentResource
import com.ttn.linksharing.LinkResource
import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enumeration.Visibility

class BootStrap {

    def init = { servletContext ->
        /*    User adminUser = new User(email: "anujgupta@tothenew.com", confirmPassword: "qwerty", password: "qwerty", firstName: "Anuj", lastName: "Gupta", admin: true, isActive: false, photo: null)
            adminUser.save(failOnError: true, flush: true)
            if (adminUser.save()) {
                log.info "User ${admin} is successfully added.. "
            } else {
                log.error "Error in creating admin"
            }

            User user = new User(email: "aman.gupta@gmail.com", confirmPassword: "1234567", password: "1234567", firstName: "Aman", lastName: "Gupta", admin: false, isActive: false, photo: null)
            normal.save(failOnError: true, flush: true)

            if (user.save()) {
                log.info "User ${user} is successfully added.. "
            } else {
                log.error "Error in creating normal user ${user}"
            }*/
        createUsers()
        createTopics()
        createResources()
        subscribeTopic()
        createReadingitem()
        createResourceRating()

    }

    void createUsers() {
        if (!User.countByEmail("admin@tothenew.com")) {
            User adminUser = new User(email: "admin@tothenew.com", password: "admin", confirmPassword: "admin", firstName: "firstadmin", lastName: "lastadmin", admin: true, isActive: true, photo: null)
            adminUser.save(failOnError: true, flush: true)
        }
        if (!User.countByEmailNotEqual("admin@tothenew.com")) {
            (1..3).each {
                User user = new User(email: "user${it}@tothenew.com", confirmPassword: "qwerty${it}", password: "qwerty${it}", firstName: "userfirst${it}", lastName: "userlast${it}", admin: false, isActive: false, photo: null)
                if (user.save(failOnError: true, flush: true)) {
                    log.info "User ${user} is successfully added.. "
                } else {
                    log.error "Error in creating user : ${log.error.allErrors}"
                }
            }
        }
    }

    void createTopics() {
        List<User> users = User.list()
        if (Topic.count() == 0) {
            users.each { User user ->
                (1..5).each {
                    Topic topic = new Topic(name: "Topic${it}", visibility: Visibility.PUBLIC, createdBy: user)
                    if (topic.save(flush: true)) {
                        log.info "Topic ${topic} is successfully added.."
                    } else {
                        log.error "Error in creating topic : ${log.error.allErrors}"
                    }
                }
            }
        }
    }

    void createResources() {
        List<Topic> topics = Topic.list()
        if (Resource.count() == 0) {
            topics.each { Topic topic ->
                (1..2).each {
                    LinkResource linkResource = new LinkResource(url: "https://www.google.com/", createdBy: topic.createdBy, description: topic.name, topic: topic)
                    if (linkResource.save(failOnError: true)) {
                        log.info "Resource ${linkResource} is created successfully"
                    } else {
                        log.error "Error in creating linkResource : ${linkResource.errors.allErrors}"
                    }
                    DocumentResource documentResource = new DocumentResource(filepath: "/home/anuj/Desktop/Document", createdBy: topic.createdBy, description: topic.name, topic: topic)
                    if (documentResource.save()) {
                        log.info "Resource ${documentResource} is created successfully"
                        println "PRINTED........"
                    } else {
                        log.error "Error in creating linkResource : ${documentResource.errors.allErrors}"
                    }
                }
            }
        }
    }


    void subscribeTopic() {
        List<User> users = User.list()
        if (Subscription.count() == 0) {
            users.each { User user ->
                Topic.findAllByCreatedByNotEqual(user).each { Topic topic ->
                    Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.Seriousness.SERIOUS)
                    if (subscription.save(failOnError: true, flush: true)) {
                        log.info "Subscription ${subscription} is done"
                    } else {
                        log.error "Error assigning subscription ${subscription.errors.allErrors}"
                    }

                }
            }
        }
    }


    void createReadingitem() {
        List<Resource> resources = Resource.list()
        if (ReadingItem.count() == 0) {
            resources.each { Resource resource ->
                ReadingItem readingItem = new ReadingItem(user: resource.createdBy, isRead: true, resource: resource)
                if (readingItem.save(failOnError: true, flush: true)) {
                    log.info "Reading item : ${readingItem} is created successfully"
                } else {
                    log.error "Error in creating ReadingItemVO : ${readingItem.errors.allErrors} "
                }
            }
        }
    }


    void createResourceRating() {
        List<Resource> resources = Resource.list()
        if (ResourceRating.count() == 0) {
            resources.each { Resource resource ->
                ResourceRating resourceRating = new ResourceRating(user: resource.createdBy, resource: resource, score: 5)
                if (resourceRating.save(failOnError: true, flush: true)) {
                    log.info "Resource rating ${resourceRating} is given"
                } else {
                    log.error "Error in giving Resourse Rating ${resourceRating.errors.allErrors}"
                }
            }
        }
    }


    def destroy = {
    }

}
