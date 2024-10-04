package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chuyennganh")
public class ChuyenNganhController {
    @Autowired
    private ChuyenNganhService chuyenNganhService;
    // goi tat tat ca
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<ChuyenNganh> chuyenNganhs = chuyenNganhService.findAll();
        return ResponseEntity.ok(chuyenNganhs);
    }
    // them du lieu
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody ChuyenNganhRequest request){
        ChuyenNganh chuyenNganh = chuyenNganhService.createChuyenNganh(request);
        return ResponseEntity.ok(chuyenNganh);
    }
    // sua du lieu
    @PutMapping("/update/{manganh}")
    public ResponseEntity<?> updateCategory(@PathVariable String manganh, @Valid @RequestBody ChuyenNganhRequest request){
        ChuyenNganh chuyenNganh = chuyenNganhService.updateChuyenNganh(manganh, request);
        return ResponseEntity.ok(chuyenNganh);
    }
    // xoa du lieu
    @DeleteMapping("/delete/{manganh}")
    public ResponseEntity<?> delete(@PathVariable String manganh){
        chuyenNganhService.deleteChuyenNganh(manganh);
        return ResponseEntity.ok("ok");
    }
    // tim kiem theo tennganh
    @GetMapping("/timkiem")
    public ResponseEntity<List<ChuyenNganh>> timKiemTheoTen(@RequestBody String tennganh) {
        List<ChuyenNganh> ketQua = chuyenNganhService.timKiemTheoTenNganh(tennganh);
        return ResponseEntity.ok(ketQua);
    }
    // tim kiem theo id
    @GetMapping("/{manganh}")
    public ChuyenNganh timKiemTheoMa(@PathVariable String manganh) {
        return chuyenNganhService.timKiemMaNganh(manganh);
    }
}
