package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.DkyTinChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DkyTinChiRepository extends JpaRepository<DkyTinChi,String> {
}
