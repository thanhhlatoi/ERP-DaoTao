package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.SinhVien;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.SinhVienService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.SinhVienRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<SinhVien> sinhViens = sinhVienService.findAll();
        return ResponseEntity.ok(sinhViens);
    }
    @PostMapping("/create")

    public ResponseEntity<?> createCategory(@Valid @RequestBody SinhVienRequest request){
        SinhVien sinhVien = sinhVienService.createSinhVien(request);

        return ResponseEntity.ok(sinhVien);
    }
    //tim kiem theo ma sinh vien
    @GetMapping("/{masinhvien}")
    public ResponseEntity<SinhVien> getSinhVien(@PathVariable String masinhvien) {
        SinhVien sinhVien = sinhVienService.getSinhVienWithDiem(masinhvien);
        return ResponseEntity.ok(sinhVien);
    }
    @DeleteMapping("/delete/{masinhvien}")
    public ResponseEntity<?> delete(@PathVariable String masinhvien){
        sinhVienService.deleteSinhVien(masinhvien);
        return ResponseEntity.ok("ok");
    }
}
