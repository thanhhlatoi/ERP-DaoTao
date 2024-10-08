package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.model.Request.KhoaRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhoaService {
    List<Khoa> findAll();

    Khoa createKhoa(KhoaRequest request);

    Khoa updatekhoa(String makhoa,KhoaRequest request);

    List<Khoa> timKiemTheoTenKhoa(String tenkhoa);

    Khoa timKiemMaKhoa(String makhoa);

    void deleteKhoa(String makhoa);

    Page<Khoa> getPageKhoa(int page, int size);


}
