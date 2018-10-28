package com.ttn.linksharing


class ResourceController {

    def index() {
        render "index"
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
}
