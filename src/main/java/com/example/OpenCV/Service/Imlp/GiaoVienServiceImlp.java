package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.GiaoVien;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.ChuyenNganhRepository;
import com.example.OpenCV.Repository.GiaoVienRepository;
import com.example.OpenCV.Service.GiaoVienService;
import com.example.OpenCV.model.Request.GiaoVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GiaoVienServiceImlp implements GiaoVienService {
    @Autowired
    private GiaoVienRepository giaoVienRepository;
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Override
    public List<GiaoVien> getList() {
        return giaoVienRepository.findAll(Sort.by("magiaovien").descending());
    }

    @Override
    public GiaoVien findById(String magiaovien) {
        return giaoVienRepository.findById(magiaovien).orElse(null);
    }

    @Override
    public GiaoVien createGiaoVien(GiaoVienRequest request) {
        GiaoVien giaoVien = new GiaoVien();
        giaoVien.setMagiaovien(request.getMagiaovien());
        giaoVien.setTengiaovien(request.getTengiaovien());

        Set<ChuyenNganh> chuyennganh = new HashSet<>();
        for(String chuyennganhId : request.getChuyennganh()){
            ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(chuyennganhId).orElseThrow(() -> new NotFoundException("Not Found Tag"));
            chuyennganh.add(chuyenNganh);
        }
        giaoVien.setChuyenNganhs(chuyennganh);

        giaoVienRepository.save(giaoVien);
        return giaoVien;
    }

    @Override
    public GiaoVien updateGiaoVien(String magiaovien, GiaoVienRequest request) {
        GiaoVien giaoVien = giaoVienRepository.findById(magiaovien).orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã"+magiaovien));
        giaoVien.setTengiaovien(request.getTengiaovien());

        Set<ChuyenNganh> chuyennganh = new HashSet<>();
        for(String chuyennganhId : request.getChuyennganh()){
            ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(chuyennganhId).orElseThrow(() -> new NotFoundException("Not Found Tag"));
            chuyennganh.add(chuyenNganh);
        }
        giaoVien.setChuyenNganhs(chuyennganh);

        giaoVienRepository.save(giaoVien);
        return giaoVien;
    }

    @Override
    public void deleteGiaoVien(String magiaovien) {
        GiaoVien giaoVien = giaoVienRepository.findById(magiaovien).orElseThrow(() -> new NotFoundException("Not Found Blog"));
        giaoVien.getChuyenNganhs().remove(this);
        giaoVienRepository.delete(giaoVien);
    }
}
