package com.example.OpenCV.Service.Imlp;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Exception.NotFoundException;
import com.example.OpenCV.Repository.ChuyenNganhRepository;
import com.example.OpenCV.Repository.KhoaRepository;
import com.example.OpenCV.Service.ChuyenNganhService;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenNganhServiceImlp implements ChuyenNganhService {
    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;
    @Autowired
    private KhoaRepository khoaRepository;


    @Override
    public ChuyenNganh findById(String manganh) {
        return chuyenNganhRepository.findById(manganh).orElse(null);
    }

    @Override
    public ChuyenNganh createChuyenNganh(ChuyenNganhRequest request) {
        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setManganh(request.getManganh());
        chuyenNganh.setTennganh(request.getTennganh());

        Khoa khoa = khoaRepository.findById(request.getMakhoa())
                .orElseThrow(() -> new NotFoundException("Không tìm thấy mã khoa: " + request.getMakhoa()));
        chuyenNganh.setKhoa(khoa);
        return chuyenNganhRepository.save(chuyenNganh);
    }

    @Override
    public ChuyenNganh updateChuyenNganh(String manganh, ChuyenNganhRequest request) {
        ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(manganh).orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã"+manganh));

        Khoa khoaMoi = khoaRepository.findById(request.getMakhoa())
                .orElseThrow(() -> new NotFoundException("Khoa không tồn tại với mã: " + request.getMakhoa()));

        chuyenNganh.setTennganh(request.getTennganh());
        chuyenNganh.setKhoa(khoaMoi);
        chuyenNganhRepository.save(chuyenNganh);
        return chuyenNganh;
    }

    @Override
    public void deleteChuyenNganh(String maNganh) {
        ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(maNganh)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chuyên ngành với mã: " + maNganh));

        chuyenNganhRepository.delete(chuyenNganh);
    }
    @Override
    public List<ChuyenNganh> timKiemTheoTenNganh(String tennganh) {
        return chuyenNganhRepository.findByTennganh(tennganh);
    }

    @Override
    public ChuyenNganh timKiemMaNganh(String manganh) {
        return chuyenNganhRepository.findById(manganh)
                .orElse(null);
    }

    @Override
    public List<ChuyenNganh> getMonHocByMaKhoa(String makhoa) {
        return chuyenNganhRepository.findByMakhoa(makhoa);
    }
}
