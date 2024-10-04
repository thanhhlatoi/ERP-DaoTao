package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Service.Imlp.LopHocServiceImlp;
import com.example.OpenCV.Service.LopHocService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.LopHocRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lophoc")
public class LopHocController {
    @Autowired
    private LopHocService lopHocService;
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<LopHoc> lopHocList = lopHocService.findAll();
        return ResponseEntity.ok(lopHocList);
    }
    // tim kiem theo id
    @GetMapping("/{malop}")
    public LopHoc timKiemTheoMa(@PathVariable String malop) {
        return lopHocService.timKiemMaLop(malop);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody LopHocRequest request){
        LopHoc lopHoc = lopHocService.createLopHoc(request);

        return ResponseEntity.ok(lopHoc);
    }

    @PutMapping("/update/{malop}")
    public ResponseEntity<?> updateCategory(@PathVariable String malop, @Valid @RequestBody LopHocRequest request){
        LopHoc lopHoc = lopHocService.updateLopHoc(malop, request);
        return ResponseEntity.ok(lopHoc);
    }

    @DeleteMapping("/delete/{malop}")
    public ResponseEntity<?> delete(@PathVariable String malop){
        lopHocService.deleteLopHoc(malop);
        return ResponseEntity.ok("ok");
    }
}
