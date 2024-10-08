package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.LopHocRepository;
import com.example.OpenCV.Repository.SinhVienRepository;
import com.example.OpenCV.Service.SinhVienService;
import com.example.OpenCV.model.Request.SinhVienRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SinhVienSercviceImlp implements SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

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



        LopHoc lopHoc = lopHocRepository.findById(request.getMalop()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getMalop()));
        sinhVien.setLopHoc(lopHoc);

        sinhVienRepository.save(sinhVien);
        return sinhVien;
    }

    @Override
    public SinhVien updateSinhVien(String masinhvien, SinhVienRequest request) {
        SinhVien sinhVien = sinhVienRepository.findById(masinhvien).orElseThrow(() -> new NotFoundException("Không tìm thấy sinh vien với mã"+masinhvien));
        sinhVien.setHoten(request.getHoten());

        LopHoc lopHoc = lopHocRepository.findById(request.getMalop())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getMalop()));
        sinhVien.setLopHoc(lopHoc);


        sinhVienRepository.save(sinhVien);
        return sinhVien;
    }

//    @Override
//    public SinhVien getSinhVien(String masinhvien) {
//        return sinhVienRepository.findSinhVienWithDiem(masinhvien)
//                .orElseThrow(() -> new RuntimeException("Sinh viên không tồn tại"));
//    }

    @Override
    public void deleteSinhVien(String masinhvien) {
        SinhVien sinhVien = sinhVienRepository.findById(masinhvien)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sinh vien với mã: " + masinhvien));

        sinhVienRepository.delete(sinhVien);
    }
//    // sinh vien dat mon
//    @Override
//    public List<SinhVien> getSinhVienDaDatMonHoc(String mamonhoc) {
//        return sinhVienRepository.findSinhVienDaDatMonHoc(mamonhoc);
//    }
//    // sinh vien k dat
//    @Override
//    public List<SinhVien> getSinhVienChuaDatMonHoc(String mamonhoc) {
//        return sinhVienRepository.findSinhVienChuaDatMonHoc(mamonhoc);
//    }

    @Transactional
    public SinhVien getSinhVienWithDiem(String masinhvien) {
        SinhVien sinhVien = sinhVienRepository.findById(masinhvien)
                .orElseThrow(() -> new RuntimeException("Sinh viên không tồn tại"));

        // Nạp danh sách điểm nếu FetchType.LAZY
        sinhVien.getDiemList().size(); // Gọi để nạp danh sách điểm

        return sinhVien;
    }


}
