package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.ChuyenNganh;
import com.example.OpenCV.Entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh,String> {
    List<ChuyenNganh> findByTennganh(String tennganh);

}
