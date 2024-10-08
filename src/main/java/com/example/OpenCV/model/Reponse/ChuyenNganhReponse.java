package com.example.OpenCV.model.Reponse;

import com.example.OpenCV.Entity.Khoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenNganhReponse {
    private String manganh;
    private String tennganh;
    private Khoa khoa;
}
