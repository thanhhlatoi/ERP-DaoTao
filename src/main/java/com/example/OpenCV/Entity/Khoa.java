package com.example.OpenCV.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
