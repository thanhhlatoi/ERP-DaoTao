package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import com.example.OpenCV.model.Request.LopHocRequest;

import java.util.List;

public interface DanhGiaService {
    List<DanhGia> findAll();


    DanhGia createDanhGia(DanhGiaRequest request);

}
