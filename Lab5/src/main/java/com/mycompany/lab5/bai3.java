package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    String ten;
    Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: " + ten + " | Đơn giá: " + String.format("%.2f", donGia);
    }
}

public class bai3 {
static ArrayList<SanPham> danhSachSP = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("Chọn chức năng: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5!");
                continue;
            }

            switch (chon) {
                case 1 -> nhap();
                case 2 -> sapXepGiamDan();
                case 3 -> timVaXoa();
                case 4 -> tinhGiaTrungBinh();
                case 5 -> {
                    System.out.println("Kết thúc chương trình.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Vui lòng chọn từ 1 đến 5.");
        }
        }
    }

    public static void menu() {
        System.out.println("\n========= MENU =========");
        System.out.println("1. Nhập danh sách sản phẩm");
        System.out.println("2. Sắp xếp giảm dần theo giá và xuất");
        System.out.println("3. Tìm và xóa sản phẩm theo tên");
        System.out.println("4. Xuất giá trung bình của các sản phẩm");
        System.out.println("5. Thoát");
    }

    public static void nhap() {
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String ten = sc.nextLine().trim();

            System.out.print("Nhập đơn giá: ");
 double gia;
            try {
                gia = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Đơn giá không hợp lệ! Nhập lại.");
                continue;
            }

            danhSachSP.add(new SanPham(ten, gia));

            System.out.print("Nhập thêm sản phẩm (Y/N)? ");
            String ans = sc.nextLine().trim();
            if (ans.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void sapXepGiamDan() {
        if (danhSachSP.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        danhSachSP.sort((o1, o2) -> o2.donGia.compareTo(o1.donGia));
  System.out.println("Danh sách sản phẩm sau khi sắp xếp giảm dần theo giá:");
        for (SanPham sp : danhSachSP) {
            System.out.println(sp);
        }
    }

    public static void timVaXoa() {
        if (danhSachSP.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String tenXoa = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < danhSachSP.size(); i++) {
            if (danhSachSP.get(i).ten.equalsIgnoreCase(tenXoa)) {
                danhSachSP.remove(i);
                System.out.println("Đã xóa sản phẩm: " + tenXoa);
                found = true;
                break;
            }
        }
 if (!found) {
            System.out.println("Không tìm thấy sản phẩm cần xóa.");
        }
    }

    public static void tinhGiaTrungBinh() {
        if (danhSachSP.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        double tong = 0;
        for (SanPham sp : danhSachSP) {
            tong += sp.donGia;
        }

        double trungBinh = tong / danhSachSP.size();
        System.out.printf("Giá trung bình của các sản phẩm là: %.2f\n", trungBinh);
    }
}
