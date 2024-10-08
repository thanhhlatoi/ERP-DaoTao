package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.DiemRepository;
import com.example.OpenCV.Repository.MonHocRepository;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Service.DiemService;
import com.example.OpenCV.model.Request.DiemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiemServiceImlp implements DiemService {
    @Autowired
    private DiemRepository diemRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private MonHocRepository monHocRepository;
    @Override
    public List<Diem> findAll() {
        return diemRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public Diem createDiem(DiemRequest request) {
        Diem diem = new Diem();
        diem.setDiemcc(request.getDiemcc());
        diem.setDiemth(request.getDiemth());
        diem.setDiemgk(request.getDiemgk());
        diem.setDiemck(request.getDiemck());

         SinhVien sinhVien = sinhVienRepository.findById(request.getMasinhvien())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã nghanh: " + request.getMasinhvien()));
        diem.setSinhVien(sinhVien);

        MonHoc monHoc = monHocRepository.findById(request.getMamonhoc())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã nghanh: " + request.getMamonhoc()));
        diem.setMonHoc(monHoc);

        diemRepository.save(diem);
        return diem;
    }

    @Override
    public Diem findById(long id) {
        return diemRepository.findById(id).orElse(null);
    }


}
