import org.example.SinhVien;
import org.example.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinhVienServiceTest {
    SinhVienService service;

    @BeforeEach
    void setUp() {
        service = new SinhVienService();
        // thêm 1 sinh viên mẫu để update
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 8.0f, 1, "CNTT");
        service.addSinhVien(sv);
    }

    // Phân vùng tương đương
    @Test
    public void testUpdate1() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 9.5f, 1, "CNTT");
        SinhVien result = service.updateSinhVien(sv);

        Assertions.assertEquals(9.5f, result.getDiemTrungBinh());

    }

    @Test
    public void testUpdate2() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, -2f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }

    @Test
    public void testUpdate3() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 12f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }

    // Biên
    @Test
    public void testUpdate4() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 0f, 1, "CNTT");
        SinhVien result = service.updateSinhVien(sv);
        Assertions.assertEquals(0, result.getDiemTrungBinh());
    }

    @Test
    public void testUpdate5() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 1f, 1, "CNTT");
        SinhVien result = service.updateSinhVien(sv);
        Assertions.assertEquals(1, result.getDiemTrungBinh());
    }

    @Test
    public void testUpdate6() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, -1f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }

    @Test
    public void testUpdate7() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 10f, 1, "CNTT");
        SinhVien result = service.updateSinhVien(sv);
        Assertions.assertEquals(10, result.getDiemTrungBinh());
    }

    @Test
    public void testUpdate8() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 9f, 1, "CNTT");
        SinhVien result = service.updateSinhVien(sv);
        Assertions.assertEquals(9, result.getDiemTrungBinh());
    }

    @Test
    public void testUpdate9() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 11f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }

    // -0.1
    @Test
    public void testBoundary_NhoHon0() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, -0.1f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }

    // 0
    @Test
    public void testBoundary_Bang0() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 0f, 1, "CNTT");
        Assertions.assertEquals(0f, service.updateSinhVien(sv).getDiemTrungBinh());
    }

    // 10
    @Test
    public void testBoundary_Bang10() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 10f, 1, "CNTT");
        Assertions.assertEquals(10f, service.updateSinhVien(sv).getDiemTrungBinh());
    }

    // 10.1
    @Test
    public void testBoundary_LonHon10() {
        SinhVien sv = new SinhVien("SV01", "Hieu", 20, 10.1f, 1, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sv));
    }
}
