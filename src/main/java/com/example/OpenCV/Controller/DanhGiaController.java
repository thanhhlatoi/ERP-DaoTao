package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.Service.DanhGiaService;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/danhgia")
public class DanhGiaController {
    @Autowired
    private DanhGiaService danhGiaService;
    @GetMapping("/all")
    public List<DanhGia> getAllDanhGia() {
        return danhGiaService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<DanhGia> saveDanhGia(@RequestBody DanhGiaRequest danhGiaRequest) {
        DanhGia savedDanhGia = danhGiaService.createDanhGia(danhGiaRequest);
        return new ResponseEntity<>(savedDanhGia, HttpStatus.CREATED);
    }
}

