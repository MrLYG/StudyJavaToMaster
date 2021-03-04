package client;

import java.util.Scanner;

/**
 * 实现扫描器工具类的封装
 */
public class ClientScanner {
    private static Scanner sc = new Scanner(System.in);


    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        ClientScanner.sc = sc;
    }

    public static void closeScanner(){
        sc.close();
    }
}
