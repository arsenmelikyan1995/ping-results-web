package com.example.pingresultsweb.controller;

import com.example.pingresultsweb.entity.PingResult;
import com.example.pingresultsweb.service.PingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PingResultController {
    @Autowired
    private PingResultService service;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<PingResult> pingResults = service.getPage(page, 5);

        model.addAttribute("pingResults", pingResults);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pingResults.getTotalPages());

        return "index";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        PingResult pingResult = service.getById(id);

        if (pingResult == null) {
            return "redirect:/";
        }

        model.addAttribute("pingResult", pingResult);

        return "details";
    }

    @GetMapping("/search")
    public String search(Model model,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String testStatus,
            @RequestParam(defaultValue = "0") int page) throws ParseException {
        List<PingResult> pingResults = new ArrayList<>();

        if (query != null && !query.isEmpty()) {
            pingResults = service.getByIpAddressOrDomainName(query);
        } else if (startDate != null && endDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            pingResults = service.getByTestDateRange(start, end);
        } else if (testStatus != null && !testStatus.isEmpty()) {
            pingResults = service.getByTestStatus(testStatus);
        }

        Page<PingResult> pingResultsPage = new PageImpl<>(pingResults, PageRequest.of(page, 5), pingResults.size());

        model.addAttribute("pingResults", pingResultsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pingResultsPage.getTotalPages());
        model.addAttribute("query", query);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("testStatus", testStatus);

        return "search";
    }
}
