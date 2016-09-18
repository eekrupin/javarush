package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ibig = new int[20];
        int[] ismall1 = new int[10];
        int[] ismall2 = new int[10];

        for (int j = 1; j <=20 ; j++){
            ibig[j-1] = Integer.parseInt(br.readLine());
        }

        for (int j = 1; j <=ibig.length ; j++){
            if (j<=ibig.length/2) ismall1[j - 1] = ibig[j - 1];
            else ismall2[j - 1 - ibig.length/2] = ibig[j - 1];
        }

        for (int j = 1; j <=ismall2.length ; j++){
            System.out.println(ismall2[j-1]);
        }

    }
}
