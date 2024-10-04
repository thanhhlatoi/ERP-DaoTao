package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.DKyTinChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinChiRepository extends JpaRepository<DKyTinChi,String> {
}
