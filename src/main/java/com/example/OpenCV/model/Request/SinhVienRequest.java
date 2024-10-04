package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienRequest {
    private String masinhvien;
    private String hoten;
//    private String matinchi;
    private String lopHoc;
}
