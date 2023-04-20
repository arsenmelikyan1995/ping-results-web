package com.example.pingresultsweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ping_results")
public class PingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String result;

    @OneToOne
    @JoinColumn(name = "ping_request_id", referencedColumnName = "id")
    private PingRequest pingRequest;

    // constructors, getters and setters


    public PingResult() {
    }

    public PingResult(String result, PingRequest pingRequest) {
        this.result = result;
        this.pingRequest = pingRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PingRequest getPingRequest() {
        return pingRequest;
    }

    public void setPingRequest(PingRequest pingRequest) {
        this.pingRequest = pingRequest;
    }
}
