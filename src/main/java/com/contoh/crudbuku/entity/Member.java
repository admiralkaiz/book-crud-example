package com.contoh.crudbuku.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("3")
public class Member extends User{
    public Member() {
        super();
    }

    public Member(String username, String password) {
        super(username, password);
    }
}
