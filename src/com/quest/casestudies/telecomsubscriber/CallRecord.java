package com.quest.casestudies.telecomsubscriber;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CallRecord implements Serializable {
    private String subscriberId;
    private String callType;
    private int duration;
    private LocalDateTime timestamp;

    public CallRecord(String subscriberId, String callType, int duration, LocalDateTime timestamp) {
        this.subscriberId = subscriberId;
        this.callType = callType;
        this.duration = duration;
        this.timestamp = timestamp;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CallRecord{" +
                "subscriberId='" + subscriberId + '\'' +
                ", callType='" + callType + '\'' +
                ", duration=" + duration +
                ", timestamp=" + timestamp +
                '}';
    }
}
