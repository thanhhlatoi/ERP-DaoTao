package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
    @Query("SELECT sv FROM SinhVien sv LEFT JOIN FETCH sv.diemList WHERE sv.masinhvien = :masinhvien")
    Optional<SinhVien> findSinhVienWithDiem(@Param("masinhvien") String masinhvien);
}
