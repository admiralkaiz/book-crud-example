package com.contoh.crudbuku.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowments")
public class Borrowment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne @MapsId
    private Book book;

    @OneToOne @MapsId
    private Member member;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "return_status")
    private boolean returned;

    @Column(name = "late_status")
    private boolean late;

    @Column(name = "penalty")
    private int penalty;

    public Borrowment() {}

    public Borrowment(Book book, Member member) {
        super();
        this.book = book;
        this.member = member;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return this.member;
    }

} 
