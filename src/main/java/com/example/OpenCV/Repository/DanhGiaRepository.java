package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia,Long> {
}
