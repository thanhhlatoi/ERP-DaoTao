package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Service.Imlp.LopHocServiceImlp;
import com.example.OpenCV.Service.LopHocService;
import com.example.OpenCV.model.Reponse.ChuyenNganhReponse;
import com.example.OpenCV.model.Reponse.LopHocReponse;
import com.example.OpenCV.model.Reponse.MonHocReponse;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.LopHocRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<LopHocReponse> getKhoaById(@PathVariable String malop) {
        LopHoc lopHoc = lopHocService.timKiemMaLop(malop);
        return (lopHoc != null) ? ResponseEntity.ok(convertToResponse(lopHoc)) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // them du lieu
    @PostMapping("/create")
    public ResponseEntity<LopHocReponse> createCategory(@Valid @RequestBody LopHocRequest request){
        LopHoc lopHoc = lopHocService.createLopHoc(request);
        return ResponseEntity.ok(convertToResponse(lopHoc));
    }
    // sua du lieu
    @PutMapping("/update/{malop}")
    public ResponseEntity<LopHocReponse> updateCategory(@PathVariable String malop, @Valid @RequestBody LopHocRequest request){
        LopHoc lopHoc = lopHocService.updateLopHoc(malop, request);
        return ResponseEntity.ok(convertToResponse(lopHoc));
    }
    // xoa du lieu
    @DeleteMapping("/delete/{manganh}")
    public ResponseEntity<String> delete(@PathVariable String manganh){
        try {
            lopHocService.deleteLopHoc(manganh);
            return ResponseEntity.ok(" deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Khoa: " + e.getMessage());
        }

    }
    // Chuyển đổi từ Khoa sang KhoaReponse
    private LopHocReponse convertToResponse(LopHoc lophoc) {
        LopHocReponse response = new LopHocReponse();
        response.setMalop(lophoc.getMalop());
        response.setChuyenNganh(lophoc.getChuyenNganh());
        response.setSiso(lophoc.getSiso());
        return response;
    }

    // Chuyển đổi danh sách Khoa sang danh sách KhoaReponse
    private List<LopHocReponse> convertToResponseList(List<LopHoc> danhSachLop) {
        List<LopHocReponse> responseList = new ArrayList<>();
        for (LopHoc lopHoc : danhSachLop) {
            responseList.add(convertToResponse(lopHoc));
        }
        return responseList;
    }
}
