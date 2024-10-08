package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Entity.SinhVien;
import com.example.OpenCV.model.Request.SinhVienRequest;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> findAll();

    SinhVien createSinhVien(SinhVienRequest request);

   SinhVien updateSinhVien(String masinhvien,SinhVienRequest request);

//   SinhVien getSinhVien(String masinhvien);
    SinhVien getSinhVienWithDiem(String masinhvien);

    void deleteSinhVien(String masinhvien);
//    //sinh vien dat mon
//    List<SinhVien> getSinhVienDaDatMonHoc(String mamonhoc);
//    //sinh vien k dat
//    List<SinhVien> getSinhVienChuaDatMonHoc(String mamonhoc);
}
