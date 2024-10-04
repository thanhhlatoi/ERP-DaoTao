package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.MonHocRequest;

import java.util.List;

public interface MonHocService {
    List<MonHoc> findAll();


    MonHoc createMonHoc(MonHocRequest request);

    MonHoc updateMonHoc(String mamon,MonHocRequest request);
    List<MonHoc> timKiemTheoTenMonHoc(String temon);

    void deleteMonHoc(String mamon);
    //tim kiem mon hoc theo khoa
    List<MonHoc> getMonHocByMaNganh(String manganh);
    // tim kiem theo id
    MonHoc timKiemMaMon(String mamon);
}
