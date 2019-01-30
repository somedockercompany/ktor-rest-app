package nl.orhun.samplerestapp

import io.undertow.Handlers
import io.undertow.Undertow
import io.undertow.server.handlers.resource.ClassPathResourceManager
import io.undertow.util.Headers

fun main() {
    val server = Undertow.builder()
            .addHttpListener(8090, "localhost")
            .setHandler(Handlers.path().addExactPath("/") {
                it.responseHeaders.put(Headers.CONTENT_TYPE, "application/json")
                it.responseSender.send("""{ "text": "Hello world!" }""")
            }.addPrefixPath("/", Handlers.resource(ClassPathResourceManager(Thread.currentThread().contextClassLoader, "public")))
            ).build()
    server.start()
}