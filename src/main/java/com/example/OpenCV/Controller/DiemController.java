package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Service.DanhGiaService;
import com.example.OpenCV.Service.DiemService;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import com.example.OpenCV.model.Request.DiemRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diem")
public class DiemController {
    @Autowired
    private DiemService diemService;
    @Autowired
    private DanhGiaService danhGiaService;
    @GetMapping("/")
    public ResponseEntity<?> getListCategory(){
        List<Diem> diemList = diemService.findAll();
        return ResponseEntity.ok(diemList);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDiem(@Valid @RequestBody DiemRequest request){
        // Lưu đối tượng Diem từ request
        Diem diem = diemService.createDiem(request);

        // Kiểm tra nếu Diem đã được lưu thành công
        if (diem != null) {
            // Sau khi lưu Diem, tạo và lưu DanhGia dựa trên Diem
            DanhGiaRequest danhGiaRequest = new DanhGiaRequest();
            // Gán giá trị từ Diem vào DanhGiaRequest nếu cần
            danhGiaRequest.setIdDiem(diem.getId());  // Ví dụ, nếu bạn muốn liên kết DanhGia với Diem
            // Tính toán điểm tổng kết và xếp loại nếu cần
            DanhGia danhGia = danhGiaService.createDanhGia(danhGiaRequest);
            // Trả về cả Diem và DanhGia nếu cần
            return ResponseEntity.ok(new Object[]{diem, danhGia});
        }

        // Nếu có lỗi trong quá trình lưu Diem, trả về thông báo lỗi
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lưu điểm không thành công");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Diem> getDiem(@PathVariable long id) {
        Diem diem = diemService.findById(id);
        return ResponseEntity.ok(diem);
    }

}
