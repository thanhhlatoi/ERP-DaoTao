package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.CTTinChi;
import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.Service.CTTinChiService;
import com.example.OpenCV.Service.DanhGiaService;
import com.example.OpenCV.model.Reponse.ChuyenNganhReponse;
import com.example.OpenCV.model.Request.CTTinChiRequest;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import com.example.OpenCV.model.Request.UpdateTinChiRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cttinchi")
public class CTTTinChiController {
    @Autowired
    private CTTinChiService ctTinChiService;

    @PostMapping("/save")
    public ResponseEntity<CTTinChi> saveCTTinchi(@RequestBody CTTinChiRequest request) {
        CTTinChi saveCTTinchi = ctTinChiService.createTinChi(request);
        return new ResponseEntity<>(saveCTTinchi, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable long id, @Valid @RequestBody UpdateTinChiRequest request){
        CTTinChi ctTinChi = ctTinChiService.updateCTTinchi(id, request);
        return ResponseEntity.ok(ctTinChi);
    }
    // xoa du lieu
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            ctTinChiService.deleteCTTinchi(id);
            return ResponseEntity.ok(" deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Khoa: " + e.getMessage());
        }

    }

}
