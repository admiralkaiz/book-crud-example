package com.contoh.crudbuku.repository;

import com.contoh.crudbuku.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

public interface BookRepository extends JpaRepository<Book, Long> {

}
