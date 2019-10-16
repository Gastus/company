package com.company;

import java.util.TreeMap;

public class RomeNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();


    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    private String romeNumber;

    public RomeNumber(String romeNumber) {
        this.romeNumber = romeNumber;
    }

    public int getRomeInt() throws NumberFormatException {
        switch (romeNumber.toUpperCase()){
            default: throw new NumberFormatException("Не верный формат числа");
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
        }
    }


    public static boolean isRomeNumber(String s){
        try {
            RomeNumber romeNumber = new RomeNumber(s);
            romeNumber.getRomeInt();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}
