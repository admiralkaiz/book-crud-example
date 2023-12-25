package com.contoh.crudbuku.service;

import com.contoh.crudbuku.entity.Borrowment;
import com.contoh.crudbuku.entity.Publisher;
import com.contoh.crudbuku.repository.BorrowmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowmentService {
    private BorrowmentRepository borrowmentRepository;

    public BorrowmentService(BorrowmentRepository borrowmentRepository) {
        this.borrowmentRepository = borrowmentRepository;
    }

    public List<Borrowment> getAllBorrowments() {
        return borrowmentRepository.findAll();
    }

    public Borrowment getBorrowmentById(Long id) {
        return borrowmentRepository.findById(id).get();
    }

    public Borrowment saveBorrowment(Borrowment borrowment) {
        return borrowmentRepository.save(borrowment);
    }

    public Borrowment updateBorrowment(Borrowment borrowment) {
        return borrowmentRepository.save(borrowment);
    }

    public void deleteBorrowmentById(Long id) {
        borrowmentRepository.deleteById(id);
    }
}
