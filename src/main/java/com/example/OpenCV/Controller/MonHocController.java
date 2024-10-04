package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.MonHocService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.MonHocRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<MonHoc> listmonhoc = monHocService.findAll();
        return ResponseEntity.ok(listmonhoc);
    }
    @PostMapping("/create")

    public ResponseEntity<?> createCategory(@Valid @RequestBody MonHocRequest request){
        MonHoc monHoc = monHocService.createMonHoc(request);

        return ResponseEntity.ok(monHoc);
    }
    @PutMapping("/update/{mamon}")
    public ResponseEntity<?> updateCategory(@PathVariable String mamon, @Valid @RequestBody MonHocRequest request){
        MonHoc monHoc = monHocService.updateMonHoc(mamon, request);
        return ResponseEntity.ok(monHoc);
    }

    @DeleteMapping("/delete/{mamon}")
    public ResponseEntity<?> delete(@PathVariable String mamon){
        monHocService.deleteMonHoc(mamon);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/timkiem")
    public ResponseEntity<List<MonHoc>> timKiemTheoTen(@RequestParam String temon) {
        List<MonHoc> ketQua = monHocService.timKiemTheoTenMonHoc(temon);
        return ResponseEntity.ok(ketQua);
    }
    // tim kiem mon hoc theo nganh
    @GetMapping("/searchByMaNganh")
    public ResponseEntity<List<MonHoc>> getMonHocByMaNganh(@RequestParam String makhoa) {
        List<MonHoc> monHocs = monHocService.getMonHocByMaNganh(makhoa);
        return ResponseEntity.ok(monHocs);
    }
    //tim kiem theo id
    @GetMapping("/{manganh}")
    public MonHoc timKiemTheoMaMon(@PathVariable String mamon) {
        return monHocService.timKiemMaMon(mamon);
    }

}
