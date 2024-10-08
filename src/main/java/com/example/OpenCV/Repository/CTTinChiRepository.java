package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.CTTinChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTTinChiRepository extends JpaRepository<CTTinChi,Long> {
}
