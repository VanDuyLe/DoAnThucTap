package com.example.demo.service;


import com.example.demo.models.Phong;
import com.example.demo.payload.request.ApproveRequest;
import com.example.demo.payload.request.PhongRequest;
import com.example.demo.repository.PhongRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PhongService {

    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    UserRepository userRepository;

    public long store(PhongRequest phongRequest) {
        Phong phong = new Phong(
                userRepository.findById(phongRequest.getUserId()).get(),
                phongRequest.getTenphong(),
                phongRequest.getSoluong(),
                phongRequest.getGiaphong(),
                phongRequest.getChisodien(),
                phongRequest.getChisonuoc(),
                phongRequest.getThang(),
                false
        );
        return phongRepository.save(phong).getId();
    }

    public long update(ApproveRequest approveRequest) {
        Phong phongFromDB = phongRepository.findById(approveRequest.getPhongId()).get();
        phongFromDB.setTinhtrang(approveRequest.isTinhtang());
        return phongRepository.save(phongFromDB).getId();
    }

    public long update1(PhongRequest phongRequest) {
        Phong phong = new Phong(
                userRepository.findById(phongRequest.getUserId()).get(),
                phongRequest.getTenphong(),
                phongRequest.getSoluong(),
                phongRequest.getGiaphong(),
                phongRequest.getChisodien(),
                phongRequest.getChisonuoc(),
                phongRequest.getThang(),
                false
        );
        return phongRepository.save(phong).getId();
    }

    public Stream<Phong> getAllPhong() {
        return phongRepository.findAll().stream();
    }

    public Stream<Phong> getPhongByUser(long userId) {
        return phongRepository.findByUser(userRepository.findById(userId).get()).stream();
    }

    public Page<Phong> findAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return phongRepository.findAll(pageable);
    }

    public Page<Phong> findAllByTenPhongContaining(String tenPhong, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return phongRepository.findAllByTenPhongContaining(tenPhong, pageable);
    }
    public long deleteHoaDon(long id) {
        Phong phong = phongRepository.findById(id).get();
        if (phong != null) {
            phong.setIsDelete(Boolean.TRUE);
            phongRepository.save(phong);
            return phong.getId();
        }
        return 0;
    }

}
