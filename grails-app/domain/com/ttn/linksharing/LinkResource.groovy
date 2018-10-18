package com.ttn.linksharing

class LinkResource extends Resource{
    String URL

    
    static constraints = {
        URL(url: validate())
    }
}
