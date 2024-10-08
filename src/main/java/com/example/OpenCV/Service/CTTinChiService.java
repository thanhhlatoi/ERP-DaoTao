package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.CTTinChi;
import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.DanhGia;
import com.example.OpenCV.model.Request.CTTinChiRequest;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.DanhGiaRequest;
import com.example.OpenCV.model.Request.UpdateTinChiRequest;

public interface CTTinChiService {
    CTTinChi createTinChi(CTTinChiRequest request);
    CTTinChi updateCTTinchi(long id, UpdateTinChiRequest request);
    void deleteCTTinchi(long id);
}
