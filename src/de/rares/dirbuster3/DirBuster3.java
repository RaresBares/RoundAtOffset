package de.rares.dirbuster3;

import de.rares.dirbuster3.dir.Dir;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DirBuster3 {
public static String url;
public static int threads;
public static Scanner lsc;
public static Dir Maindir = new Dir("/");
public static ArrayList<Dir> Maindirs = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the URL:");
        Scanner sc = new Scanner(System.in);
        url = sc.nextLine();
        System.out.println("Where is the List saved?");
        String glist = sc.nextLine();
        System.out.println("How many Threads would you need?");
         threads = sc.nextInt();

    }

    }
