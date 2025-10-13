
package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập số thực: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Giá trị không hợp lệ. Vui lòng nhập số thực: ");
                sc.next(); 
            }
            double x = sc.nextDouble();
            list.add(x);
            sc.nextLine(); 

            System.out.print("Nhập thêm (Y/N)? ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("\nDanh sách các số thực đã nhập:");
        for (Double number : list) {
            System.out.println(number);
        }

        double sum = 0;
        for (Double number : list) {
            sum += number;
        }

        System.out.println("Tổng các số thực: " + sum);
    }
}