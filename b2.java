import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyNguoiDung {

    static String hoTen = "";
    static String email = "";
    static String sdt = "";
    static String matKhau = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("************ QUAN LY NGUOI DUNG ************");
            System.out.println("1. Nhap thong tin nguoi dung");
            System.out.println("2. Chuan hoa ho ten");
            System.out.println("3. Kiem tra email hop le");
            System.out.println("4. Kiem tra so dien thoai hop le");
            System.out.println("5. Kiem tra mat khau hop le");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    nhapThongTin();
                    break;
                case 2:
                    chuanHoaHoTen();
                    break;
                case 3:
                    kiemTraEmail();
                    break;
                case 4:
                    kiemTraSDT();
                    break;
                case 5:
                    kiemTraMatKhau();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 6);
    }

    // 1. Nhập thông tin
    static void nhapThongTin() {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Nhap email: ");
        email = sc.nextLine();

        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();

        System.out.print("Nhap mat khau: ");
        matKhau = sc.nextLine();
    }

    // 2. Chuẩn hóa họ tên
    static void chuanHoaHoTen() {
        String[] arr = hoTen.trim().toLowerCase().split("\\s+");
        String result = "";
        for (String s : arr) {
            result += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        hoTen = result.trim();
        System.out.println("Ho ten sau chuan hoa: " + hoTen);
    }

    // 3. Kiểm tra email
    static void kiemTraEmail() {
        String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (Pattern.matches(regexEmail, email)) {
            System.out.println("Email hop le!");
        } else {
            System.out.println("Email KHONG hop le!");
        }
    }

    // 4. Kiểm tra số điện thoại VN
    static void kiemTraSDT() {
        String regexPhone = "^(03|05|07|08|09)\\d{8}$";
        if (Pattern.matches(regexPhone, sdt)) {
            System.out.println("So dien thoai hop le!");
        } else {
            System.out.println("So dien thoai KHONG hop le!");
        }
    }

    // 5. Kiểm tra mật khẩu
    static void kiemTraMatKhau() {
        String regexPass =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";

        if (Pattern.matches(regexPass, matKhau)) {
            System.out.println("Mat khau hop le!");
        } else {
            System.out.println("Mat khau KHONG hop le!");
        }
    }
}