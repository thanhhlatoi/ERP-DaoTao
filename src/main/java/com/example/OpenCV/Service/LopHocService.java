package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.LopHocRequest;

import java.util.List;

public interface LopHocService {
    List<LopHoc> findAll();
    LopHoc createLopHoc(LopHocRequest request);
    LopHoc updateLopHoc(String malop, LopHocRequest request);
    void deleteLopHoc(String malop);
    // tim kiem theo id
    LopHoc timKiemMaLop(String malop);

}
