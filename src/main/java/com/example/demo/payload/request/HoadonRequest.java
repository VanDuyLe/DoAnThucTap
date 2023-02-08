package com.example.demo.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoadonRequest {

    private long id;

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
    private long phongId;

    @NotBlank
    private Date ngaythanhtoan;

    @NotBlank
    @Size(min = 1, max = 10)
    private Integer tongtiendien;

    @NotBlank
    @Size(min = 1, max = 10)
    private Integer tongtiennuoc;

    @NotBlank
    @Size(min = 6, max = 255)
    private String nguoitra;

    @NotBlank
    @Size(min = 6, max = 255)
    private String nguoithu;
}
