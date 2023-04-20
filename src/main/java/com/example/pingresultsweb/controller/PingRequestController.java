package com.example.pingresultsweb.controller;

import com.example.pingresultsweb.entity.PingRequest;
import com.example.pingresultsweb.entity.SearchCriteria;
import com.example.pingresultsweb.entity.TestStatus;
import com.example.pingresultsweb.service.PingRequestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PingRequestController {
    @Autowired private PingRequestService pingRequestService;

    @GetMapping("/") public String home() {
        return "home";
    }

    @GetMapping("/ping") public String pingForm(Model model) {
        model.addAttribute("pingRequest", new PingRequest());
        return "ping";
    }

    @PostMapping("/ping") public String pingSubmit(@ModelAttribute PingRequest pingRequest, Model model) {
        pingRequest.setDate(LocalDateTime.now());
        pingRequest.setTestStatus(TestStatus.IN_PROGRESS);
        pingRequestService.save(pingRequest);
        model.addAttribute("pingRequestId", pingRequest.getId());
        return "ping-result";
    }
    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("searchCriteria", new SearchCriteria());
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute SearchCriteria searchCriteria, Model model) {
        List<PingRequest> results = pingRequestService.search(searchCriteria.getHostOrIpAddress(), searchCriteria.getStartDate(), searchCriteria.getEndDate(), searchCriteria.getTestStatus());
        model.addAttribute("results", results);
        return "search-results";
    }

    @GetMapping("/ping/{id}")
    public String pingResult(@PathVariable Long id, Model model) {
        PingRequest pingRequest = pingRequestService.findById(id);
        model.addAttribute("pingRequest", pingRequest);
        return "ping-result-details";
    }

}
