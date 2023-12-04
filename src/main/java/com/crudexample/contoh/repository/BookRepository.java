package com.crudexample.contoh.repository;

import com.crudexample.contoh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

public interface BookRepository extends JpaRepository<Book, Long> {

}
