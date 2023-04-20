package com.example.pingresultsweb.service;

import com.example.pingresultsweb.entity.PingRequest;
import com.example.pingresultsweb.entity.TestStatus;
import com.example.pingresultsweb.repository.PingRequestRepository;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PingRequestService {
    @Autowired
    private PingRequestRepository pingRequestRepository;

    public void save(PingRequest pingRequest) {
        pingRequestRepository.save(pingRequest);
    }

    public List<PingRequest> search(String hostOrIpAddress, LocalDateTime startDate, LocalDateTime endDate, TestStatus testStatus) {
        List<PingRequest> results = new ArrayList<>();

        if (StringUtils.hasText(hostOrIpAddress)) {
            results.addAll(pingRequestRepository.findByHostContainingIgnoreCaseOrIpAddressContainingIgnoreCase(hostOrIpAddress, hostOrIpAddress));
        } else {
            results.addAll(pingRequestRepository.findAll());
        }

        if (startDate != null && endDate != null) {
            results = results.stream()
                    .filter(request -> request.getDate().isAfter(startDate) && request.getDate().isBefore(endDate))
                    .collect(Collectors.toList());
        }

        if (testStatus != null) {
            results = results.stream()
                    .filter(request -> request.getTestStatus() == testStatus)
                    .collect(Collectors.toList());
        }

        return results;
    }

    public PingRequest findById(Long id) {
        return pingRequestRepository.findById(id).orElse(null);
    }
}
