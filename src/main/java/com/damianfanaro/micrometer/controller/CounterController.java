package com.damianfanaro.micrometer.controller;

import com.damianfanaro.micrometer.service.CounterService;
import com.weekendesk.micrometer.core.http.HttpRequestDurationMeasured;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import static com.weekendesk.micrometer.core.http.HttpRequestDurationMeasured.Method.GET;
import static com.weekendesk.micrometer.core.http.HttpRequestDurationMeasured.Method.POST;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @Timed
    @GetMapping
    @HttpRequestDurationMeasured(method = GET, path = "/counter")
    public long incrementAndGetCurrentCounter() {
        return counterService.incrementAndGet();
    }

    @Timed
    @PostMapping("/{newValue}")
    @HttpRequestDurationMeasured(method = POST, path = "/counter/{newValue}")
    public void setCounter(@PathVariable Long newValue) {
        counterService.set(newValue);
    }

}
