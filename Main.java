package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.time.LocalDateTime;
import java.util.* ;

public class Main {
    static Event event = new Event();

    public static void main(String[] args) {

        login();

    }

    public static void login() {
        System.out.println(event.Msg(1));
        Scanner myObj = new Scanner(System.in);
        String key = myObj.nextLine();
        String userLogin = "" ;
        if (key.equals("1")){
            userLogin = "Admin" ;
            Librarian librarianMan = new Librarian();
            librarianMan.librarianStart();
        }else if(key.equals("2")){
            userLogin = "Employee" ;
            Employee emp = new Employee();
            emp.employeeStart(1);
        }else if(key.equals("3")){
            System.out.println("Good bye bye bye bye bye");
        }else{
            System.out.println("You don't choose in choice please try again ???");
            login();
        }
    }

}
