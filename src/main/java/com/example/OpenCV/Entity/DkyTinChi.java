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
public class DkyTinChi {
    @Id
    private String matinchi;
    private int kyhoc;
    @ManyToOne
    @JoinColumn(name = "malop")
    private LopHoc lopHoc;
}
