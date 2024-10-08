package com.example.OpenCV.model.Reponse;

import com.example.OpenCV.Entity.Khoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonHocReponse {
    private String mamon;
    private String temon;
    private int sotinchi;
    private Khoa khoa;
}
