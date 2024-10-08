package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.GiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVien,String> {
}
