package com.example.demo.repository;

import com.example.demo.models.Hoadon;
import com.example.demo.models.Phong;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoadonRepository extends JpaRepository<Hoadon, Long> {

    List<Hoadon> findByUser(User user);

    List<Hoadon> findByPhong(Phong phong);

}
