package com.example.pingresultsweb.service;

import com.example.pingresultsweb.entity.PingResult;
import com.example.pingresultsweb.repository.PingResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PingResultService {
    @Autowired
    private PingResultRepository repository;

    public List<PingResult> getAll() {
        return repository.findAll();
    }

    public Page<PingResult> getPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("testDate").descending());
        return repository.findAll(pageRequest);
    }

    public PingResult getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<PingResult> getByIpAddressOrDomainName(String query) {
        return repository.findByIpAddressContainingOrDomainNameContaining(query, query);
    }

    public List<PingResult> getByTestDateRange(Date startDate, Date endDate) {
        return repository.findByTestDateBetween(startDate, endDate);
    }

    public List<PingResult> getByTestStatus(String testStatus) {
        return repository.findByTestStatus(testStatus);
    }

    public void save(PingResult pingResult) {
        repository.save(pingResult);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
