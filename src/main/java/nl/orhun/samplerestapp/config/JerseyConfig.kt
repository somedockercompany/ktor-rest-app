package nl.orhun.samplerestapp.config

import org.glassfish.jersey.server.ResourceConfig
import javax.ws.rs.ApplicationPath

@ApplicationPath("/rest/*")
class JerseyConfig : ResourceConfig() {

    init {
        packages(true, "nl.orhun")
    }

}