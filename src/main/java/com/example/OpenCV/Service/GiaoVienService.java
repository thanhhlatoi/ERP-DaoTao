package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.GiaoVien;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.GiaoVienRequest;

import java.util.List;

public interface GiaoVienService {
    List<GiaoVien> getList();
    GiaoVien findById(String magiaovien);
    GiaoVien createGiaoVien(GiaoVienRequest request);

    GiaoVien updateGiaoVien(String magiaovien, GiaoVienRequest request);
    void deleteGiaoVien(String magiaovien);
}
