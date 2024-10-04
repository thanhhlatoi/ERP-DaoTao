package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Request.KhoaRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private KhoaRepository khoaRepository;
    // goi tat tat ca
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<Khoa> categories = khoaService.findAll();
        return ResponseEntity.ok(categories);
    }
    // them du lieu
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody KhoaRequest request){
        Khoa khoa = khoaService.createKhoa(request);

        return ResponseEntity.ok(khoa);
    }
    // sua du lieu
    @PutMapping("/update/{makhoa}")
    public ResponseEntity<?> updateCategory(@PathVariable String makhoa, @RequestBody KhoaRequest request){
        Khoa khoa = khoaService.updatekhoa(makhoa, request);
        khoa.setTenkhoa(request.getTenkhoa());
        khoaRepository.save(khoa);
        return ResponseEntity.ok(khoa);
    }
    // xoa du lieu
    @DeleteMapping("/delete/{makhoa}")
    public ResponseEntity<?> delete(@PathVariable String makhoa){
        khoaService.deleteKhoa(makhoa);
        return ResponseEntity.ok("ok");
    }
    // tim kiem theo tenkhoa
    @GetMapping("/timkiem")
    public ResponseEntity<List<Khoa>> timKiemTheoTen(@RequestParam String tenkhoa) {
        List<Khoa> ketQua = khoaService.timKiemTheoTenKhoa(tenkhoa);
        return ResponseEntity.ok(ketQua);
    }
    // tim kiem theo makhoa
    @GetMapping("/{makhoa}")
    public Khoa timKiemTheoMa(@PathVariable String makhoa) {
        return khoaService.timKiemMaKhoa(makhoa);
    }
    // phan trang
//    @GetMapping
//    public ResponseEntity<Page<Khoa>> getKhoas(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//
//        Page<Khoa> khoas = khoaService.getPageKhoa(page, size);
//        return new ResponseEntity<>(khoas, HttpStatus.OK);
//    }
}
