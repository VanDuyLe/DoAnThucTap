package com.example.demo.payload.request;

import javax.validation.constraints.NotNull;

public class ApproveRequest {
    @NotNull
    private long phongId;

    @NotNull
    private long userId;

    @NotNull
    private boolean tinhtang;

    public long getPhongId() {
        return phongId;
    }

    public void setPhongId(long phongId) {
        this.phongId = phongId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isTinhtang() {
        return tinhtang;
    }

    public void setTinhtang(boolean tinhtang) {
        this.tinhtang = tinhtang;
    }
}
