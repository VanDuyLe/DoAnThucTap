package com.example.demo.payload.response;

import com.example.demo.models.User;

public class PhongResponse {

    private long id;
    private User user;

    private boolean tinhtrang;

    public PhongResponse(long id, User user, boolean tinhtrang) {
        this.id = id;
        this.user = user;
        this.tinhtrang = tinhtrang;
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

    public boolean isTinhtrang() {
        return tinhtrang;
    }
    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
