package com.example.OpenCV.Controller;

import com.example.OpenCV.Entity.CTTinChi;
import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Entity.DkyTinChi;
import com.example.OpenCV.Service.CTTinChiService;
import com.example.OpenCV.Service.DkyTinChiService;
import com.example.OpenCV.model.Request.CTTinChiRequest;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import com.example.OpenCV.model.Request.DiemRequest;
import com.example.OpenCV.model.Request.DkyTinChiRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tinchi")
public class TinChiController {
    @Autowired
    private DkyTinChiService tinChiService;
    @Autowired
    private CTTinChiService ctTinChiService;


    @PostMapping("create")
    public ResponseEntity<?> createDiem(@Valid @RequestBody DkyTinChiRequest request) {
        // Lưu đối tượng DkyTinChi từ request
        DkyTinChi dkyTinChi = tinChiService.createDiem(request);

        // Kiểm tra nếu DkyTinChi đã được lưu thành công và matinchi không null
        if (dkyTinChi != null && dkyTinChi.getMatinchi() != null) {
            // Sau khi lưu DkyTinChi, tạo và lưu CTTinChi với matinchi từ DkyTinChi
            CTTinChiRequest ctTinChiRequest = new CTTinChiRequest();
            ctTinChiRequest.setMatinchi(dkyTinChi.getMatinchi());  // Liên kết CTTinChi với DkyTinChi
            // Lưu CTTinChi vào cơ sở dữ liệu
           CTTinChi ctTinChi1 = ctTinChiService.createTinChi(ctTinChiRequest);

            // Trả về cả DkyTinChi và CTTinChi nếu cần
            return ResponseEntity.ok(new Object[]{dkyTinChi, ctTinChi1});
        }

        // Nếu có lỗi trong quá trình lưu DkyTinChi, trả về thông báo lỗi
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lưu tin chi không thành công");
    }



}
