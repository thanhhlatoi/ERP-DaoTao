package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Reponse.ChuyenNganhReponse;
import com.example.OpenCV.model.Reponse.KhoaReponse;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chuyennganh")
public class ChuyenNganhController {
    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping("/{manganh}")
    public ResponseEntity<ChuyenNganhReponse> getChuyenNganhById(@PathVariable String manganh) {
        ChuyenNganh chuyenNganh = chuyenNganhService.findById(manganh);
        if (chuyenNganh != null) {
            // Tạo ChuyenNganhResponse với đầy đủ thông tin
            ChuyenNganhReponse response = new ChuyenNganhReponse(
                    chuyenNganh.getManganh(),
                    chuyenNganh.getTennganh(),
                    chuyenNganh.getKhoa() // Trả về thông tin Khoa
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    // them du lieu
    @PostMapping("/create")
    public ResponseEntity<ChuyenNganhReponse> createCategory(@Valid @RequestBody ChuyenNganhRequest request){
        ChuyenNganh chuyenNganh = chuyenNganhService.createChuyenNganh(request);
        return ResponseEntity.ok(convertToResponse(chuyenNganh));
    }
    // sua du lieu
    @PutMapping("/update/{manganh}")
    public ResponseEntity<ChuyenNganhReponse> updateCategory(@PathVariable String manganh, @Valid @RequestBody ChuyenNganhRequest request){
        ChuyenNganh chuyenNganh = chuyenNganhService.updateChuyenNganh(manganh, request);
        return ResponseEntity.ok(convertToResponse(chuyenNganh));
    }
    // xoa du lieu
    @DeleteMapping("/delete/{manganh}")
    public ResponseEntity<?> delete(@PathVariable String manganh){
        try {
            chuyenNganhService.deleteChuyenNganh(manganh);
            return ResponseEntity.ok(" deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Khoa: " + e.getMessage());
        }

    }
    // tim kiem theo tennganh
    @GetMapping("/timkiem")
    public ResponseEntity<List<ChuyenNganh>> timKiemTheoTen(@RequestBody String tennganh) {
        List<ChuyenNganh> ketQua = chuyenNganhService.timKiemTheoTenNganh(tennganh);
        return ResponseEntity.ok(ketQua);
    }
    // tim kiem theo id
//    @GetMapping("/{manganh}")
//    public ChuyenNganh timKiemTheoMa(@PathVariable String manganh) {
//        return chuyenNganhService.timKiemMaNganh(manganh);
//    }
    //
    @GetMapping("/searchByMaKhoa")
    public ResponseEntity<List<ChuyenNganh>> getMonHocByMaNganh(@RequestParam String makhoa) {
        List<ChuyenNganh> chuyenNganhs = chuyenNganhService.getMonHocByMaKhoa(makhoa);
        return ResponseEntity.ok(chuyenNganhs);
    }
    // Chuyển đổi từ Khoa sang KhoaReponse
    private ChuyenNganhReponse convertToResponse(ChuyenNganh chuyenNganh) {
        ChuyenNganhReponse response = new ChuyenNganhReponse();
        response.setManganh(chuyenNganh.getManganh());
        response.setTennganh(chuyenNganh.getTennganh());
        response.setKhoa(chuyenNganh.getKhoa());
        return response;
    }

    // Chuyển đổi danh sách Khoa sang danh sách KhoaReponse
//    private List<KhoaReponse> convertToResponseList(List<Khoa> danhSachKhoa) {
//        List<KhoaReponse> responseList = new ArrayList<>();
//        for (Khoa khoa : danhSachKhoa) {
//            responseList.add(convertToResponse(khoa));
//        }
//        return responseList;
//    }
}
