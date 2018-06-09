package com.damianfanaro.micrometer.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private final AtomicLong counter = new AtomicLong(0);

    @Timed
    @GetMapping
    public long incrementAndGetCurrentCounter() {
        return counter.incrementAndGet();
    }

    @Timed
    @PostMapping("/{newValue}")
    public void setCounter(@PathVariable Long newValue) {
        counter.set(newValue);
    }

}
