package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienRequest {
    private String masinhvien;
    private String hoten;

    private String malop;
//    private List<DiemRequest> diemList;
}
