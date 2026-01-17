import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyBienSoXe {

    static ArrayList<String> dsBienSo = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("************ QUAN LY BIEN SO XE ************");
            System.out.println("1. Them cac bien so xe");
            System.out.println("2. Hien thi danh sach bien so xe");
            System.out.println("3. Tim kiem bien so xe");
            System.out.println("4. Tim bien so xe theo ma tinh");
            System.out.println("5. Sap xep bien so xe tang dan");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    themBienSo();
                    break;
                case 2:
                    hienThi();
                    break;
                case 3:
                    timChinhXac();
                    break;
                case 4:
                    timTheoMaTinh();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 6);
    }

    // 1. Thêm biển số
    static void themBienSo() {
        System.out.print("Nhap bien so xe: ");
        String bienSo = sc.nextLine();

        String regex = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";
        if (Pattern.matches(regex, bienSo)) {
            dsBienSo.add(bienSo);
            System.out.println("Them bien so thanh cong!");
        } else {
            System.out.println("Bien so KHONG dung dinh dang!");
        }
    }

    // 2. Hiển thị danh sách
    static void hienThi() {
        if (dsBienSo.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("Danh sach bien so xe:");
        for (String bs : dsBienSo) {
            System.out.println(bs);
        }
    }

    // 3. Tìm kiếm chính xác
    static void timChinhXac() {
        System.out.print("Nhap bien so can tim: ");
        String canTim = sc.nextLine();

        if (dsBienSo.contains(canTim)) {
            System.out.println("Tim thay bien so: " + canTim);
        } else {
            System.out.println("Khong tim thay bien so!");
        }
    }

    // 4. Tìm theo mã tỉnh
    static void timTheoMaTinh() {
        System.out.print("Nhap ma tinh (VD: 29, 30, 51): ");
        String maTinh = sc.nextLine();

        boolean found = false;
        for (String bs : dsBienSo) {
            if (bs.startsWith(maTinh)) {
                System.out.println(bs);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co bien so nao thuoc ma tinh nay!");
        }
    }

    // 5. Sắp xếp tăng dần
    static void sapXep() {
        Collections.sort(dsBienSo);
        System.out.println("Da sap xep bien so xe tang dan!");
    }
}