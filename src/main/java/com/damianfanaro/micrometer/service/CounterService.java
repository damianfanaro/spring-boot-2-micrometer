package com.damianfanaro.micrometer.service;

import com.weekendesk.micrometer.core.event.EventHandleDurationMeasured;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CounterService {

    private final AtomicLong counter = new AtomicLong(0);

    @EventHandleDurationMeasured(event = "counterIncremented")
    public long incrementAndGet() {
        return counter.incrementAndGet();
    }

    @EventHandleDurationMeasured(event = "counterChanged")
    public void set(Long newValue) {
        counter.set(newValue);
    }

}
