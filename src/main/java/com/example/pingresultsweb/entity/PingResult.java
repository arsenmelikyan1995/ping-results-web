package com.example.pingresultsweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class PingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String domainName;
    private Date testDate;
    private String testStatus;
    private String pingResult;

    public PingResult() {
    }

    public PingResult(String ipAddress, String domainName, Date testDate, String testStatus, String pingResult) {
        this.ipAddress = ipAddress;
        this.domainName = domainName;
        this.testDate = testDate;
        this.testStatus = testStatus;
        this.pingResult = pingResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getPingResult() {
        return pingResult;
    }

    public void setPingResult(String pingResult) {
        this.pingResult = pingResult;
    }

}
