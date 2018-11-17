package com.ttn.linksharing

class DocumentResource extends Resource {
    String filepath
    String fileName

    @Override
    String toString() {
        return "filePath ${filepath}"
    }
    static transients = ['fileName']
    static constraints = {
    }

    @Override
    def deleteFile() {
        String file=this.filepath
        if(new File(file).delete()){
            return true
        }
    }

    @Override
    def getType() {
        return false
    }
}
