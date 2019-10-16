package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение через пробел");
        String exp = br.readLine();
        String[] nums = exp.split(" ");
        int n1, n2;

        if(RomeNumber.isRomeNumber(nums[0])){
            if(!RomeNumber.isRomeNumber(nums[2])){
                throw new IllegalArgumentException("В выражении должны быть только рисмские или только рабские цифры");
            }
        }

        if(RomeNumber.isRomeNumber(nums[2])){
            if(!RomeNumber.isRomeNumber(nums[0])){
                throw new IllegalArgumentException("В выражении должны быть только рисмские или только рабские цифры");
            }
        }

        boolean isRomeValues=false;
        try {
            n1 = Integer.parseInt(nums[0]);
        } catch (NumberFormatException e){
            //может это римские цифры??
            RomeNumber romeNumber = new RomeNumber(nums[0]);
            n1=romeNumber.getRomeInt();
            isRomeValues=true;
        }

        try {
            n2 = Integer.parseInt(nums[2]);
        } catch (NumberFormatException e){
            //может это римские цифры??
            RomeNumber romeNumber = new RomeNumber(nums[2]);
            n2=romeNumber.getRomeInt();
            isRomeValues=true;
        }


        switch (nums[1]){
            default:
                throw new IllegalArgumentException("Неизвестный знак вычисления");
            case "-":
                printAnswer((n1-n2), isRomeValues);
                break;
            case "+":
                printAnswer(n1+n2, isRomeValues);
                break;
            case "*":
                printAnswer(n1*n2, isRomeValues);
                break;
            case "/":
                printAnswer(n1/n2, isRomeValues);
                break;
        }

    }

    public static void printAnswer(double answer, boolean toRomeNum){
        if(!toRomeNum){
            System.out.println("="+answer);
        }else{
            int r =(int) Math.round(answer);
            System.out.println("="+RomeNumber.toRoman(r));
        }
    }
}
