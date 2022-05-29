/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tebakhuruf;

import java.util.Scanner;

/**
 *
 * @author Miss KaNiRa
 */
public class TebakHuruf {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        // variable
        String answer = "SEMUA";
        String words = "?-S-E-M-U-A";
        String regex = "-";
        String[] letter = words.split(regex);
        int length = letter.length-1;

        // pembuka
        System.out.println("Memulai permainan tebak kata");
        System.out.println("==========================================================");
        System.out.println("Ketentuan:"); 
        System.out.println("1. Pemain diperbolehkan menebak huruf vokal sebanyak 3 kali");
        System.out.println("2. Pemain diperbolehkan menebak huruf konsonan sebanyak 5 kali");  
        System.out.println("3. Pemain diperbolehkan menebak kata yang terbentuk sebanyak 3 kali"); 
        System.out.println("==========================================================");
        System.out.println("Hint:"); 
        System.out.println("1. Kata ini terdiri dari " + length + " huruf"); 
        System.out.println("2. Kata ini tak memiliki huruf yang sama");
        System.out.println("3. Kata ini terdapat pada KBBI");
        System.out.println("==========================================================");

        for(int i = 0; i < 3; i++){
        System.out.println("Masukkan huruf vokal:");
        String vowel = sc.next().toUpperCase();
            if(vowel(letter, vowel).equals("0")){
                System.out.println(vowel + " bukan huruf vokal.");
                i = i-1;
            } else if (vowel(letter, vowel).equals("-1")){
                System.out.println(vowel + " tidak terdapat dalam kata");
            } else if (!vowel(letter, vowel).equals("0")){
                System.out.println(vowel + " berada pada posisi ke " 
                    + vowel(letter, vowel));
            }
        }

        for(int i = 0; i < 5; i++){
        System.out.println("Masukkan huruf konsonan : ");
        String consonant = sc.next().toUpperCase();
            if(consonant(letter, consonant).equals("0")){
                System.out.println(consonant + " bukan huruf konsonan");
                i = i-1;
            } else if (consonant(letter, consonant).equals("-1")){
                System.out.println(consonant + " tidak terdapat dalam kata");
            } else if (!consonant(letter, consonant).equals("0")){
                System.out.println(consonant + " berada pada posisi ke " 
                    + consonant(letter, consonant));
            }
        }

        // tebakan
        for(int i = 0; i < 3; i++){
        System.out.println("Masukkan jawaban : ");
        String search = sc.next().toUpperCase();
        int chance = 2 - i;
            if(i == 2 && guess(search, answer).equals("1")){
                System.out.println("GAME OVER! No More Guesses.");
                System.out.println("Kata yang benar : " + answer);
            } else if(guess(search, answer).equals("-1")){
                System.out.println("Yeay! Jawaban Anda Benar.");
                System.out.println("Kata tersembunyi adalah " + answer);
                break;
            } else if(i == 0){
                System.out.println("Salah! " + chance + " kesempatan lagi.");
            } else if(i == 1){
                System.out.println("Salah! " + chance + " kesempatan lagi.");
            }
        }  
    }

    private static String vowel(String[]arr, String variable){
        for(int i = 0; i < arr.length; i++)
            if(arr[i].equals(variable) || !(variable.equals("A") || variable.equals("I") ||
                variable.equals("U") || variable.equals("E") || variable.equals("O"))){
                return String.valueOf(i);
            }
                return "-1";
    }

    private static String consonant(String[]arr, String variable){
        for(int i = 0; i < arr.length; i++)
            if(arr[i].equals(variable) || variable.equals("A") || variable.equals("I") ||
                variable.equals("U") || variable.equals("E") || variable.equals("O")){
                return String.valueOf(i);
            }
                return "-1";
    }

    private static String guess(String variable, String answer){
            if(!variable.equals(answer)){
                return "1";
            }
                return "-1";
    }

}
