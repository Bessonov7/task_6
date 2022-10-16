package ru.vsu.sc.bessonov;

import java.util.Scanner;

public class task6 {
    public static class Solution {
        public double sumN;
        public double sumE;
        public int nE;
        public double sumE10;
        public int nE10;
        public double fValue;
    }

    public static Solution calc(double x, int n, double e) {
        Solution sol = new Solution();
        sol.fValue = Math.sinh(x);

        double a = x;

        for (int i = 1; i <= n || Math.abs(a) > e / 10; i++) {
            if (i <= n) {
                sol.sumN += a;
            }

            if (Math.abs(a) > e) {
                sol.sumE += a;
                sol.nE++;
            }

            if (Math.abs(a) > e / 10) {
                sol.sumE10 += a;
                sol.nE10++;
            }
            a = next(a, i, x);
        }
        return sol;
    }

    public static double next(double a, int i, double x) {
        return (a * x * x) / ((2 * i) * (2 * i + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = sc.nextInt();
        System.out.print("Введите e: ");
        double e = sc.nextDouble();
        System.out.print("Введите x: ");
        double x = sc.nextDouble();

        System.out.printf("Сумма слагаемых: %.010f%n", calc(x, n, e).sumN);
        System.out.printf("Сумма слагаемых больших e: %.010f%n", calc(x, n, e).sumE);
        System.out.printf("Количество слагаемых больших e: %d%n", calc(x, n, e).nE);
        System.out.printf("Сумма слагаемых больших е деленное на 10: %.010f%n", calc(x, n, e).sumE10);
        System.out.printf("Количество слагаемых больших e деленное на 10: %d%n", calc(x, n, e).nE10);
        System.out.printf("Значение функции Math: %.010f%n", calc(x, n, e).fValue);
    }
}