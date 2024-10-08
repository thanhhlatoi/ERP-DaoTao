package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Entity.DkyTinChi;
import com.example.OpenCV.model.Request.DiemRequest;
import com.example.OpenCV.model.Request.DkyTinChiRequest;

import java.util.List;

public interface DkyTinChiService {
    List<DkyTinChi> findAll();
    DkyTinChi createDiem(DkyTinChiRequest request);
    DkyTinChi findById(String matinchi);
}
