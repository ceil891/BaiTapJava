package BaiTapSS5;

public class Kha02 {
    public static void main(String[] args) {

        String str = "Hello";
        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            str = str + " World";
        }

        long end1 = System.currentTimeMillis();
        System.out.println("Thời gian String: " + (end1 - start1) + " ms");


        StringBuilder sb = new StringBuilder("Hello");
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            sb.append(" World");
        }

        long end2 = System.currentTimeMillis();
        System.out.println("Thời gian StringBuilder: " + (end2 - start2) + " ms");


        StringBuffer sf = new StringBuffer("Hello");
        long start3 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            sf.append(" World");
        }

        long end3 = System.currentTimeMillis();
        System.out.println("Thời gian StringBuffer: " + (end3 - start3) + " ms");

    }
}