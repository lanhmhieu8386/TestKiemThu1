package org.example;

public class MayTinh {
    public int tinhTong(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Mảng không được rỗng");
        }
        int tong = 0;
        for (int i : array) {
            if (i >= 1 && i <= 1000) {
                tong += i;
            }
        }

        return tong;
    }
}
