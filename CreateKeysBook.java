package com.company;

import java.util.Random;

public class CreateKeysBook {

    public String createKeysBook(int type){
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

    public String genNameBooks(int type){
        String strName ;
        switch(type) {
            case 1 :
                //Sport
                strName = "Sport book : " ;
                //System.out.println(type);
                break;
            case 2 :
                //Kids
                strName = "Kids book : " ;
                //System.out.println(type);
                break;
            case 3 :
                //Economy
                strName = "Economy book : " ;
                //System.out.println(type);
                break;
            case 4 :
                //Health
                strName = "Health book : " ;
                //System.out.println(type);
                break;
            case 5 :
                //Adult
                strName = "Adult book : " ;
                //System.out.println(type);
                break;
            case 6 :
                //Car
                strName = "Car book : " ;
                //System.out.println(type);
                break;
            case 7 :
                //News
                strName = "News book : " ;
                //System.out.println(type);
                break;
            default:
                //Etc
                strName = "Another book : " ;
                //System.out.println(type);
                break;
        }

        return strName ;

    }

    public static String genTypeBooks(int type){
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










}
