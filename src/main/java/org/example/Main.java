package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {}

    public static boolean first() {
        for(int i = 1; i <= 500; i++)
        {
            if(i % 5 == 0 && i % 7 == 0)
            {
                System.out.println("fizzbuzz");
            }
            else if(i % 5 == 0)
            {
                System.out.println("fizz");
            }
            else if(i % 7 == 0)
            {
                System.out.println("buzz");
            }
            else
            {
                System.out.println(i);
            }
        }
        return true;
    }
    public static boolean second()
    {
        String str = "make install";
        for(int i = str.length()-1; i >= 0; i--)
        {
            System.out.print(str.charAt(i));
        }
        return true;
    }
    public static boolean third()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите коэффицент a: ");
        double a = in.nextDouble();
        System.out.println("Введите коэффицент b: ");
        double b = in.nextDouble();
        System.out.println("Введите коэффицент c: ");
        double c = in.nextDouble();
        double D = b * b - 4 * a * c;
        if(D > 0)
        {
            double resultplus = (-1 * b + Math.sqrt(D)) / 2 * a;
            double resultminus = (-1 * b - Math.sqrt(D)) / 2 * a;
            System.out.println("Корни уравнения равны: x1 = " + resultplus + " x2 = " + resultminus);
        }
        return true;
    }
    public static boolean fourth()
    {
        double resultall = 0;
        double result = 1;
        for(int i = 2; result > 0.000001; i++)
        {
            result = (double) 1 / (i * i + i - 2);
            resultall += result;
        }
        System.out.println(resultall);
        return true;
    }
    public static boolean fifth(String str)
    {
        int pal = 0;
        for(int i = 0, j = str.length() - 1; i != j; i++)
        {
            if(str.charAt(i) == str.charAt(j-i))
            {
                pal++;
            }
            else
            {
                System.out.println("Не палиндром");
                break;
            }
        }
        if(pal == str.length()-1)
        {
            System.out.println("Палиндром");
        }
        return true;
    }
}