package com.example.demo.controller;


import com.example.demo.models.Phong;
import com.example.demo.payload.request.ApproveRequest;
import com.example.demo.payload.request.HoadonRequest;
import com.example.demo.payload.request.PhongRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.payload.response.PhongResponse;
import com.example.demo.service.HoadonService;
import com.example.demo.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequestMapping("/api/phong")
@RestController
public class PhongController {
    @Autowired
    private PhongService phongService;


    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadNewPhong(@Valid @RequestBody PhongRequest phongRequest) {
        String message = "";
        long phongId = phongService.store(phongRequest);

        message = "Approve stream request failure: " + phongId;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/approve")
    public ResponseEntity<MessageResponse> approvePhong(@Valid @RequestBody ApproveRequest approveRequest) {
        String message = "";
        long phongId = phongService.update(approveRequest);

        message = "Approve stream request failure: " + phongId;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ResponseEntity<MessageResponse> updateNewPhong(@Valid @RequestBody PhongRequest phongRequest) {
        String message = "";
        long phongId = phongService.update1(phongRequest);

        message = "Approve stream request failure: " + phongId;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    }

    @GetMapping("/by-user")
    public ResponseEntity<List<PhongResponse>> getPhongByUser(@RequestParam long userId) {
        List<PhongResponse> phongs = phongService.getPhongByUser(userId).map(phongData -> new PhongResponse(
                phongData.getId(),
                phongData.getUser(),
                phongData.isTinhtrang())).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(phongs);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-phong")
    public ResponseEntity<List<PhongResponse>> getAllPhong() {
        List<PhongResponse> phong = phongService.getAllPhong().map(phongData -> new PhongResponse(
                phongData.getId(),
                phongData.getUser(),
                phongData.isTinhtrang())).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(phong);

    }

    @GetMapping("/get-all")
    public ResponseEntity listPhong(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Page<Phong> phong = phongService.findAll(pageNum, pageSize);
        return ResponseEntity.ok().body(phong);
    }
    @GetMapping("/phong")
    public ModelAndView listPhong(@RequestParam("tenPhong") Optional<String> tenPhong,
                                    @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Page<Phong> phong;
        if(tenPhong.isPresent()){
            phong = phongService.findAllByTenPhongContaining(tenPhong.get(), pageNum, pageSize);
        } else {
            phong = phongService.findAll(pageNum, pageSize);
        }
        ModelAndView modelAndView = new ModelAndView("/phong/list");
//        modelAndView.addObject("phong", phong);
        return modelAndView;
    }


}

