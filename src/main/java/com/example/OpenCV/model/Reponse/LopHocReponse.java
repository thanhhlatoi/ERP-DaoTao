package com.example.OpenCV.model.Reponse;

import com.example.OpenCV.Entity.ChuyenNganh;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocReponse {
    private String malop;
    private int siso;

    private ChuyenNganh chuyenNganh;
}
