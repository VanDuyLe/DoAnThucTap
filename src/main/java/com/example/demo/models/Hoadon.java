package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hoadon")
public class Hoadon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Column(name = "ngaythanhdoan")
    private Date ngaythanhtoan;

    @NotBlank
    @Column(name = "tongtiendien")
    private Integer tongtiendien;

    @NotBlank
    @Column(name = "tongtiennuoc")
    private Integer tongtiennuoc;


    @NotBlank
    @Column(name = "nguoitra")
    private String nguoitra;

    @NotBlank
    @Column(name = "nguoithu")
    private String nguoithu;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "phong_id", referencedColumnName = "id")
    private Phong phong;

    @Column(name = "isDelete")
    private Boolean isDelete;

//    public void setThang(Integer thang) {
//    }
//
//    public void setGiaphong(Integer giaphong) {
//    }
//
//    public void setChisonuoc(Integer chisonuoc) {
//    }
//    public void setChisodien(Integer chisodien) {
//    }

//    public Hoadon(User user, Long phongId, Integer thang, Integer giaphong, Integer chisonuoc, Integer chisodien, Date ngaythanhtoan, Integer tongtiendien, Integer tongtiennuoc, String nguoithu, String nguoitra) {
//    }
//
//    public Hoadon(User user, Phong phong, Date ngaythanhtoan, Integer tongtiendien, Integer tongtiennuoc, String nguoitra, String nguoithu ){
//        this.user = user;
//        this.phong = phong;
//        this.ngaythanhtoan = ngaythanhtoan;
//        this.tongtiendien = tongtiendien;
//        this.tongtiennuoc = tongtiennuoc;
//        this.nguoitra = nguoitra;
//        this.nguoithu = nguoithu;
//    }

//    public Long getId() {
//        return id;
//    }
//    public Double getPhong_id() {
//        return phong_id;
//    }
//    public void setPhong_id(Double phong_id) {
//        this.phong_id = phong_id;
//    }
//
//    public Date getNgaythanhtoan() {
//        return ngaythanhtoan;
//    }
//    public void setNgaythanhtoan(Date ngaythanhtoan) {
//        this.ngaythanhtoan = ngaythanhtoan;
//    }
//
//    public Integer getTongtiendien() {
//        return tongtiendien;
//    }
//    public void setTongtiendien(Integer tongtiendien) {
//        this.tongtiendien = tongtiendien;
//    }
//
//    public Integer getTongtiennuoc() {
//        return tongtiennuoc;
//    }
//    public void setTongtiennuoc(Integer tongtiennuoc) {
//        this.tongtiennuoc = tongtiennuoc;
//    }
//
//    public Double getUser_id() {
//        return user_id;
//    }
//    public void setUser_id(Double user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getNguoitra() {
//        return nguoitra;
//    }
//    public void setNguoitra(String nguoitra) { this.nguoitra = nguoitra;}
//
//    public String getNguoithu() { return nguoithu;}
//    public void setNguoithu(String nguoithu) { this.nguoithu = nguoithu;}

}


