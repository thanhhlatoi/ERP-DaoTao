package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToOne
    @JoinColumn(name = "mamonhoc")
    private MonHoc monHoc;
    @ManyToOne
//    @JsonManagedReference // Để xử lý tuần hoàn JSON với @JsonBackReference trong SinhVien
    @JoinColumn(name = "masinhvien")
    private SinhVien sinhVien;

}
