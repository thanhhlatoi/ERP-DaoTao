package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.LopHocRepository;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Repository.TinChiRepository;
import com.example.OpenCV.Service.SinhVienService;
import com.example.OpenCV.model.Request.SinhVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SinhVienSercviceImlp implements SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private TinChiRepository tinChiRepository;
    @Autowired
    private LopHocRepository lopHocRepository;
    @Override
    public List<SinhVien> findAll() {
        List<SinhVien> listSV = sinhVienRepository.findAll(Sort.by("masinhvien").descending());
        return listSV;
    }

    @Override
    public SinhVien createSinhVien(SinhVienRequest request) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMasinhvien(request.getMasinhvien());
        sinhVien.setHoten(request.getHoten());

//        DKyTinChi tinChi = tinChiRepository.findById(request.getMatinchi()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getMatinchi()));
//        sinhVien.setTinchi(tinChi);

        LopHoc lopHoc = lopHocRepository.findById(request.getLopHoc()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getLopHoc()));
        sinhVien.setLopHoc(lopHoc);

        sinhVienRepository.save(sinhVien);
        return sinhVien;
    }

    @Override
    public SinhVien updateSinhVien(String masinhvien, SinhVienRequest request) {
        SinhVien sinhVien = sinhVienRepository.findById(masinhvien).orElseThrow(() -> new NotFoundException("Không tìm thấy sinh vien với mã"+masinhvien));
        sinhVien.setHoten(request.getHoten());
        LopHoc lopHoc = lopHocRepository.findById(request.getLopHoc())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getLopHoc()));
        sinhVien.setLopHoc(lopHoc);
        sinhVienRepository.save(sinhVien);
        return sinhVien;
    }

    @Override
    public SinhVien getSinhVienWithDiem(String masinhvien) {
        return sinhVienRepository.findSinhVienWithDiem(masinhvien)
                .orElseThrow(() -> new RuntimeException("Sinh viên không tồn tại"));
    }

    @Override
    public void deleteSinhVien(String masinhvien) {
        SinhVien sinhVien = sinhVienRepository.findById(masinhvien)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sinh vien với mã: " + masinhvien));

        sinhVienRepository.delete(sinhVien);
    }


}
