package com.example.pingresultsweb.repository;

import com.example.pingresultsweb.entity.PingRequest;
import com.example.pingresultsweb.entity.TestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PingRequestRepository extends JpaRepository<PingRequest, Long> {
    List<PingRequest> findByHostContainingIgnoreCaseOrIpAddressContainingIgnoreCase(String host, String ipAddress);
    List<PingRequest> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<PingRequest> findByTestStatus(TestStatus testStatus);
}
