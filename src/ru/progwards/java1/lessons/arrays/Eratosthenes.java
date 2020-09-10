package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    int N;
      private boolean[] sieve;

    public Eratosthenes(int N) {
        this.N = N;
        sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        for (int i = 2; i < N; i++) {
            if (sieve[i]) {
                for (int j = 2; i * j < N + 1; j++) {
                    sieve[i * j] = false;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        boolean temp = false;
        if (sieve[n]) {
            temp = true;
        }
        return temp;
    }

    public static void main(String[] args) {
        Eratosthenes one = new Eratosthenes(15);
        one.sift();
        //one.isSimple(14);
        System.out.println();
        System.out.println(one.isSimple(4));
        System.out.println();
    }
}
