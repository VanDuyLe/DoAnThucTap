package com.example.demo.repository;

import com.example.demo.models.Phong;
import com.example.demo.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhongRepository extends JpaRepository<Phong, Long> {
    List<Phong> findByUser(User user);
    Page<Phong> findAll(Pageable pageable);
    Page<Phong> findAllByTenPhongContaining(String tenPhong, Pageable pageable);
}
