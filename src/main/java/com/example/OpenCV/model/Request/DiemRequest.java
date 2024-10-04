package com.example.OpenCV.model.Request;

import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Entity.SinhVien;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiemRequest {
    private Long id;
    private float diemcc;
    private float diemth;
    private float diemgk;
    private float diemck;
    private String mamonhoc;
    private String masinhvien;
}
