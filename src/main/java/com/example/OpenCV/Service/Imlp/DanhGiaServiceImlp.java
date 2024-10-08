package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Repository.DanhGiaRepository;
import com.example.OpenCV.Repository.DiemRepository;

import com.example.OpenCV.Repository.MonHocRepository;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Service.DanhGiaService;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhGiaServiceImlp implements DanhGiaService {

    @Autowired
    private DanhGiaRepository danhGiaRepository;

    @Autowired
    private DiemRepository diemRepository;

    @Override
    public List<DanhGia> findAll() {
        return danhGiaRepository.findAll();  // Lấy tất cả DanhGia từ cơ sở dữ liệu
    }

    @Override
    public DanhGia createDanhGia(DanhGiaRequest request) {
        // Lấy Diem từ cơ sở dữ liệu bằng idDiem
        Diem diem = diemRepository.getDiemById(request.getIdDiem())
                .orElseThrow(() -> new RuntimeException("Điểm không tồn tại"));

        // Tạo đối tượng DanhGia và gán các giá trị từ Diem
        DanhGia danhGia = new DanhGia();
        danhGia.setDiem(diem);  // Gán Diem vào DanhGia

        // Lấy điểm tổng kết từ đối tượng Diem và gán vào DanhGia
        float diemTongKet = diem.getDiemcc() * 0.1f + diem.getDiemth() * 0.2f + diem.getDiemgk() * 0.3f + diem.getDiemck() * 0.4f;
        danhGia.setDiemtongket(diemTongKet);

        // Tính điểm chữ và đánh giá
        danhGia.setDiemchu(tinhDiemChu(diemTongKet));
        danhGia.setDanhgia(XepLoai(diemTongKet));

        // Lưu DanhGia vào cơ sở dữ liệu
        return danhGiaRepository.save(danhGia);
    }

    // Hàm tính điểm chữ dựa trên điểm tổng kết
    private String tinhDiemChu(float diemtongket) {
        if (diemtongket >= 9) {
            return "A";
        } else if (diemtongket >= 8) {
            return "B+";
        } else if (diemtongket >= 7) {
            return "B";
        } else if (diemtongket >= 6) {
            return "C+";
        } else if (diemtongket >= 5) {
            return "C";
        } else if (diemtongket >= 4) {
            return "D";
        } else {
            return "F";
        }
    }

    // Hàm xếp loại dựa trên điểm tổng kết
    private boolean XepLoai(float diemtongket) {
        return diemtongket >= 4;
    }
}
