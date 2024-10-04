package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Entity.SinhVien;
import com.example.OpenCV.model.Request.SinhVienRequest;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> findAll();

    SinhVien createSinhVien(SinhVienRequest request);

   SinhVien updateSinhVien(String masinhvien,SinhVienRequest request);

   SinhVien getSinhVienWithDiem(String masinhvien);

    void deleteSinhVien(String masinhvien);
}
