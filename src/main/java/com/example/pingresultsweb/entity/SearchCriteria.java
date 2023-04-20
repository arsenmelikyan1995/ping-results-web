package com.example.pingresultsweb.entity;

import java.time.LocalDateTime;

public class SearchCriteria {
    private String hostOrIpAddress;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TestStatus testStatus;

    public SearchCriteria() {
    }

    public SearchCriteria(String hostOrIpAddress, LocalDateTime startDate, LocalDateTime endDate,
            TestStatus testStatus) {
        this.hostOrIpAddress = hostOrIpAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.testStatus = testStatus;
    }

    public String getHostOrIpAddress() {
        return hostOrIpAddress;
    }

    public void setHostOrIpAddress(String hostOrIpAddress) {
        this.hostOrIpAddress = hostOrIpAddress;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public TestStatus getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(TestStatus testStatus) {
        this.testStatus = testStatus;
    }
}
