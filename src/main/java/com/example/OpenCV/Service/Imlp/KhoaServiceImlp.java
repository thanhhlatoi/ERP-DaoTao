package com.example.OpenCV.Service.Imlp;


import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Request.KhoaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhoaServiceImlp implements KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Override
    public List<Khoa> findAll() {
        List<Khoa> listKhoa = khoaRepository.findAll(Sort.by("makhoa").descending());
        return listKhoa;
    }


    @Override
    public Khoa createKhoa(KhoaRequest request) {
        Khoa khoa = new Khoa();
        khoa.setMakhoa(request.getMakhoa());
        khoa.setTenkhoa(request.getTenkhoa());
        khoaRepository.save(khoa);
        return khoa;
    }

    @Override
    public Khoa updatekhoa(String makhoa, KhoaRequest request) {
        Khoa khoa = khoaRepository.findById(makhoa).orElseThrow(() -> new NotFoundException("Khong tim thay ma khoa: " + makhoa));
//        khoa.setTenkhoa(request.getTenkhoa());
        khoaRepository.save(khoa);
        return khoa;
    }

    @Override
    public List<Khoa> timKiemTheoTenKhoa(String tenkhoa) {
        return khoaRepository.findByTenkhoa(tenkhoa);

    }

    @Override
    public Khoa timKiemMaKhoa(String makhoa) {
        return khoaRepository.findById(makhoa)
                .orElse(null);
    }

    @Override
    public void deleteKhoa(String makhoa) {
        Khoa khoa = khoaRepository.findById(makhoa).orElseThrow(() -> new NotFoundException("Not Found Khoa With MaKhoa: " + makhoa));
        khoaRepository.delete(khoa);
    }

    @Override
    public Page<Khoa> getPageKhoa(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return khoaRepository.findAll(pageable);
    }
}

