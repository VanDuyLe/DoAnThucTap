package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "phong")
public class Phong {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(name = "ten_phong")
    @Size(min = 5, max = 255)
    private String tenPhong;

    @NotBlank
    @Column(name = "soluong")
    @Size(min = 1, max = 10)
    private Integer soluong;

    @NotBlank
    @Column(name = "tinhtrang")
    private  boolean tinhtrang;
    @NotBlank
    @Column(name = "giaphong")
    @Size(min = 3, max = 10)
    private  Integer giaphong;

    @NotBlank
    @Column(name = "chi_so_dien")
    @Size(min = 3, max = 255)
    private  Integer chisodien;

    @NotBlank
    @Column(name = "chi_so_nuoc")
    @Size(min = 3, max = 255)
    private  Integer chiSoNuoc;

    @NotBlank
    @Column(name = "thang")
    @Size(max = 3)
    private  Integer thang;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Phong(User user,String tenPhong ,Integer soluong, Integer giaphong, Integer chisodien, Integer chisonuoc, Integer thang, boolean b) {
    }

//    public Phong() {
//    }
//
//    public Phong(User user, Integer soluong, Integer giaphong, Integer chisodien, Integer chisonuoc, Integer thang, boolean tinhtrang) {
//        this.user = user;
//        this.soluong = soluong;
//        this.tinhtrang = tinhtrang;
//        this.giaphong = giaphong;
//        this.chisodien = chisodien;
//        this.chisonuoc = chisonuoc;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Integer getSoluong() {
//        return soluong;
//    }
//    public void setSoluong(Integer soluong) {
//        this.soluong = soluong;
//    }
//
//    public boolean isTinhtrang() {return tinhtrang;}
//    public void setTinhtrang(boolean tinhtrang) {this.tinhtrang = tinhtrang;}
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
//    public Double getUser_id() {
//        return user_id;
//    }
//    public void setUser_id(Double user_id) {
//        this.user_id = user_id;
//    }
//
//    public Integer getThang() {
//        return thang;
//    }
//    public void setThang(Integer thang) {this.thang = thang;}
}
