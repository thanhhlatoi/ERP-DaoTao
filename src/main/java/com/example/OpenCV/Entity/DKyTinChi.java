package com.example.OpenCV.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tinchi")
public class DKyTinChi {
    @Id
    private String matinchi;
    private String thoigianhoc;
    @OneToOne
    @JoinColumn(name = "mamon")
    private MonHoc monHoc;

}
