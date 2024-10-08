package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.ChuyenNganhRepository;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Repository.MonHocRepository;
import com.example.OpenCV.Service.MonHocService;
import com.example.OpenCV.model.Request.MonHocRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocServiceImlp implements MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public List<MonHoc> findAll() {
        List<MonHoc> listMonHoc = monHocRepository.findAll(Sort.by("mamon").descending());
        return listMonHoc;
    }

    @Override
    public MonHoc createMonHoc(MonHocRequest request) {
        MonHoc monHoc = new MonHoc();
        monHoc.setMamon(request.getMamon());
        monHoc.setTemon(request.getTenmon());
        monHoc.setSotinchi(request.getSotinchi());
        Khoa khoa = khoaRepository.findById(request.getMakhoa()).orElseThrow(()-> new NotFoundException("yeu cau nhap ma khoa" +request.getMakhoa()));
        monHoc.setKhoa(khoa);
        monHocRepository.save(monHoc);
        return monHoc;
    }

    @Override
    public MonHoc updateMonHoc(String mamon, MonHocRequest request) {
        MonHoc monhoc = monHocRepository.findById(mamon).orElseThrow(() -> new NotFoundException("Khong tim thay ma khoa: " + mamon));
        Khoa khoaMoi = khoaRepository.findById(request.getMakhoa())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getMakhoa()));
        monhoc.setKhoa(khoaMoi);
        monhoc.setTemon(request.getTenmon());
        monhoc.setSotinchi(request.getSotinchi());
        monHocRepository.save(monhoc);
        return monhoc;
    }

    @Override
    public List<MonHoc> timKiemTheoTenMonHoc(String temon) {
        return monHocRepository.findByTemon(temon);
    }

    @Override
    public void deleteMonHoc(String mamon) {
        MonHoc monHoc = monHocRepository.findById(mamon).orElseThrow(() -> new NotFoundException("Not Found Khoa With MaKhoa: " + mamon));
        monHocRepository.delete(monHoc);
    }

    @Override
    public List<MonHoc> getMonHocByMaNganh(String makhoa) {

        return monHocRepository.findByMakhoa(makhoa);
    }

    @Override
    public MonHoc timKiemMaMon(String mamon) {
        return monHocRepository.findById(mamon)
                .orElse(null);
    }

}
