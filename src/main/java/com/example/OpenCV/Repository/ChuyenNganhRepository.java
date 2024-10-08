package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.ChuyenNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh,String> {
    List<ChuyenNganh> findByTennganh(String tennganh);

    @Query("SELECT c FROM ChuyenNganh c JOIN c.khoa k WHERE k.makhoa = :makhoa")
    List<ChuyenNganh> findByMakhoa(@Param("makhoa") String makhoa);

//    @JsonProperty("makhoa")
//    @Transactional
//    void deleteByKhoa_MaKhoa(String makhoa);

//    void deleteByMakhoa(String Makhoa);
}
