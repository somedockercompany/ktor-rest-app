package nl.orhun.samplerestapp

import io.undertow.Handlers
import io.undertow.Undertow
import io.undertow.servlet.Servlets
import io.undertow.servlet.Servlets.servlet
import nl.orhun.samplerestapp.config.JerseyConfig
import org.glassfish.jersey.servlet.ServletContainer
import org.jboss.weld.environment.servlet.Listener

fun main() {
    val servletBuilder = Servlets.deployment()

    servletBuilder.setClassLoader(ClassLoader.getSystemClassLoader())
            .setContextPath("/app")
            .setDeploymentName("app.war")
            .addListener(Servlets.listener(Listener::class.java))
            .addServlets(
                    servlet("jerseyServlet", ServletContainer::class.java)
                            .setLoadOnStartup(1)
                            .addInitParam("javax.ws.rs.Application", JerseyConfig::class.java.name)
                            .addMapping("/rest/*")
            )

    val manager = Servlets.defaultContainer().addDeployment(servletBuilder)
    manager.deploy()

    val path = Handlers.path(Handlers.redirect("/app"))
            .addPrefixPath("/app", manager.start())

    val server = Undertow.builder()
            .addHttpListener(8090, "localhost")
            .setHandler(path)
            .build()
    server.start()
}