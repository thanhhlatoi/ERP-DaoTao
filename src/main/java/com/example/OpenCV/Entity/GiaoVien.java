package com.example.OpenCV.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "giaovien")
public class GiaoVien {
    @Id
    private String magiaovien;
    private String tengiaovien;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="gv_cn",joinColumns = @JoinColumn(name="magiaovien"),inverseJoinColumns = @JoinColumn(name="machuyennganh"))
    private Set<ChuyenNganh> chuyenNganhs = new HashSet<>();
}
