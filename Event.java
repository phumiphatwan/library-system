package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Event {

    public static String GentKeyBook(int type){
        Random rand = new Random();
        String strType ;
        int n ;

        switch(type) {
            case 1 :
                //Sport
                n = rand.nextInt(1000);
                strType = "ST01"+n ;
                //System.out.println(type);
                break;
            case 2 :
                //Kids
                n = rand.nextInt(1000);
                strType = "ST02"+n ;
                //System.out.println(type);
                break;
            case 3 :
                //Economy
                n = rand.nextInt(1000);
                strType = "ST03"+n ;
                //System.out.println(type);
                break;
            case 4 :
                //Health
                n = rand.nextInt(1000);
                strType = "ST04"+n ;
                //System.out.println(type);
                break;
            case 5 :
                //Adult
                n = rand.nextInt(1000);
                strType = "ST05"+n ;
                //System.out.println(type);
                break;
            case 6 :
                //Car
                n = rand.nextInt(1000);
                strType = "ST06"+n ;
                //System.out.println(type);
                break;
            case 7 :
                //News
                n = rand.nextInt(1000);
                strType = "ST07"+n ;
                //System.out.println(type);
                break;
            default:
                //Etc
                n = rand.nextInt(1000);
                strType = "ST99"+n ;
                //System.out.println(type);
                break;
        }

        return strType ;
    }
    public static String GenTypeBooks(int type) {
        String strType ;
        switch(type) {
            case 1 :
                //Sport
                strType = "Sport" ;
                //System.out.println(type);
                break;
            case 2 :
                //Kids
                strType = "Kids" ;
                //System.out.println(type);
                break;
            case 3 :
                //Economy
                strType = "Economy" ;
                //System.out.println(type);
                break;
            case 4 :
                //Health
                strType = "Health" ;
                //System.out.println(type);
                break;
            case 5 :
                //Adult
                strType = "Adult 18+" ;
                //System.out.println(type);
                break;
            case 6 :
                //Car
                strType = "Car" ;
                //System.out.println(type);
                break;
            case 7 :
                //News
                strType = "News" ;
                //System.out.println(type);
                break;
            default:
                //Etc
                strType = "Another" ;
                //System.out.println(type);
                break;
        }

        return strType ;
    }
    public String Msg(int stp){
        String msg ;
        switch(stp) {
            case 1 :
                msg = "=============================================================\n" +
                        "                  Welcome to GL-BookStore\n" +
                        "Choose people please keydown \n" +
                        "[1] Librarian \n" +
                        "[2] Employee \n" +
                        "[3] Exit Program \n" +
                        "=============================================================" ;
                break;
            case 2 :
                msg = "Kids" ;
                break;
            case 3 :
                msg = "Economy" ;
                break;
            case 4 :
                msg = "Health" ;
                break;
            case 5 :
                msg = "Adult 18+" ;
                break;
            case 6 :
                msg = "Car" ;
                break;
            case 7 :
                msg = "News" ;
                break;
            default:
                msg = "Do you want back to main ???" ;
                break;
        }

        return msg ;
    }
    public static void LoadBookFormCargo(ArrayList<HashMap<String,String>> books){

    }

    public static void AddBooktoShelf(HashMap<String,String> book) {

        ArrayList<HashMap<String,String>> objBook = new ArrayList<HashMap<String, String>>();
        objBook.add(book);

    }




    //GentKeyBook(book.)

//
//
//
//        books = new ArrayList<HashMap<String, String>>();
//        HashMap<String, String> map;
//
//        objRandomKeys = new CreateKeysBook() ;
//
//        int roundMax = 1 ;
//        int maxType = 8 ;
//        int countBook = count ;
//        int pointCheck = 1 ;
//        maxType = countBook/maxType; //25 loop plus one value
//        //maxType = maxType+ ;
//        String strCode,strCodeHeader,strCodeTails,strBookName;
//        strCode = "" ;
//        int plusCode ;
//        for(int i = 1;i <= countBook ;i++){
//            if(pointCheck <= maxType){
//
//                if(strCode == ""){
//                    strCode = objRandomKeys.CreateKeysBook(roundMax);
//                }
//                strBookName = objRandomKeys.GenNameBooks(roundMax);
//                int lenStr = strCode.length();
//                strCodeHeader = strCode.substring(0,3);
//                strCodeTails = strCode.substring(3,lenStr);
//                strCode = strCodeHeader+(Integer.valueOf(strCodeTails)+1);
//
//                map = new HashMap<String, String>();
//                map.put("key", strCode);
//                map.put("Name",strBookName+(pointCheck));
//                map.put("type", String.valueOf(roundMax));
//                map.put("status", "Already");
//                map.put("bookBorrower","-");
//                map.put("bookDateBorrow","-");
//                map.put("bookDateReverse","-");
//                map.put("bookWriter","BIX");
//                pointCheck++ ;
//
//                books.add(map);
//                //books.set(i,map.get("key"));
////                books.set(i,map);
////                books.get(i);
////
////
////                books.set(i,map);
//
//                map.replace("status","Borrow");
//
//            }else{
//                strCode = "" ;
//                pointCheck = 1 ;
//                roundMax ++ ;
//                i = i-1 ;
//            }
//
//
//
//        }
//
//
//
//        SaveArrayTofile();
//        ReadFile();



}
