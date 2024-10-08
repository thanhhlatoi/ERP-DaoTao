package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.MonHocRepository;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Repository.TinChiRepository;
import com.example.OpenCV.Service.TinChiService;
import com.example.OpenCV.model.Request.TinChiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinChiServiceImlp implements TinChiService {
    @Autowired
    private TinChiRepository  tinChiRepository;
    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Override
    public List<DKyTinChi> findAll() {
        List<DKyTinChi> listTinChi = tinChiRepository.findAll(Sort.by("matinchi").descending());
        return listTinChi;
    }

    @Override
    public DKyTinChi createTinChi(TinChiRequest request) {
        DKyTinChi tinChi = new DKyTinChi();
        tinChi.setMatinchi(request.getMatinchi());
        tinChi.setThoigianhoc(request.getThoigianhoc());

        MonHoc monHoc = monHocRepository.findById(request.getMamon()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getMamon()));
        tinChi.setMonHoc(monHoc);
//        SinhVien sinhVien = sinhVienRepository.findById(request.getMamon()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getMasinhvien()));
//        tinChi.setMonHoc(monHoc);
//        tinChi.setSinhVien(sinhVien);
        tinChiRepository.save(tinChi);
        return tinChi;
    }

    @Override
    public DKyTinChi updateTinChi(String matinchi, TinChiRequest request) {
        DKyTinChi dKyTinChi = tinChiRepository.findById(matinchi).orElseThrow(() -> new NotFoundException("Không tìm thấy TTin Chi với mã"+matinchi));
        dKyTinChi.setThoigianhoc(request.getThoigianhoc());
        MonHoc monhoc = monHocRepository.findById(request.getMamon())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getMamon()));
        dKyTinChi.setMonHoc(monhoc);
//        SinhVien sinhVien = sinhVienRepository.findById(request.getMasinhvien())
//                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getMasinhvien()));
//        dKyTinChi.setSinhVien(sinhVien);
        tinChiRepository.save(dKyTinChi);
        return dKyTinChi;
    }

    @Override
    public DKyTinChi timKiemTinChi(String matinchi) {
        return tinChiRepository.findById(matinchi)
                .orElse(null);
    }

    @Override
    public void deleteTinChi(String matinchi) {
        DKyTinChi tinchi = tinChiRepository.findById(matinchi)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Tin Chi với mã: " + matinchi));

        tinChiRepository.delete(tinchi);
    }
}
