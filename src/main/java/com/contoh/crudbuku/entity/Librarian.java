package com.contoh.crudbuku.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("2")
public class Librarian extends User{
    public Librarian() {
        super();
    }

    public Librarian(String username, String password) {
        super(username, password);
    }
}
