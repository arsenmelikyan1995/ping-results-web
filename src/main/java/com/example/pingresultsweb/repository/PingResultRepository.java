package com.example.pingresultsweb.repository;

import com.example.pingresultsweb.entity.PingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PingResultRepository extends JpaRepository<PingResult, Long> {

    List<PingResult> findByIpAddressContainingOrDomainNameContaining(String query, String query1);

    List<PingResult> findByTestDateBetween(Date startDate, Date endDate);

    List<PingResult> findByTestStatus(String testStatus);

}
