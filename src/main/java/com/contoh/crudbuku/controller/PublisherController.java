package com.contoh.crudbuku.controller;

import com.contoh.crudbuku.entity.Publisher;
import com.contoh.crudbuku.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/app/sukaperpus/publishers")
    public String listPublisher(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublisher());
        return "publishers";
    }

    @GetMapping("/app/sukaperpus/publishers/new")
    public String createPublisherForm(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "create_publisher";
    }

    @PostMapping("/app/sukaperpus/publishers")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/app/sukaperpus/publishers";
    }

    @GetMapping("/app/sukaperpus/publishers/edit/{id}")
    public String editPublisherForm(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherService.getPublisherById(id));
        return "edit_publisher";
    }

    @PostMapping("/app/sukaperpus/publishers/{id}")
    public String updatePublisher(@PathVariable Long id, @ModelAttribute("publisher") Publisher publisher) {
        Publisher existingPublisher = publisherService.getPublisherById(id);
        existingPublisher.setName(publisher.getName());
        publisherService.updatePublisher(existingPublisher);
        return "redirect:/app/sukaperpus/publishers";
    }

    @GetMapping("/app/sukaperpus/publishers/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return "redirect:/app/sukaperpus/publishers";
    }
}
