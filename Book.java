package com.company;

import java.util.*;
import java.io.*;

public class Book {

    private static String pathFile = "/Users/gl-user/Desktop/BookStoreFile.txt";
    private static String pathFile_query = "/Users/gl-user/Desktop/BookStoreFile_query.txt";
    private static String pathFile_borrow = "/Users/gl-user/Desktop/";

    private static String strChange = "";
    private static String strChangeEmp = "";
    private static ArrayList<HashMap<String, String>> books = MainFunction.readFile();
    private static CreateKeysBook objRandomKeys = new CreateKeysBook() ;

    public Book(int count){

        books = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        objRandomKeys = new CreateKeysBook() ;

        int roundMax = 1 ;
        int maxType = 8 ;
        int countBook = count ;
        int pointCheck = 1 ;
        maxType = countBook/maxType; //25 loop plus one value
        //maxType = maxType+ ;
        String strCode,strCodeHeader,strCodeTails,strBookName;
        strCode = "" ;
        int plusCode ;
        for(int i = 1;i <= countBook ;i++){
            if(pointCheck <= maxType){

                if(strCode == ""){
                    strCode = objRandomKeys.createKeysBook(roundMax);
                }
                strBookName = objRandomKeys.genNameBooks(roundMax);
                int lenStr = strCode.length();
                strCodeHeader = strCode.substring(0,3);
                strCodeTails = strCode.substring(3,lenStr);
                strCode = strCodeHeader+(Integer.valueOf(strCodeTails)+1);

                map = new HashMap<String, String>();
                map.put("key", strCode);
                map.put("Name",strBookName+(pointCheck));
                map.put("type", String.valueOf(roundMax));
                map.put("status", "Already");
                map.put("bookBorrower","-");
                map.put("bookDateBorrow","-");
                map.put("bookDateReverse","-");
                map.put("bookWriter","BIX");
                pointCheck++ ;

                books.add(map);

            }else{
                strCode = "" ;
                pointCheck = 1 ;
                roundMax ++ ;
                i = i-1 ;
            }
        }
        Initial.saveArrayTofile();
        MainFunction.readFile();

    }

    public static ArrayList<HashMap<String,String>> readFile() {
        ArrayList<HashMap<String,String>> bookRead = new ArrayList<HashMap<String,String>>();
        File bookFile = new File(pathFile);
        if (!bookFile.exists())
            System.out.println("File doesn't exist");

        InputStreamReader isReader;
        try {

            FileInputStream fis = new FileInputStream(pathFile);
            isReader = new InputStreamReader(fis);

            ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();

            try (BufferedReader br = new BufferedReader(new FileReader(bookFile))) {

                while (br.ready()) {
                    strChange = br.readLine();
                    HashMap map = new HashMap<String, String>();
                    map = new HashMap<String, String>();
                    for (int i = 0; i <= 7; i++) {

                        switch (i) {
                            case 0:
                                map.put("key", checkAlphabat(strChange));
                                break;
                            case 1:
                                map.put("Name", checkAlphabat(strChange));
                                break;
                            case 2:
                                map.put("type", checkAlphabat(strChange));
                                break;
                            case 3:
                                map.put("status", checkAlphabat(strChange));
                                break;
                            case 4:
                                map.put("bookBorrower", checkAlphabat(strChange));
                                break;
                            case 5:
                                map.put("bookDateBorrow", checkAlphabat(strChange));
                                break;
                            case 6:
                                map.put("bookDateReverse", checkAlphabat(strChange));
                                break;
                            case 7:
                                map.put("bookWriter", checkAlphabat(strChange));
                                break;
                            default:
                                System.out.println("end");
                                break;

                        }
                    }

                    bookRead.add(map);
                }
            }

        } catch (Exception e) {
            System.out.println("error load cache from file " + e.toString());
        }

        return bookRead ;

    }
    public static String checkAlphabat(String str){
        int lenStr = str.length();
        String chkChar ="" ;
        String Char ="" ;
        for(int i = 0 ; i < lenStr ;i ++){
            char c = str.charAt(i);
            Char = String.valueOf(c);

            if (Char.equals("|")){
                chkChar = chkChar.substring(0,i);
                strChange = str.substring(i+1,lenStr);
                return chkChar ;
                //break;
            }else{
                chkChar += String.valueOf(c) ;
            }

        }

        return chkChar ;
    }

    public static ArrayList<HashMap<String, String>> getBooks() {
        return books;
    }
}

