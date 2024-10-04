package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonHocRequest {
    private String mamon;
    private String tenmon;
    private int sotinchi;
    private String makhoa;
}
