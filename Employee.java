package com.company;

import java.util.Scanner;

public class Employee extends MainFunction {

    private static Scanner myObj = new Scanner(System.in);
    private static String empCode ;
    public static void employeeStart(int stepCheck){
        String eid = "" ;
        if(stepCheck == 1){
            System.out.println("Please keydown Employee code this ???");
            eid = myObj.nextLine();
            System.out.println("Hey Employee :"+eid+"\nYou want to ???\n" +
                    "[1] Show on Hand keydown\n" +
                    "[2] Borrow book keydown \n" +
                    "[3] Reverse book keydown \n" +
                    "[4] Back to main");
            String keyStep = myObj.nextLine();
            empCode = eid ;
            switch (keyStep){
                case ("1"):

                    searchByValue("bookBorrower",eid,"emp");
                    employeeStart(2);
                    break;
                case("2"):

                    borrowBooks();

                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    break;
                case("3"):
                    reversBook("bookBorrower",eid,"emp");
                    //String bookCount = "";
                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    break;
                case("4"):
                    //SearchByValue("bookBorrower",eid,"emp");
                    //String bookCount = "";
                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    Main.login();
                    break;
                default:
                    employeeStart(2);
                    break;
            }
        }else{
            System.out.println("Hey Employee :"+getEmpCode()+"\nYou want to ???\n" +
                    "[1] Show on Hand keydown\n" +
                    "[2] Borrow book keydown \n" +
                    "[3] Reverse book keydown \n" +
                    "[4] Back to main");
            String keyStep = myObj.nextLine();

            switch (keyStep){
                case ("1"):

                    searchByValue("bookBorrower",getEmpCode(),"emp");
                    //EmployeeStart();
                    employeeStart(2);
                    break;
                case("2"):

                    borrowBooks();

                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    break;
                case("3"):
                    reversBook("bookBorrower",getEmpCode(),"emp");
                    //String bookCount = "";
                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    break;
                case("4"):
                    //String bookCount = "";
                    //objTemp = objBook.ReadFile();
                    //bookCount = String.valueOf(objTemp.size());
                    Main.login();
                    break;
                default:
                    employeeStart(2);
                    break;
            }
        }


    }


    public static String getEmpCode() {
        return empCode;
    }

    public static void setEmpCode(String empCode) {
        Employee.empCode = empCode;
    }
}
