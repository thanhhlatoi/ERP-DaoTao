package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    private String masinhvien;
    private String hoten;
    @ManyToOne
    @JoinColumn(name = "malop")
    private LopHoc lopHoc;

//    @ManyToOne
//    @JoinColumn(name = "matinchi")
//    private DKyTinChi tinchi;

    @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Diem> diemList;
}
