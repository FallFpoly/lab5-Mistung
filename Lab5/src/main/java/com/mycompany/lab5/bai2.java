package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bai2 {

    static ArrayList<String> danhSach = new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("Chọn chức năng: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (chon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    ngaunhien();
                    break;
                case 4:
                    sapxep();
                    break;
                case 5:
                    xoa();
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 6.");
            }
        }
    }

    public static void menu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Nhập danh sách họ và tên");
        System.out.println("2. Xuất danh sách vừa nhập");
        System.out.println("3. Xuất danh sách ngẫu nhiên");
        System.out.println("4. Sắp xếp giảm dần và xuất danh sách");
        System.out.println("5. Tìm và xóa họ tên nhập từ bàn phím");
        System.out.println("6. Kết thúc");
    }

    public static void nhap() {
        while (true) {
            System.out.print("Nhập họ và tên: ");
            String hoTen = sc.nextLine();
            danhSach.add(hoTen);

            System.out.print("Nhập thêm (Y/N)? ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void xuat() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.println("Danh sách họ tên:");
        for (String hoTen : danhSach) {
            System.out.println(hoTen);
        }
    }

    public static void ngaunhien() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        Collections.shuffle(danhSach);
        System.out.println("Danh sách ngẫu nhiên:");
        xuat();
    }

    public static void sapxep() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        Collections.sort(danhSach);
        Collections.reverse(danhSach);
        System.out.println("Danh sách sắp xếp giảm dần:");
        xuat();
    }

    public static void xoa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.print("Nhập họ tên cần xóa: ");
        String tenXoa = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).equalsIgnoreCase(tenXoa)) {
                danhSach.remove(i);
                found = true;
                System.out.println("Đã xóa: " + tenXoa);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy tên cần xóa.");
        }
    }
}