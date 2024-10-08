package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.*;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.CTTinChiRepository;
import com.example.OpenCV.Repository.DkyTinChiRepository;
import com.example.OpenCV.Repository.MonHocRepository;
import com.example.OpenCV.Service.CTTinChiService;
import com.example.OpenCV.model.Request.CTTinChiRequest;
import com.example.OpenCV.model.Request.UpdateTinChiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CTTinChiServiceImlp implements CTTinChiService {
    @Autowired
    private CTTinChiRepository ctTinChiRepository;
    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private DkyTinChiRepository tinChiRepository;
    @Override
    public CTTinChi createTinChi(CTTinChiRequest request) {
        CTTinChi ctTinChi = new CTTinChi();
//        MonHoc monHoc = monHocRepository.findById(request.getMamon())
//                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã nghanh: " + request.getMamon()));
//        ctTinChi.setMonHoc(monHoc);

        DkyTinChi tinChi = tinChiRepository.findById(request.getMatinchi())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã nghanh: " + request.getMatinchi()));
        ctTinChi.setDkyTinChi(tinChi);
        ctTinChiRepository.save(ctTinChi);
        return ctTinChiRepository.save(ctTinChi);
    }

    @Override
    public CTTinChi updateCTTinchi(long id, UpdateTinChiRequest request) {
        CTTinChi ctTinChi = ctTinChiRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã"+id));
        Set<MonHoc> monHocs = new HashSet<>();
        for(String monhocid : request.getMonhoc()){
            MonHoc monHoc = monHocRepository.findById(monhocid).orElseThrow(() -> new NotFoundException("Not Found Tag"));
            monHocs.add(monHoc);
        }
        ctTinChi.setMonHocs(monHocs);

        ctTinChiRepository.save(ctTinChi);
        return ctTinChi;
    }

    @Override
    public void deleteCTTinchi(long id) {
        CTTinChi ctTinChi = ctTinChiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã: " + id));

        ctTinChiRepository.delete(ctTinChi);
    }

}

