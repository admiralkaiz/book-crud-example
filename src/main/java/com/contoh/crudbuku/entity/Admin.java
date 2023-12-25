package com.contoh.crudbuku.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Admin extends User{
    public Admin() {
        super();
    }

    public Admin(String username, String password) {
        super(username, password);
    }
}
