package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference // Tránh vòng lặp JSON
    @JsonIgnore
    private List<Diem> diemList;
}
