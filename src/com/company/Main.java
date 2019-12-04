package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String pareNoel = "*<]:-DOo";
    public static String rens = ">:o)";
    public static String follets = "<]:-D";

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(new File("santako.txt"));
        BufferedReader inputStream = new BufferedReader(fileReader);
        int countP = 0;
        int countR = 0;
        int countF = 0;
        System.out.println();
        System.out.println("SIN EXPRESIONES REGULARES ");
        System.out.println();
        char c = ' ';
        String line ="";
        while ((line = inputStream.readLine())!=null){
            try {
                if (line == null){
                    break;
                }else{
                    for (int i = 0; i <line.length() ; i++) {

                        switch (line.charAt(i)){
                            case '*':
                                if (line.substring(i, i+pareNoel.length()).equals(pareNoel)){

                                    i += pareNoel.length();
                                    countP++;
                                }
                                break;
                            case '>':
                                if (line.substring(i, i+rens.length()).equals(rens)){

                                    i += rens.length();
                                    countR++;
                                }
                                break;
                            case '<':
                                if (line.substring(i, i+follets.length()).equals(follets)){

                                    i += follets.length();
                                    countF++;
                                }
                                break;
                        }

                    }


                }
                if (countP>0){
                    System.out.print("Pare Noel ("+countP+") ");
                }
                if (countR>0){
                    System.out.print("Ren ("+countR+") ");

                }
                if (countF>0){
                    System.out.print("Follet ("+countF+") ");
                }
                System.out.println();

                countF = 0;
                countP = 0;
                countR = 0;
            }catch (StringIndexOutOfBoundsException e){

            }

        }
        fileReader.close();
        inputStream.close();


        ////////////  CON EXPRESIONES REGULARES   //////////////
        int countP2 = 0;
        int countR2 = 0;
        int countF2 = 0;

        System.out.println();
        System.out.println("CON EXPRESIONES REGULARES ");
        System.out.println();
        FileReader fileReader2 = new FileReader(new File("santako.txt"));
        BufferedReader inputStream2 = new BufferedReader(fileReader2);

        String line2 ="";
        while ((line2 = inputStream2.readLine())!=null){

            Pattern patternNoel = Pattern.compile("\\"+pareNoel);
            Pattern patternRens = Pattern.compile(">:o\\)");
            Pattern patternFollets = Pattern.compile(follets);

            Matcher matcherNoel = patternNoel.matcher(line2);
            Matcher matcherRens = patternRens.matcher(line2);
            Matcher matcherFollets = patternFollets.matcher(line2);

            while (matcherNoel.find()){
                countP2++;
            }
            while (matcherRens.find()){
                countR2++;
            }
            while (matcherFollets.find()){
                countF2++;
            }

            if (countP2>0){
                System.out.print("Pare Noel ("+countP2+") ");
                countF2 =countF2-countP2;

            }
            if (countR2>0){
                System.out.print("Ren ("+countR2+") ");

            }
            if (countF2>0){

                System.out.print("Follet ("+countF2+") ");

            }
            if (countP2 != 0 || countR2 != 0|| countF2 != 0){
                System.out.println();
            }
            countF2 = 0;
            countP2 = 0;
            countR2 = 0;
        }
        fileReader2.close();
        inputStream2.close();
    }
}
