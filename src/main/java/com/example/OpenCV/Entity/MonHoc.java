package com.example.OpenCV.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monhoc")
public class MonHoc {
    @Id
    private String mamon;
    private String temon;
    private int sotinchi;
    @ManyToOne
    @JoinColumn(name = "makhoa")
    private Khoa khoa;

}
