package com.example.OpenCV.Service;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.model.Request.ChuyenNganhRequest;
import com.example.OpenCV.model.Request.KhoaRequest;

import java.util.List;

public interface ChuyenNganhService {
     ChuyenNganh findById(String manganh);


    ChuyenNganh createChuyenNganh(ChuyenNganhRequest request);

    ChuyenNganh updateChuyenNganh(String manganh,ChuyenNganhRequest request);

    List<ChuyenNganh> timKiemTheoTenNganh(String tennganh);
    // tim kiem theo id
    ChuyenNganh timKiemMaNganh(String manganh);
    // tim kiem ma hoc cua khoa nao
    List<ChuyenNganh> getMonHocByMaKhoa(String makhoa);
    void deleteChuyenNganh(String maNganh);
}
