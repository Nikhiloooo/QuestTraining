package com.quest.multithreading.usecase;

public class MatrixMultiplication extends Thread {
    private int[][] A;
    private int[][] B;
    private int[][] C;
    private int rowIndex;
    private int n;

    MatrixMultiplication(int[][] A, int[][] B, int[][] C, int rowIndex, int n) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.rowIndex = rowIndex;
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Matrix multiplication started");
        for (int j = 0; j < B[0].length; j++) {
            C[rowIndex][j] = 0;
            for (int k = 0; k < n; k++) {
                C[rowIndex][j] += A[rowIndex][k] * B[k][j];
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Matrix multiplication finished");

    }
}

class Main {
    public static void main(String[] args)  {

        int[][] A = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        int[][] B = {
                {1, 2, 3},
                {4, 5, 6},
        };

        int m = 3;
        int n = 2;
        int p = 3;

        int[][] C = new int[m][p];

        Thread thread1 = new MatrixMultiplication(A, B, C, 0, n);
        Thread thread2 = new MatrixMultiplication(A, B, C, 1, n);
        Thread thread3 = new MatrixMultiplication(A, B, C, 2, n);
try{
    thread1.start();
    thread1.join();
    thread2.start();
    thread2.join();
    thread3.start();
    thread3.join();
}
catch (InterruptedException e) {
    e.printStackTrace();
}



        System.out.println("result C");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

    }
}
