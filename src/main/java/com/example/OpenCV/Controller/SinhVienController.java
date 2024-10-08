package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Entity.SinhVien;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.SinhVienService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.SinhVienRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private SinhVienRepository sinhVienRepository;

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

    @PutMapping("/update/{masinhvien}")
    public ResponseEntity<?> updateCategory(@PathVariable String masinhvien, @Valid @RequestBody SinhVienRequest request){
        SinhVien sinhVien = sinhVienService.updateSinhVien(masinhvien, request);
        return ResponseEntity.ok(sinhVien);
    }

    @DeleteMapping("/delete/{masinhvien}")
    public ResponseEntity<?> delete(@PathVariable String masinhvien){
        sinhVienService.deleteSinhVien(masinhvien);
        return ResponseEntity.ok("ok");
    }

    //call sinh vien vs diem
    @GetMapping("/{masinhvien}")
    public ResponseEntity<SinhVien> getSinhVienWithDiem(@PathVariable String masinhvien) {
        SinhVien sinhVien = sinhVienService.getSinhVienWithDiem(masinhvien);
        return ResponseEntity.ok(sinhVien);
    }

    //tim kiem diem cua sinh vien
    @GetMapping("getdiem/{masinhvien}")
    public List<Diem> getDiemList(@PathVariable String masinhvien) {
        return sinhVienRepository.findById(masinhvien).map(SinhVien::getDiemList).orElse(null);
    }
}
