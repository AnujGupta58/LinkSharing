package linksharing


import groovy.util.logging.Slf4j

@Slf4j
class UtilController {

    def index() {
        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Indexing")
        log.info(params.toQueryString())
        render "Started"
    }

    def show(){
        log.info("ShowMethod")
        log.trace("Trace Message!");
        log.debug("Debug Message!");
    }
}
