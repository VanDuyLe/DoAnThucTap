package com.example.demo.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhongRequest {
    @NotNull
    private long userId;

    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotBlank
    private Date birthday;

    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 10)
    private Integer soluong;

    @NotBlank
    @Size(min = 1, max = 10)
    private  Integer giaphong;

    @NotBlank
    @Size(min = 3, max = 255)
    private  Integer chisodien;

    @NotBlank
    @Size(min = 3, max = 255)
    private  Integer chisonuoc;

    @NotBlank
    @Size(max = 3)
    private  Integer thang;

    @NotBlank
    private  boolean tinhtrang;

    @NotBlank
    @Size(min = 3, max = 255)
    private  String tenphong;

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }


//    public Long getUserId() {
//        return userId;
//    }
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Integer getSoluong() {
//        return soluong;
//    }
//    public void setSoluong(Integer soluong) {
//        this.soluong = soluong;
//    }
//
//    public Integer getGiaphong() {
//        return giaphong;
//    }
//    public void setGiaphong(Integer giaphong) {
//        this.giaphong = giaphong;
//    }
//
//    public Integer getChisodien() {
//        return chisodien;
//    }
//    public void setChisodien(Integer chisodien) {
//        this.chisodien = chisodien;
//    }
//
//    public Integer getChisonuoc() {
//        return chisonuoc;
//    }
//    public void setChisonuoc(Integer chisonuoc) {this.chisonuoc = chisonuoc;}
//
//    public Integer getThang() {
//        return thang;
//    }
//    public void setThang(Integer thang) {this.thang = thang;}
//
//    public boolean isTinhtrang() {return tinhtrang;}
//    public void setTinhtrang(boolean tinhtrang) {this.tinhtrang = tinhtrang;}
}
