package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.MonHocService;
import com.example.OpenCV.model.Reponse.KhoaReponse;
import com.example.OpenCV.model.Reponse.MonHocReponse;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.MonHocRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    // Thêm dữ liệu
    @PostMapping("/create")
    public ResponseEntity<MonHocReponse> createCategory(@Valid @RequestBody MonHocRequest request) {
        MonHoc monHoc = monHocService.createMonHoc(request);
        return ResponseEntity.ok(convertToResponse(monHoc));
    }
    // Cập nhật dữ liệu
    @PutMapping("/update/{mamon}")
    public ResponseEntity<MonHocReponse> updateCategory(@PathVariable String mamon, @RequestBody MonHocRequest request) {
        MonHoc monHoc = monHocService.updateMonHoc(mamon, request);
        return ResponseEntity.ok(convertToResponse(monHoc));
    }
    // Xóa dữ liệu
    @DeleteMapping("/delete/{mamon}")
    public ResponseEntity<String> delete(@PathVariable String mamon){
        try {
            monHocService.deleteMonHoc(mamon);
            return ResponseEntity.ok(" deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Khoa: " + e.getMessage());
        }
    }
    @GetMapping("/timkiem")
    public ResponseEntity<List<MonHoc>> timKiemTheoTen(@RequestParam String temon) {
        List<MonHoc> ketQua = monHocService.timKiemTheoTenMonHoc(temon);
        return ResponseEntity.ok(ketQua);
    }
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<MonHoc> listmonhoc = monHocService.findAll();
        return ResponseEntity.ok(listmonhoc);
    }
    // tim kiem mon hoc theo nganh
    @GetMapping("/searchByMaNganh")
    public ResponseEntity<List<MonHoc>> getMonHocByMaNganh(@RequestParam String makhoa) {
        List<MonHoc> monHocs = monHocService.getMonHocByMaNganh(makhoa);
        return ResponseEntity.ok(monHocs);
    }


    // Tìm kiếm theo mã khoa
    @GetMapping("/{mamon}")
    public ResponseEntity<MonHocReponse> getKhoaById(@PathVariable String mamon) {
        MonHoc monHoc = monHocService.timKiemMaMon(mamon);
        return (monHoc != null) ? ResponseEntity.ok(convertToResponse(monHoc)) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // Chuyển đổi từ Khoa sang KhoaReponse
    private MonHocReponse convertToResponse(MonHoc monHoc) {
        MonHocReponse response = new MonHocReponse();
        response.setMamon(monHoc.getMamon());
        response.setTemon(monHoc.getTemon());
        response.setSotinchi(monHoc.getSotinchi());
        response.setKhoa(monHoc.getKhoa());
        return response;
    }
    // Chuyển đổi danh sách Khoa sang danh sách KhoaReponse
    private List<MonHocReponse> convertToResponseList(List<MonHoc> danhSachKhoa) {
        List<MonHocReponse> responseList = new ArrayList<>();
        for (MonHoc monHoc : danhSachKhoa) {
            responseList.add(convertToResponse(monHoc));
        }
        return responseList;
    }

}
