package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.DkyTinChi;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.LopHoc;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.DkyTinChiRepository;
import com.example.OpenCV.Repository.LopHocRepository;
import com.example.OpenCV.Service.DkyTinChiService;
import com.example.OpenCV.model.Request.DkyTinChiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DkyTinChiServiceImlp implements DkyTinChiService {
    @Autowired
    private DkyTinChiRepository tinChiRepository;
    @Autowired
    private LopHocRepository lopHocRepository;
    @Override
    public List<DkyTinChi> findAll() {
        return List.of();
    }

    @Override
    public DkyTinChi createDiem(DkyTinChiRequest request) {
        DkyTinChi dkyTinChi = new DkyTinChi();
        dkyTinChi.setMatinchi(request.getMatinchi());
        dkyTinChi.setKyhoc(request.getKyhoc());

        LopHoc lopHoc = lopHocRepository.findById(request.getMalop())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã khoa: " + request.getMalop()));
        dkyTinChi.setLopHoc(lopHoc);
        return tinChiRepository.save(dkyTinChi);
    }

    @Override
    public DkyTinChi findById(String matinchi) {
        return null;
    }
}
