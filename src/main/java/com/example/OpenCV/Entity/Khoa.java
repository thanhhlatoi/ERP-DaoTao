package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Khoa")
public class Khoa {
    @Id
    @Column(name = "makhoa")
    private String makhoa;

    @Column(name = "Tenkhoa")
    private String tenkhoa;
    @JsonIgnore
    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private List<MonHoc> monHocs;

    @JsonManagedReference // Chú thích này cho phép Khoa điều khiển việc serialize ChuyenNganh
    @OneToMany(mappedBy = "khoa", cascade = CascadeType.REMOVE)
    private List<ChuyenNganh> chuyenNganhs;
}
