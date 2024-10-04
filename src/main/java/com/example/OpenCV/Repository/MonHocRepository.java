package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.Khoa;
import com.example.OpenCV.Entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc,String> {
    List<MonHoc> findByTemon(String temon);

    @Query("SELECT m FROM MonHoc m JOIN m.khoa k WHERE k.makhoa = :makhoa")
    List<MonHoc> findByMakhoa(@Param("makhoa") String makhoa);

}
