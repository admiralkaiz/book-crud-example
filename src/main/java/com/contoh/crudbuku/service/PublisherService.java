package com.contoh.crudbuku.service;

import com.contoh.crudbuku.entity.Publisher;
import com.contoh.crudbuku.repository.PublisherRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).get();
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }
}
