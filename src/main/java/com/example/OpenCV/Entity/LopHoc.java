package com.example.OpenCV.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lophoc")
public class LopHoc {
    @Id
    private String malop;
    private int siso;
    private int kyhoc;
    @ManyToOne
    @JoinColumn(name = "manganh")
    private ChuyenNganh chuyenNganh;
}
