package com.example.pingresultsweb.service;

import com.example.pingresultsweb.entity.PingResult;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PingResultServiceTests {
    @Autowired
    private PingResultService service;

    @Test
    void testGetByIpAddressOrDomainName() {
        PingResult result1 = new PingResult("192.168.0.1", "example.com", new Date(), "true", "ping successful");
        PingResult result2 = new PingResult("192.168.0.2", "google.com", new Date(), "true", "ping successful");
        PingResult result3 = new PingResult("192.168.0.3", "example.com", new Date(), "false", "ping timed out");

        service.save(result1);
        service.save(result2);
        service.save(result3);

        List<PingResult> results = service.getByIpAddressOrDomainName("example.com");

        assertEquals(2, results.size());
        assertTrue(results.contains(result1));
        assertTrue(results.contains(result3));
    }

    @Test
    void testGetByTestDateRange() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2022-01-01");
        Date end = sdf.parse("2022-01-31");

        PingResult result1 = new PingResult("192.168.0.1", "example.com", sdf.parse("2022-01-05"), "true", "ping successful");
        PingResult result2 = new PingResult("192.168.0.2", "google.com", sdf.parse("2022-02-01"), "true", "ping successful");
        PingResult result3 = new PingResult("192.168.0.3", "example.com", sdf.parse("2022-01-15"), "false", "ping timed out");

        service.save(result1);
        service.save(result2);
        service.save(result3);

        List<PingResult> results = service.getByTestDateRange(start, end);

        assertEquals(2, results.size());
        assertTrue(results.contains(result1));
        assertTrue(results.contains(result3));
    }

    @Test
    void testGetByTestStatus() {
        PingResult result1 = new PingResult("192.168.0.1", "example.com", new Date(), "true", "ping successful");
        PingResult result2 = new PingResult("192.168.0.2", "google.com", new Date(), "true", "ping successful");
        PingResult result3 = new PingResult("192.168.0.3", "example.com", new Date(), "false", "ping timed out");

        service.save(result1);
        service.save(result2);
        service.save(result3);

        List<PingResult> results = service.getByTestStatus("ping timed out");

        assertEquals(1, results.size());
        assertTrue(results.contains(result3));
    }
}
