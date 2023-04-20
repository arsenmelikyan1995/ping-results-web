package com.example.pingresultsweb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ping_requests")
public class PingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TestStatus testStatus;

    @OneToOne(mappedBy = "pingRequest", cascade = CascadeType.ALL)
    private PingResult pingResult;

    public PingRequest() {
    }

    public PingRequest(String host, String ipAddress, LocalDateTime date, TestStatus testStatus,
            PingResult pingResult) {
        this.host = host;
        this.ipAddress = ipAddress;
        this.date = date;
        this.testStatus = testStatus;
        this.pingResult = pingResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TestStatus getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(TestStatus testStatus) {
        this.testStatus = testStatus;
    }

    public PingResult getPingResult() {
        return pingResult;
    }

    public void setPingResult(PingResult pingResult) {
        this.pingResult = pingResult;
    }
}
