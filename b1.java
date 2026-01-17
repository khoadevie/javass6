import java.util.Scanner;
import java.util.Arrays;

public class QuanLyDiemSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] diem = new double[100];
        int n = 0;
        int choice;

        do {
            System.out.println("************* QUAN LY DIEM SV *************");
            System.out.println("1. Nhap danh sach diem sinh vien");
            System.out.println("2. In danh sach diem");
            System.out.println("3. Tinh diem trung binh cua cac sinh vien");
            System.out.println("4. Tim diem cao nhat va thap nhat");
            System.out.println("5. Dem so luong sinh vien dat va truot");
            System.out.println("6. Sap xep diem tang dan");
            System.out.println("7. Thong ke sinh vien gioi va xuat sac");
            System.out.println("8. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so luong sinh vien: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.print("Nhap diem SV " + (i + 1) + ": ");
                            diem[i] = sc.nextDouble();
                        } while (diem[i] < 0 || diem[i] > 10);
                    }
                    break;

                case 2:
                    System.out.println("Danh sach diem:");
                    for (int i = 0; i < n; i++) {
                        System.out.println("SV " + (i + 1) + ": " + diem[i]);
                    }
                    break;

                case 3:
                    double sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += diem[i];
                    }
                    System.out.println("Diem trung binh: " + (sum / n));
                    break;

                case 4:
                    double max = diem[0];
                    double min = diem[0];
                    for (int i = 1; i < n; i++) {
                        if (diem[i] > max) max = diem[i];
                        if (diem[i] < min) min = diem[i];
                    }
                    System.out.println("Diem cao nhat: " + max);
                    System.out.println("Diem thap nhat: " + min);
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("So SV dat: " + dat);
                    System.out.println("So SV truot: " + truot);
                    break;

                case 6:
                    Arrays.sort(diem, 0, n);
                    System.out.println("Da sap xep diem tang dan!");
                    break;

                case 7:
                    int gioi = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 8) gioi++;
                    }
                    System.out.println("So SV gioi va xuat sac: " + gioi);
                    break;

                case 8:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 8);
    }
}