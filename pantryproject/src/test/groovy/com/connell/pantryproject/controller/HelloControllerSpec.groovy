package com.connell.pantryproject.controller

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest

import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class HelloControllerSpec extends Specification {

    @Shared
    EmbeddedServer embeddedServer

    @Shared
    HttpClient client

    void setup() {
        embeddedServer = ApplicationContext.run(EmbeddedServer.class)
        client = HttpClient.create(embeddedServer.getURL())
    }

    void cleanup() {
        client.close()
        embeddedServer.close()
    }

    void 'can call hello world controller'() {
        when:
        String response = client.toBlocking().retrieve("/hello")

        then:
        response == "Hello World"
    }

}