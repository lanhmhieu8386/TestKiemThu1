package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private String maSV;
    private String ten;
    private int tuoi;
    private Float diemTrungBinh;
    private int hocKy;
    private String chuyenNghanh;
    
}
