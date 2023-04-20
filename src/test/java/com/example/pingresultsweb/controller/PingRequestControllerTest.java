//package com.example.pingresultsweb.controller;
//
//import com.example.pingresultsweb.entity.PingRequest;
//import com.example.pingresultsweb.repository.PingRequestRepository;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class PingRequestControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private PingRequestRepository repository;
//
//    @LocalServerPort
//    private int port;
//
//    private String baseUrl;
//
//    @Before
//    public void setUp() {
//        baseUrl = "http://localhost:" + port;
//    }
//
//    @Test
//    public void testPingRequestController() {
//        PingRequest pingRequest = new PingRequest();
//        pingRequest.setHost("google.com");
//        pingRequest.setDate(LocalDateTime.now());
//        pingRequest.setStatus(PingStatus.SUCCESS);
//        pingRequest.setResult("Ping result");
//
//        PingRequest savedPingRequest = repository.save(pingRequest);
//
//        ResponseEntity<PingRequest> getResponse = restTemplate.getForEntity(baseUrl + "/ping/{id}", PingRequest.class, savedPingRequest.getId());
//        assertThat(getResponse.getStatusCode(), equalTo(HttpStatus.OK));
//        assertThat(getResponse.getBody().getHost(), equalTo("google.com"));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("host", "localhost");
//        map.add("status", "SUCCESS");
//        map.add("result", "Ping result");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<Void> postResponse = restTemplate.postForEntity(baseUrl + "/ping", request, Void.class);
//        assertThat(postResponse.getStatusCode(), equalTo(HttpStatus.FOUND));
//        assertThat(postResponse.getHeaders().getLocation().toString(), equalTo(baseUrl + "/search"));
//
//        ResponseEntity<String> searchResponse = restTemplate.getForEntity(baseUrl + "/search", String.class);
//        assertThat(searchResponse.getStatusCode(), equalTo(HttpStatus.OK));
//        assertThat(searchResponse.getBody(), containsString("localhost"));
//
//        ResponseEntity<String> detailsResponse = restTemplate.getForEntity(baseUrl + "/ping/{id}", String.class, 2L);
//        assertThat(detailsResponse.getStatusCode(), equalTo(HttpStatus.OK));
//        assertThat(detailsResponse.getBody(), containsString("localhost"));
//    }
//
//}
