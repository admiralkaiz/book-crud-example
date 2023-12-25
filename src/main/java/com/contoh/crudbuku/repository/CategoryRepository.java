package com.contoh.crudbuku.repository;

import com.contoh.crudbuku.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
