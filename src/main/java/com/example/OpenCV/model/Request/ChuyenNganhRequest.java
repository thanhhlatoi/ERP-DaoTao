package com.example.OpenCV.model.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenNganhRequest {
    @NotNull(message = "Tên Chuyên Ngành Rỗng")
    @NotEmpty(message = "Tên Chuyên Ngành Rỗng")
    @Size(min = 5, max = 50,message = "Độ Dài Chuyên Ngành từ 5-50 ký tự ")
    private String manganh;
    private String tennganh;
    private String makhoa;


}

