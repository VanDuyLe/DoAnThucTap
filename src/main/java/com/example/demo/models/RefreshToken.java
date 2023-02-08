package com.example.demo.models;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "refresh_token")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false, name = "ngayhethan")
    private Instant ngayhethan;

    public RefreshToken() {
    }
    public RefreshToken(User user, String token, Instant ngayhethan) {
        this.user = user;
        this.token = token;
        this.ngayhethan = ngayhethan;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Instant ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

}
