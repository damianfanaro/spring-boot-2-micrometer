package com.damianfanaro.micrometer.meter;

import com.weekendesk.micrometer.spring.EnableWeekendeskMetrics;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWeekendeskMetrics
public class MeterConfiguration {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}