package com.example.OpenCV.Repository;

import com.example.OpenCV.Entity.Khoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa,String> {
    List<Khoa> findByTenkhoa(String tenkhoa);

    Page<Khoa> findAll(Pageable pageable);
}

