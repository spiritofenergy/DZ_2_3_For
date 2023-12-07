package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1.Выведите числа от двух в десятой степени до десяти в четвертой степени \n");
        for (int mathPow = (int) pow(2, 10); mathPow < pow(10, 4); mathPow++) {
            System.out.print(mathPow + ", ");
        }
        //////////////////
        System.out.println("2.Сохраните миллион файлов. Получилось?");
        for (int i = 1; i < 31; i++) {
            String str = "Hello";
            BufferedWriter writer = new BufferedWriter(new FileWriter(i + " fileName.exe"));
            writer.write(str);
            writer.close();
        }
        //////////////////
        System.out.println("3.Выведите буквы от а до я (подсказка: for (char letter=’а’; letter<=’я’; letter++) )");
        for (char letter = 'а'; letter <= 'я'; letter++) {
            System.out.print(" " + letter + "  "); ;
        }System.out.println("\n");
        //////////////////
        System.out.println(" 4.выведите десять букв в алфавите после буквы й");
        System.out.print(" Алфавит после буквы й  :   ");
        char letter = 'й';
        for (int i = 0; i < 10; i++) {
            letter++;
            System.out.print(" " + letter + " ");
        }System.out.println("\n");
        //////////////////
        System.out.println("5.выведите десять букв в алфавите, идущие до буквы ю");
        char after_U = 'ю';
        for (int y = 1; y <= 10; y++) {
            after_U--;
            System.out.print(" " + after_U + " ");
        }System.out.println("\n");
        ///////////////
        System.out.println("6.выведите каждую вторую букву алфавита (а, в, д)");
        for (char letter_A = 'а'; letter_A < 'я'; letter_A += 2) {
            System.out.print(" " + letter_A + " ");
        }System.out.println("\n");
        /////////////////
        System.out.println("7.выведите каждую третью букву латинского алфавита");
        for (char letter_AZ = 'a'; letter_AZ <= 'z'; letter_AZ += 3) {
            System.out.print(" " + letter_AZ + " ");
        }System.out.println("\n");
        /////////////////
        System.out.println("8.выведите греческий алфавит (коды с 945по 969) через запятую (α, β, ...)");
        for (char ch = 'α'; ch <= 'ω'; ch++) {
            if ((int) ch >= 945 || (int) ch > 969) {
                System.out.print(ch + ":(" + ((int) ch) + "), ");
            }
        } System.out.println("\n");
        //////////////////
        System.out.println("9.Выведите в файл list.html список :<ul><li> 1 element </li><li> 2 element </li>...<li> 100 element </li></ul>");
        File output = new File("list.html");
        FileWriter writer = new FileWriter(output);
        writer.write("             <ul><li>\n");
        writer.write("1   element </li><li>\n");
        writer.write("2   element </li>...<li>\n");
        writer.write("100 element </li></ul>\n");
        writer.flush();
        writer.close();
        System.out.println("Готово!");

        /////////////////
        System.out.println("10.Выведите курс валют за 1 число каждого месяца в 2014 году");
        for (int month = 1; month <= 12; month++) {
            String strMonth = month < 10 ? "0" + month : String.valueOf(month);
            String page1 = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req=01/" + strMonth + "/2014");
            int startIndex1 = page1.lastIndexOf("<Value>");
            int endIndex1 = page1.lastIndexOf("</Value>");
            String courseStr1 = page1.substring(startIndex1 + 7, endIndex1);
            System.out.println(01 + "/" + strMonth + "/2014 : " + courseStr1);
        }
        //////////////////
        System.out.println("11.Выведите курс валют за 1 февраля  каждого года с 1994 до текущего года");

        for (int year = 1994; year <= 2023; year++) {
            String page1 = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req=01/02/" + year + "");
            int startIndex1 = page1.lastIndexOf("<Value>");
            int endIndex1 = page1.lastIndexOf("</Value>");
            String courseStr1 = page1.substring(startIndex1 + 7, endIndex1);
            System.out.println("01/02/" + year + " : " + courseStr1);
        }
    }
        private static String downloadWebPage (String url) throws IOException {
            StringBuilder result = new StringBuilder();
            String line;
            URLConnection urlConnection = new URL(url).openConnection();
            try (InputStream is = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        }
    }



