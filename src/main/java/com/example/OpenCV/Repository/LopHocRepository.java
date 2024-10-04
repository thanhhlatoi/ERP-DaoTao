package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc,String> {
}
