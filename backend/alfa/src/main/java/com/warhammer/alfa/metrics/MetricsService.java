package com.warhammer.alfa.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;

    // User metrics
    private final Counter userFailedRegistrationsCounter;
    private final Counter userFailedLoginsCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        
        this.userFailedRegistrationsCounter = Counter.builder("users.registrations.fails")
                .description("Total number of user registrations that ended with fail")
                .register(meterRegistry);
        
        this.userFailedLoginsCounter = Counter.builder("users.logins.fails")
                .description("Total number of user logins that ended with fail")
                .register(meterRegistry);
    }

    public void incrementUserRegistrations() {
        userFailedRegistrationsCounter.increment();
    }

    public void incrementUserLogins() {
        userFailedLoginsCounter.increment();
    }
} 