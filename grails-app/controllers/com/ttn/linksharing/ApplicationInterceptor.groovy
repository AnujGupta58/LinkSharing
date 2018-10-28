package com.ttn.linksharing

class ApplicationInterceptor {

    boolean before() {
       /* log.info("---------/////////")
        log.info("${params}"+session["user"] )
        log.info("---------")*/
        log.info(">>>>>>>>>>>>> Before of Application Interceptor")
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
    public ApplicationInterceptor(){
        match(controller : "*")
    }
}
