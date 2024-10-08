package com.example.OpenCV.Service.Imlp;


import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.ChuyenNganhRepository;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Service.KhoaService;
import com.example.OpenCV.model.Request.KhoaRequest;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;
    @Autowired
    private EntityManager entityManager;

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
        khoa.setTenkhoa(request.getTenkhoa());
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
    @Transactional
    public void deleteKhoa(String makhoa) {
        Khoa khoa = entityManager.find(Khoa.class, makhoa);

        if (khoa != null) {
            // Xóa đối tượng Person nếu tìm thấy
            entityManager.remove(khoa);
            entityManager.flush();
        } else {
            throw new RuntimeException("Person not found with ID: " + makhoa);
        }
    }

    @Override
    public Page<Khoa> getPageKhoa(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return khoaRepository.findAll(pageable);
    }
}

