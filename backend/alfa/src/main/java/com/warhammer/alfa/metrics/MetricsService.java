package com.warhammer.alfa.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;

    // Email metrics
    private final Counter emailsSentCounter;
    private final Counter emailsFailedCounter;
    private final Timer emailSendingTimer;

    // User metrics
    private final Counter userRegistrationsCounter;
    private final Counter userLoginsCounter;

    // API metrics
    private final Counter apiRequestsCounter;
    private final Timer apiResponseTimer;

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        
        this.emailsSentCounter = Counter.builder("emails.sent.total")
                .description("Total number of emails sent successfully")
                .register(meterRegistry);
        
        this.emailsFailedCounter = Counter.builder("emails.failed.total")
                .description("Total number of emails that failed to send")
                .register(meterRegistry);
        
        this.emailSendingTimer = Timer.builder("emails.sending.duration")
                .description("Time taken to send emails")
                .register(meterRegistry);
        
        this.userRegistrationsCounter = Counter.builder("users.registrations.total")
                .description("Total number of user registrations")
                .register(meterRegistry);
        
        this.userLoginsCounter = Counter.builder("users.logins.total")
                .description("Total number of user logins")
                .register(meterRegistry);
        
        this.apiRequestsCounter = Counter.builder("api.requests.total")
                .description("Total number of API requests")
                .register(meterRegistry);
        
        this.apiResponseTimer = Timer.builder("api.response.duration")
                .description("API response time")
                .register(meterRegistry);
    }

    public void incrementEmailsSent() {
        emailsSentCounter.increment();
    }

    public void incrementEmailsFailed() {
        emailsFailedCounter.increment();
    }

    public Timer.Sample startEmailSendingTimer() {
        return Timer.start(meterRegistry);
    }

    public void stopEmailSendingTimer(Timer.Sample sample) {
        sample.stop(emailSendingTimer);
    }

    public void incrementUserRegistrations() {
        userRegistrationsCounter.increment();
    }

    public void incrementUserLogins() {
        userLoginsCounter.increment();
    }

    public void incrementApiRequests() {
        apiRequestsCounter.increment();
    }

    public Timer.Sample startApiResponseTimer() {
        return Timer.start(meterRegistry);
    }

    public void stopApiResponseTimer(Timer.Sample sample) {
        sample.stop(apiResponseTimer);
    }
} 