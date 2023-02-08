package com.example.demo.service;

import com.example.demo.models.Hoadon;
import com.example.demo.models.Phong;
import com.example.demo.payload.request.HoadonRequest;
import com.example.demo.repository.HoadonRepository;
import com.example.demo.repository.PhongRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class HoadonService {
    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    HoadonRepository hoadonRepository;

    public long store(HoadonRequest hoadonRequest) {
        Hoadon hoadon = new Hoadon();
        hoadon.setUser(userRepository.findById(hoadonRequest.getUserId()).get());
        hoadon.setNguoithu(hoadonRequest.getNguoithu());
        hoadon.setNguoitra(hoadonRequest.getNguoitra());
        hoadon.setNgaythanhtoan(hoadonRequest.getNgaythanhtoan());
        hoadon.setTongtiendien(hoadonRequest.getTongtiendien());
        hoadon.setTongtiennuoc(hoadonRequest.getTongtiennuoc());
        Phong phong = phongRepository.findById(hoadonRequest.getPhongId()).get();

        phong.setThang(hoadonRequest.getThang());
        phong.setGiaphong(hoadonRequest.getGiaphong());
        phong.setChiSoNuoc(hoadonRequest.getChisonuoc());
        phong.setChisodien(hoadonRequest.getChisodien());
        Phong phong1 = phongRepository.save(phong);
        return hoadonRepository.save(hoadon).getId();

    }

    public long update(HoadonRequest hoadonRequest) {
        Hoadon hoadonFromDB = hoadonRepository.findById(hoadonRequest.getId()).get();
        hoadonFromDB.setNgaythanhtoan(hoadonRequest.getNgaythanhtoan());
        hoadonFromDB.setNguoithu(hoadonRequest.getNguoithu());
        hoadonFromDB.setNguoitra(hoadonRequest.getNguoitra());
        hoadonFromDB.setTongtiendien(hoadonRequest.getTongtiendien());
        hoadonFromDB.setTongtiennuoc((hoadonRequest.getTongtiennuoc()));

        Phong phong = phongRepository.findById(hoadonRequest.getPhongId()).get();
        phong.setThang(hoadonRequest.getThang());
        phong.setGiaphong(hoadonRequest.getGiaphong());
        phong.setChiSoNuoc(hoadonRequest.getChisonuoc());
        phong.setChisodien(hoadonRequest.getChisodien());
        phongRepository.save(phong);

        return hoadonRepository.save(hoadonFromDB).getId();
    }

//    public Stream<Long> getAllHoadons() {
//        return hoadonRepository.findAll().stream();
//    }

    public Stream<Hoadon> getHoadonByUser(long id) {
        return hoadonRepository.findByUser(userRepository.findById(id).get()).stream();
    }

    public long deleteHoaDon(Long id) {
        Hoadon hoadon = hoadonRepository.findById(id).get();
        if (hoadon != null) {
            hoadon.setIsDelete(Boolean.TRUE);
            hoadonRepository.save(hoadon);
            return hoadon.getId();
        }
        return 0;
    }
}

