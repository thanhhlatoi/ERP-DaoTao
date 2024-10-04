package com.example.OpenCV.model.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhoaRequest {
    @NotNull(message = "Tên Khoa Rỗng")
    @NotEmpty(message = "Tên Khoa Rỗng")
    @Size(min = 5, max = 50,message = "Độ Dài Khoa từ 5-50 ký tự ")
    private String makhoa;
    @NotNull(message = "Tên Khoa Rỗng")
    @NotEmpty(message = "Tên Khoa Rỗng")
    @Size(min = 5, max = 50,message = "Độ Dài Chuyên Ngành từ 5-50 ký tự ")
    private String tenkhoa;
}
