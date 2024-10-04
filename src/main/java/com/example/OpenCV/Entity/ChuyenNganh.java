package com.example.OpenCV.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chuyennganh")
public class ChuyenNganh {
    @Id
    @Column(name = "manganh")
    private String manganh;

    @Column(name = "tennganh")
    private String tennganh;

    @ManyToOne
    @JoinColumn(name = "makhoa")
    private Khoa khoa;
}
