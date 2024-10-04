package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diem")
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float diemcc;
    private float diemth;
    private float diemgk;
    private float diemck;
    @JsonIgnore // Bỏ qua khi serialize JSON để tránh lặp lại
    @OneToOne
    @JoinColumn(name = "mamonhoc")
    private MonHoc monHoc;
    @ManyToOne
    @JoinColumn(name = "masinhvien")
    private SinhVien sinhVien;

}
