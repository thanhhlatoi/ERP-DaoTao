package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "danhgia")
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float diemtongket;
    private String diemchu;
    private boolean danhgia;

    @JsonIgnore // Bỏ qua khi serialize JSON để tránh lặp lại
    @OneToOne
    @JoinColumn(name = "mamonhoc")
    private MonHoc monHoc;

    @JsonIgnore // Bỏ qua khi serialize JSON để tránh lặp lại
    @ManyToOne
    @JoinColumn(name = "masinhvien")
    private SinhVien sinhVien;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDiem")
    private Diem diem;
}
