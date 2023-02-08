package com.example.demo.controller;


import com.example.demo.payload.request.ApproveRequest;
import com.example.demo.payload.request.HoadonRequest;
import com.example.demo.payload.request.PhongRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.HoadonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/hoadon")
@RestController
public class HoaDonController {

    @Autowired
    private HoadonService hoadonService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadNewHoadon(@Valid @RequestBody HoadonRequest hoadonRequest) {
        String message = "";
        long hoadonId = hoadonService.store(hoadonRequest);

        message = "Approve stream request failure: " + hoadonId;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<MessageResponse> updateHoadon(@Valid @RequestBody HoadonRequest hoadonRequest) {
        String message = "";
        long hoadonId = hoadonService.update(hoadonRequest);

        message = "Approve stream request failure: " + hoadonId;
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteHoaDon(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(hoadonService.deleteHoaDon(id));
    }


}
