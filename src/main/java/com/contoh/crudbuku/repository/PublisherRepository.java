package com.contoh.crudbuku.repository;

import com.contoh.crudbuku.entity.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
