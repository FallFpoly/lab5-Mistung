
package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        return "Tên sản phẩm: " + ten + " | Đơn giá: " + donGia;
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
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5!");
                continue;
            }

            switch (chon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    sapXepGiamDan();
                    break;
                case 3:
                    timVaXoa();
                    break;
                case 4:
                    tinhGiaTrungBinh();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 5.");
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
            String ten = sc.nextLine();

            System.out.print("Nhập đơn giá: ");
            double gia;
            try {
                gia = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Đơn giá không hợp lệ! Nhập lại.");
                continue;
            }

            danhSachSP.add(new SanPham(ten, gia));

            System.out.print("Nhập thêm sản phẩm (Y/N)? ");
            String ans = sc.nextLine();
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

        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return o2.donGia.compareTo(o1.donGia); // Giảm dần
            }
        };

        Collections.sort(danhSachSP, comp);

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
        String tenXoa = sc.nextLine();
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
        System.out.println("Giá trung bình của các sản phẩm là: " + trungBinh);
    }
}