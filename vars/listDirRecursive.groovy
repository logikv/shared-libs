def call(Map config = [:]){
    sh "ls ${isRecursive(config.recursive)} ${config.dir}"
}


def isRecursive(def defined) { defined ? "-lRa" : "-la" }
