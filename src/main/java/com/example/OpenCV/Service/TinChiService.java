package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.DKyTinChi;

import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.TinChiRequest;

import java.util.List;

public interface TinChiService {
    List<DKyTinChi> findAll();


    DKyTinChi createTinChi(TinChiRequest request);

    DKyTinChi updateTinChi(String matinchi, TinChiRequest request);
    DKyTinChi timKiemTinChi(String matinchi);

    void deleteTinChi(String matinchi);
}
