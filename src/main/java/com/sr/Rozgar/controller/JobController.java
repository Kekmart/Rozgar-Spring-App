package com.sr.Rozgar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sr.Rozgar.model.Job;
import com.sr.Rozgar.repository.JobRepository;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("/jobs/new")
    public String newJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "new-job";
    }

    @PostMapping("/jobs")
    public String saveJob(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/";
    }

    @GetMapping("/jobs/{id}")
    public String viewJob(@PathVariable Long id, Model model) {
        Job job = jobRepository.findById(id).orElse(null);
        model.addAttribute("job", job);
        return "view-job";
    }
}
