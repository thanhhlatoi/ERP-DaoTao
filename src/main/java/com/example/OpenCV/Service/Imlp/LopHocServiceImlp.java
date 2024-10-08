package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.ChuyenNganhRepository;
import com.example.OpenCV.Repository.LopHocRepository;
import com.example.OpenCV.Service.LopHocService;
import com.example.OpenCV.model.Request.KhoaRequest;
import com.example.OpenCV.model.Request.LopHocRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LopHocServiceImlp implements LopHocService {
    @Autowired
    private LopHocRepository lopHocRepository;
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Override
    public List<LopHoc> findAll() {
        return lopHocRepository.findAll(Sort.by("malop").descending());
    }

    @Override
    public LopHoc createLopHoc(LopHocRequest request) {
        LopHoc lophoc = new LopHoc();
        lophoc.setMalop(request.getMalop());
        lophoc.setSiso(request.getSiso());

        ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(request.getManganh())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã nghanh: " + request.getManganh()));
        lophoc.setChuyenNganh(chuyenNganh);
        lopHocRepository.save(lophoc);
        return lophoc;
    }

    @Override
    public LopHoc updateLopHoc(String malop, LopHocRequest request) {
        LopHoc lopHoc = lopHocRepository.findById(malop).orElseThrow(() -> new NotFoundException("Không tìm thấy phong hoc với mã"+malop));
        ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(request.getManganh())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getManganh()));
        lopHoc.setChuyenNganh(chuyenNganh);

        lopHoc.setSiso(request.getSiso());

        lopHocRepository.save(lopHoc);
        return lopHoc;
    }

    @Override
    public void deleteLopHoc(String malop) {
        LopHoc lopHoc = lopHocRepository.findById(malop)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã: " + malop));

        lopHocRepository.delete(lopHoc);
    }

    @Override
    public LopHoc timKiemMaLop(String malop) {
        return lopHocRepository.findById(malop)
                .orElse(null);
    }
}
