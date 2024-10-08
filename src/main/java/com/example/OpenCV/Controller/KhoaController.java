package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Reponse.KhoaReponse;
import com.example.OpenCV.model.Request.KhoaRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    // Lấy danh sách tất cả Khoa hoặc phân trang
    @GetMapping
    public ResponseEntity<?> getKhoas(
            @RequestParam(required = false) String tenkhoa,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        if (tenkhoa != null) {
            // Tìm kiếm theo tên khoa
            List<Khoa> danhSachKhoa = khoaService.timKiemTheoTenKhoa(tenkhoa);
            List<KhoaReponse> responseList = convertToResponseList(danhSachKhoa);
            return ResponseEntity.ok(responseList);
        } else {
            // Phân trang danh sách khoa
            Page<Khoa> khoas = khoaService.getPageKhoa(page, size);
            return ResponseEntity.ok(khoas);
        }
    }

    // Thêm dữ liệu
    @PostMapping("/create")
    public ResponseEntity<KhoaReponse> createCategory(@Valid @RequestBody KhoaRequest request) {
        Khoa khoa = khoaService.createKhoa(request);
        return ResponseEntity.ok(convertToResponse(khoa));
    }


    // Cập nhật dữ liệu
    @PutMapping("/update/{makhoa}")
    public ResponseEntity<KhoaReponse> updateCategory(@PathVariable String makhoa, @RequestBody KhoaRequest request) {
        Khoa khoa = khoaService.updatekhoa(makhoa, request);
        return ResponseEntity.ok(convertToResponse(khoa));
    }
    // Xóa dữ liệu
    @DeleteMapping("/delete/{makhoa}")
    public ResponseEntity<String> delete(@PathVariable String makhoa) {
        try {
            khoaService.deleteKhoa(makhoa);
            return ResponseEntity.ok(" deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Khoa: " + e.getMessage());
        }
    }

    // Tìm kiếm theo mã khoa
    @GetMapping("/{makhoa}")
    public ResponseEntity<KhoaReponse> getKhoaById(@PathVariable String makhoa) {
        Khoa khoa = khoaService.timKiemMaKhoa(makhoa);
        return (khoa != null) ? ResponseEntity.ok(convertToResponse(khoa)) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Chuyển đổi từ Khoa sang KhoaReponse
    private KhoaReponse convertToResponse(Khoa khoa) {
        KhoaReponse response = new KhoaReponse();
        response.setMakhoa(khoa.getMakhoa());
        response.setTenkhoa(khoa.getTenkhoa());
        return response;
    }

    // Chuyển đổi danh sách Khoa sang danh sách KhoaReponse
    private List<KhoaReponse> convertToResponseList(List<Khoa> danhSachKhoa) {
        List<KhoaReponse> responseList = new ArrayList<>();
        for (Khoa khoa : danhSachKhoa) {
            responseList.add(convertToResponse(khoa));
        }
        return responseList;
    }
}
