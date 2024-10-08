package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.GiaoVien;
import com.example.OpenCV.Service.GiaoVienService;
import com.example.OpenCV.model.MessageResponse;
import com.example.OpenCV.model.Request.GiaoVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giaovien")

public class GiaoVienController {

    @Autowired
    private GiaoVienService giaoVienService;

    @GetMapping("/")
    public ResponseEntity<List<GiaoVien>> getList(){
        List<GiaoVien> list = giaoVienService.getList();

        return ResponseEntity.ok(list);

    }

    @PostMapping("/create")
    public ResponseEntity<GiaoVien> create(@RequestBody GiaoVienRequest request){

        GiaoVien giaoVien = giaoVienService.createGiaoVien(request);

        return ResponseEntity.ok(giaoVien);

    }

    @PutMapping("/update/{magiaovien}")

    public ResponseEntity<GiaoVien> update(@PathVariable String magiaovien, @RequestBody GiaoVienRequest request){
        GiaoVien giaoVien = giaoVienService.updateGiaoVien(magiaovien, request);
        return ResponseEntity.ok(giaoVien);

    }

    @DeleteMapping("/delete/{magiaovien}")
    public ResponseEntity<?> delete(@PathVariable String magiaovien){
        giaoVienService.deleteGiaoVien(magiaovien);
        return ResponseEntity.ok(new MessageResponse("Delete success"));
    }

}

