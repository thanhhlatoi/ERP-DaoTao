package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.Diem;
import com.example.OpenCV.Entity.MonHoc;
import com.example.OpenCV.Entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiemRepository  extends JpaRepository<Diem,Long> {

}
