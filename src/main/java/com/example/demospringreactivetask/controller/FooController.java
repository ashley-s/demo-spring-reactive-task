package com.example.demospringreactivetask.controller;

import com.example.demospringreactivetask.domain.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
public class FooController {

    @GetMapping(value = "/foos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> getFoos() {
        return Flux.interval(Duration.of(1, ChronoUnit.SECONDS))
                .log()
                .map(aLong -> Foo.builder().id(UUID.randomUUID().toString()).name("TEST").build());
    }
}
