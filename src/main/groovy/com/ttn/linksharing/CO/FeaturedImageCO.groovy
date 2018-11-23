package com.ttn.linksharing.CO

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class FeaturedImageCO implements Validateable {
    Long id
    MultipartFile featureImageFile
}
