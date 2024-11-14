package com.quest.practice_vars;

public class StudentScores {
    public static void main(String[] args) {
        // Step 1: Initialize arrays
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"};
        int[] ages = {20, 21, 22, 23, 24, 25, 26};
        int[][] scores = {
                {85, 90, 78, 92, -1},
                {88, 92, 80, -1, 85},
                {75, 80, 70, 60, 72},
                {90, 85, 88, 95, 92},
                {65, 70, 60, 68, 67},
                {80, 85, -1, 90, 95},
                {90, 88, 92, 85, 80}
        };
        //  Calculate average scores
        calculateAverageScores(names, ages, scores);

        //  Find the highest scorer
        findHighestScorer(names, ages, scores);

        //  Ranking students by average score
        rankStudents(names, ages, scores);

        // Detect missing data
        detectMissingData(names, scores);

    }

    // Method to calculate and print average scores

    public static void calculateAverageScores(String[] names, int[] ages, int[][] scores){
        int[] sum=new int[names.length];
        int[] avg=new int[names.length];

        for(int i=0; i<names.length; i++){
            for(int j=0; j<scores[i].length; j++) {
                sum[i] += scores[i][j];
            }
            avg[i]=sum[i]/scores[i].length;

        }

        System.out.println("-----------AVERAGE SCORES------------");
        for(int i=0; i<names.length; i++){
            System.out.println(names[i]+" : age : "+ages[i]+" avreage score : "+avg[i]);
        }

    }


    // Method to find the student with the highest average score
    public static void findHighestScorer(String[] names, int[] ages, int[][] scores){
        int[] sum=new int[names.length];
        int[] avg=new int[names.length];

        for(int i=0; i<names.length; i++){
            for(int j=0; j<scores[i].length; j++) {
                sum[i] += scores[i][j];
            }
            avg[i]=sum[i]/scores[i].length;

        }

        System.out.println("--------HIGHEST SCORER---------");
        int max= avg[0];
        int j=0;
        for(int i=0; i<avg.length; i++){
            if(avg[i]>max){
                max=avg[i];
                j=i;
            }
        }
        System.out.println(names[j]+":"+max);
    }

    // Method to rank students based on average score
    public static void rankStudents(String[] names, int[] ages, int[][] scores) {
        int[] sum=new int[names.length];
        int[] avg=new int[names.length];

        for(int i=0; i<names.length; i++){
            for(int j=0; j<scores[i].length; j++) {
                sum[i] += scores[i][j];
            }
            avg[i]=sum[i]/scores[i].length;

        }
        for (int i = 0; i < avg.length ; i++) {
            for (int j =i+1; j < avg.length ; j++) {
                if (avg[i] < avg[j]) {

                    int temp = avg[i];
                    avg[i] = avg[j];
                    avg[j] = temp;

                    String name=names[i];
                    names[i]=names[j];
                    names[j]=name;
                }
            }

        }
        System.out.println("--------STUDENT RANKINGS---------");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - Average Score: " + avg[i]);
        }
    }


    // Method to detect missing data in the scores array
    public static void detectMissingData(String[] names, int[][] scores) {
        System.out.println("--------MISSING DATA ---------");


        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] == -1) {
                    System.out.println("Missing score for " + names[i] + " in subject " + (j + 1));
                }
            }
        }
    }

}
