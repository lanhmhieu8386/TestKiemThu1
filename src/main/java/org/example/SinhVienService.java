package org.example;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    List<SinhVien> lstSinhVien = new ArrayList<>();

    public void addSinhVien(SinhVien sv) {
        lstSinhVien.add(sv);
    }

    public SinhVien updateSinhVien(SinhVien sinhVien) {
        if (sinhVien == null) {
            throw new IllegalArgumentException("Chưa chọn sinh viên");
        }

        if (sinhVien.getMaSV() == null || sinhVien.getMaSV().trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên trỗng");
        }
        if (sinhVien.getTuoi() <= 0) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn 0");
        }
        if (sinhVien.getDiemTrungBinh() < 0 || sinhVien.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("Điểm phải từ 0 đến 10");
        }
        if (sinhVien.getTen() == null || sinhVien.getTen().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống");
        }

        if (sinhVien.getChuyenNghanh() == null || sinhVien.getChuyenNghanh().trim().isEmpty()) {
            throw new IllegalArgumentException("Chuyên ngành không được để trống");
        }

        if (sinhVien.getHocKy() <= 0) {
            throw new IllegalArgumentException("Học kỳ phải lớn hơn 0");
        }

        for (SinhVien sv : lstSinhVien) {
            if (sv.getMaSV().equals(sinhVien.getMaSV())) {
                sv.setTen(sinhVien.getTen());
                sv.setTuoi(sinhVien.getTuoi());
                sv.setDiemTrungBinh(sinhVien.getDiemTrungBinh());
                sv.setChuyenNghanh(sinhVien.getChuyenNghanh());
                sv.setHocKy(sinhVien.getHocKy());
            }
        }
        return sinhVien;
    }
}
