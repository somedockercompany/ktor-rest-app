package nl.orhun.samplerestapp.config

import javax.annotation.PostConstruct
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@ApplicationScoped
@Path("")
class HelloWorldResource {

    @PostConstruct
    fun postConstruct() {
        println("Constructing `HelloWorldResource.kt`")
    }

    @GET
    @Path("/helloworld")
    fun helloWorld(): Response {
        return Response.ok("Hey Hello World!").build()
    }
}