package linksharing

import com.ttn.linksharing.DocumentResource
import com.ttn.linksharing.LinkResource
import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User

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
        List<User> users = createUsers()
        List<Topic> topics = createtopics(users)
        List<Resource> resources = createResources(topics)
        List<Subscription> subscriptionList = subscribeTopic(users)
        List<ReadingItem> readingItem = createReadingitem(resources)
        List<ResourceRating> resourceRatingList = createResourceRating(resources)

    }

    List<User> createUsers() {
        int count = 0
        List users = []
        User adminUser = new User(email: "admin@tothenew.com", password: "admin", confirmPassword: "admin", firstName: "firstadmin", lastName: "lastadmin", admin: true, isActive: true, photo: null)
        adminUser.save(failOnError: true, flush: true)
        users.add(adminUser)
        log.info "AdminUser ${adminUser} is successfully added.. "
        if (User.count() == 1) {
            (1..3).each {
                User user = new User(email: "user${it}@tothenew.com", confirmPassword: "qwerty${it}", password: "qwerty${it}", firstName: "userfirst${it}", lastName: "userlast${it}", admin: false, isActive: false, photo: null)
                if (user.save(failOnError: true, flush: true)) {
                    users.add(user)
                    log.info "User ${user} is successfully added.. "
                } else {
                    log.error "Error in creating user : ${log.error.allErrors}"
                }
            }
            count++
            println "count is " + count
        }
        return users
    }

    List<Topic> createtopics(List<User> users) {
        // int count=0
        List topics = []
        //    if (User.first() == User.listOrderByFirstName()) {
        if (Topic.count() == 0) {
            users.each { User user ->
                (1..5).each {
                    Topic topic = new Topic(name: "Topic${it}", visibility: Topic.Visibility.PUBLIC, createdBy: user)
                    if (topic.save(failOnError: true, flush: true)) {
                        topics.add(topic)
                        log.info "Topic ${topic} is successfully added.."
                    } else {
                        log.error "Error in creating topic : ${log.error.allErrors}"
                    }
                }
            }
        }
        return topics
    }

    List createResources(List<Topic> topics) {
        //  List<User> users
        List resources = []
        topics.each { Topic topic ->
            (1..2).each {
                LinkResource linkResource = new LinkResource(url: "https://www.google.com/", createdBy: topic.createdBy, description: topic.name, topic: topic)
                if (linkResource.save(failOnError: true)) {
                    resources.add(linkResource)
                    log.info "Resource ${linkResource} is created successfully"
                } else {
                    log.error "Error in creating linkResource : ${linkResource.errors.allErrors}"
                }
                DocumentResource documentResource = new DocumentResource(filepath: "/home/anuj/Desktop/Document", createdBy: topic.createdBy, description: topic.name, topic: topic)
                if (documentResource.save()) {
                    resources.add(documentResource)
                    log.info "Resource ${documentResource} is created successfully"
                    println "PRINTED........"
                } else {
                    log.error "Error in creating linkResource : ${documentResource.errors.allErrors}"
                }
            }
        }
        return resources
    }


    List<Subscription> subscribeTopic(List<User> users) {
        List subscribe = []
        users.each { User user ->
            Topic.findAllByCreatedByNotEqual(user).each { Topic topic ->
                Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.Seriousness.SERIOUS)
                if (subscription.save(failOnError: true, flush: true)) {
                    subscribe.add(subscription)
                    log.info "Subscription ${subscription} is done"
                } else {
                    log.error "Error assigning subscription ${subscription.errors.allErrors}"
                }

            }
        }
        return subscribe
    }


    List<ReadingItem> createReadingitem(List<Resource> resources) {
        List readingItems = []
        resources.each { Resource resource->
                ReadingItem readingItem = new ReadingItem(user: resource.createdBy, isRead: true,resource: resource )
                if (readingItem.save(failOnError: true, flush: true)) {
                    readingItems.add(readingItem)
                    log.info "Reading item : ${readingItem} is created successfully"
                } else {
                    log.error "Error in creating ReadingItem : ${readingItem.errors.allErrors} "
                }
            }
        return readingItems
    }


    List<ResourceRating> createResourceRating(List<Resource> resources) {
        List resourcerating = []
        println("====================================================================")
        resources.each { Resource resource ->
            println ">>>>>>>>>${resource.id}<<<<<<<<<<<<<<<<<${resource.createdBy.id}"
            ResourceRating resourceRating = new ResourceRating(user: resource.createdBy, resource: resource, score: 5)
            if (resourceRating.save(failOnError: true, flush: true)) {
                resourcerating.add(resourceRating)
                log.info "Resource rating ${resourceRating} is given"
            } else {
                log.error "Error in giving Resourse Rating ${resourceRating.errors.allErrors}"
            }
        }
        return resourcerating
    }

    /*   def subscribeItself(List<Resource> resources){
           resources.each {
               res=it
               Topic t=it.topic
               User user=t.getSubscriptions()

               user.each {

               }
           }
       }*/

    /* def subscribeOther(List<Resource> resources){
         Resource resource=Resource.findAllByCreatedBy()
     }
 */

    def destroy = {
    }

}
