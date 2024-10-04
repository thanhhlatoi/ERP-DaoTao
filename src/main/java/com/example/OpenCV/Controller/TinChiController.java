package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.DKyTinChi;
import com.example.OpenCV.Service.TinChiService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.TinChiRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tinchi")
public class TinChiController {
    @Autowired
    private TinChiService tinChiService;

    @GetMapping("/")
    public ResponseEntity<?> getTinChi(){
        List<DKyTinChi> dKyTinChis = tinChiService.findAll();
        return ResponseEntity.ok(dKyTinChis);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createTinChi(@Valid @RequestBody TinChiRequest request){
        DKyTinChi tinchi = tinChiService.createTinChi(request);

        return ResponseEntity.ok(tinchi);
    }
    @PutMapping("/update/{matinchi}")
    public ResponseEntity<?> updateCategory(@PathVariable String matinchi, @Valid @RequestBody TinChiRequest request){
        DKyTinChi dKyTinChi = tinChiService.updateTinChi(matinchi, request);
        return ResponseEntity.ok(dKyTinChi);
    }

    @DeleteMapping("/delete/{matinchi}")
    public ResponseEntity<?> delete(@PathVariable String matinchi){
        tinChiService.deleteTinChi(matinchi);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/{matinchi}")
    public DKyTinChi timKiemTheoMa(@PathVariable String matinchi) {
        return tinChiService.timKiemTinChi(matinchi);
    }
}
