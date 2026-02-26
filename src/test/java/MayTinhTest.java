import org.example.MayTinh;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MayTinhTest {

    MayTinh mayTinh = new MayTinh();

    // ==============================
    // I. PHÂN VÙNG TƯƠNG ĐƯƠNG
    // ==============================

    // 1. Mảng hợp lệ (tất cả trong khoảng 1–1000)
    @Test
    public void testPhanVungHopLe() {
        int thucTe = 1006;
        int mongMuon = mayTinh.tinhTong(new int[]{1, 2, 3, 1000});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 2. Có phần tử nhỏ hơn 1
    @Test
    public void testPhanTuNhoHonMin() {
        int thucTe = 5;
        int mongMuon = mayTinh.tinhTong(new int[]{-1, 2, 3});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 3. Có phần tử lớn hơn 1000
    @Test
    public void testPhanTuLonHonMax() {
        int thucTe = 6;
        int mongMuon = mayTinh.tinhTong(new int[]{1, 2, 3, 1001});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 4. Mảng null (không hợp lệ)
    @Test
    public void testMangNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> mayTinh.tinhTong(null));
    }

    // 5. Mảng rỗng (không hợp lệ)
    @Test
    public void testMangRong() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> mayTinh.tinhTong(new int[]{}));
    }

    // ==============================
    // II. GIÁ TRỊ BIÊN
    // ==============================

    // 6. Biên dưới - 1 (0)
    @Test
    public void testBienDuoiTru1() {
        int thucTe = 5;
        int mongMuon = mayTinh.tinhTong(new int[]{0, 2, 3});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 7. Biên dưới (1)
    @Test
    public void testBienDuoi() {
        int thucTe = 6;
        int mongMuon = mayTinh.tinhTong(new int[]{1, 2, 3});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 8. Biên trên - 1 (999)
    @Test
    public void testBienTrenTru1() {
        int thucTe = 1004;
        int mongMuon = mayTinh.tinhTong(new int[]{2, 3, 999});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 9. Biên trên (1000)
    @Test
    public void testBienTren() {
        int thucTe = 1005;
        int mongMuon = mayTinh.tinhTong(new int[]{2, 3, 1000});
        Assertions.assertEquals(thucTe, mongMuon);
    }

    // 10. Biên trên + 1 (1001)
    @Test
    public void testBienTrenCong1() {
        int thucTe = 5;
        int mongMuon = mayTinh.tinhTong(new int[]{2, 3, 1001});
        Assertions.assertEquals(thucTe, mongMuon);
    }
}