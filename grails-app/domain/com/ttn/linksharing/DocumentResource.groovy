package com.ttn.linksharing

class DocumentResource extends Resource {
    String filepath

    @Override
    String toString() {
        return "filePath ${filepath}"
    }
    static constraints = {
    }
}
