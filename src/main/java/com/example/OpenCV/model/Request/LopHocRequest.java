package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocRequest {
    private String malop;
    private String manganh;
    private int siso;
    private int kyhoc;

}
