package com.example.OpenCV.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiaoVienRequest {
    private String magiaovien;
    private String tengiaovien;
    private Set<String> chuyennganh = new HashSet<>();
}
