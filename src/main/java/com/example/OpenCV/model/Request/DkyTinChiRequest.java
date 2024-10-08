package com.example.OpenCV.model.Request;

import com.example.OpenCV.Entity.LopHoc;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DkyTinChiRequest {
    private String matinchi;
    private int kyhoc;
    private String malop;
}
