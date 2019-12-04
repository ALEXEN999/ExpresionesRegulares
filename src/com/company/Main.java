package com.company;

import java.io.*;

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

    }
}
