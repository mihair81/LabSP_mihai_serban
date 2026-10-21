package org.example.controllers;

import org.example.difexamples.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent client1;
    private final ClientComponent client2;

    @Autowired
    public HelloController(ClientComponent client1, ClientComponent client2) {
        this.client1 = client1;
        this.client2 = client2;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String helloClient() {
        return "Hello from ClientComponent = " + client1;
    }

    @GetMapping("/clients")
    public String clients() {
        return "client1 = " + client1 + "<br>client2 = " + client2
                + "<br>aceeasi instanta? " + (client1 == client2);
    }
}