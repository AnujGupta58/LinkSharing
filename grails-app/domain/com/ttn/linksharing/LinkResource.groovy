package com.ttn.linksharing

class LinkResource extends Resource{
    String url

    @Override
    String toString() {
        return "url ${url}"
    }
    static constraints = {
        url(url: true)
    }

    @Override
    def getType() {
        return true
    }

    @Override
    def deleteFile() {
        return null
    }
}
