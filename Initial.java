package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.text.*;

public class Initial {

    private static final String[] typeTxt = new String[]{"Sport", "History", "News", "Economy", "Movie", "SuperStar",
            "Holywood"};
    private static final String[] nameTxt = new String[]{"Sport book","History book","News book","Economy book",
            "Movie book",
            "SuperStar book","Holywood book"};
    private static final String[] keysTxt = new String[]{"[SP]","[HY]","[NS]","[EC]","[MS]","[SS]","[HW]"};

    private static final String pathFile = "/Users/gl-user/Desktop/BookStoreFile.txt";
    private static final String pathFile_query = "/Users/gl-user/Desktop/BookStoreFile_query.txt";
    private static final String pathFile_borrow = "/Users/gl-user/Desktop/";
    public static Scanner myObj = new Scanner(System.in);

    //private static String strChangeEmp;

    public static String GentType(int x){
        if(x >= typeTxt.length)return "Another" ;
        return typeTxt[x] ;
    }

    public static String GentName(int x){

        if(x >= nameTxt.length) return "Another Book";
        return nameTxt[x] ;
    }

    public static String GentKeys(int x){
        if(x >= keysTxt.length) return "[AN]";
        return keysTxt[x] ;
    }

    public static String[] getTypeTxt() {
        return typeTxt;
    }

    public static String[] getNameTxt() {
        return nameTxt;
    }

    public static String[] getKeysTxt() {
        return keysTxt;
    }

    static int getIndexBooks(ArrayList<HashMap<String, String>> objBooks, String str) {

        for (int i = 0; i < objBooks.size(); i++) {
            HashMap<String, String> map = objBooks.get(i);
            if (map.containsValue(str)) {
                return i;
            }
        }
        return -1;
    }

    protected static void saveArrayTofile(){
        File saveFile = new File(pathFile);
        saveFile.delete();
        if (!saveFile.exists()) {
            try {
                File directory = new File(saveFile.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                saveFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Excepton Occured: " + e.toString());
            }
        }
        try {
            // Convenience class for writing character files
            FileWriter bookFileWrite;
            bookFileWrite = new FileWriter(saveFile.getAbsoluteFile(), true);

            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(bookFileWrite);
            for(int i = 0 ;i < Book.getBooks().size();i++){
                bufferWriter.write(Book.getBooks().get(i).get("key").toString()+"|"+Book.getBooks().get(i).get("Name").toString()+"|"+
                        Book.getBooks().get(i).get("type").toString()+"|"+Book.getBooks().get(i).get("status").toString()+"|"+
                        Book.getBooks().get(i).get("bookBorrower").toString()+"|"+Book.getBooks().get(i).get("bookDateBorrow").toString()+"|"+
                        Book.getBooks().get(i).get("bookDateReverse").toString()+"|"+Book.getBooks().get(i).get("bookWriter").toString()+"\n");

            }

            //bufferWriter.write(books.toString());
            bufferWriter.close();

            //System.out.println("Company data saved at file location: " + pathFile + "\n");
        } catch (IOException e) {
            //System.out.println("Hmm.. Got an error while saving Company data to file " + e.toString());
        }
    }



    public static String getPathFile() {
        return pathFile;
    }

    public static String getPathFile_query() {
        return pathFile_query;
    }

    public static String getPathFile_borrow() {
        return pathFile_borrow;
    }
}
