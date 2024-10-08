package com.example.OpenCV.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cttinchi")
public class CTTinChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cttinchi_monhoc", // Bảng trung gian
            joinColumns = @JoinColumn(name = "cttinchi_id"), // Khóa ngoại từ CTTinChi
            inverseJoinColumns = @JoinColumn(name = "mamon") // Khóa ngoại từ MonHoc
    )
    private Set<MonHoc> monHocs = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "matinchi")
    private DkyTinChi dkyTinChi;
}
