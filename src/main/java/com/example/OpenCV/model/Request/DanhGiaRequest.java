package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhGiaRequest {
    private float diemtongket;
    private String diemchu;
    private Boolean danhgia;
}
