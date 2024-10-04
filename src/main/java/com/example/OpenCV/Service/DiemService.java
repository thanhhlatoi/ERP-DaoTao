package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.model.Request.DiemRequest;
import com.example.OpenCV.model.Request.KhoaRequest;

import java.util.List;

public interface DiemService {
    List<Diem> findAll();


    Diem createDiem(DiemRequest request);

}
