package com.company;

import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainFunction {

    private static String strChangeEmp;
    private static String strChange;

    public static void searchMethod(){
        System.out.println("Research book please choice?\n" +
                "Search book all [1] , Search book by value [2] ");
        String keys = Initial.myObj.nextLine();

        switch (keys){
            //show all book ;
            case "1":
                searchALL();
                break;
            case "2":
                searchValBook();
                break;
            default:
                searchMethod () ;
                System.out.println("Try again no choice");
                break;

        }
    }

    public static void searchValBook(){

        System.out.println("Keys book please choice?\n" +
                "  BookCode =[1]         BookCategory=[2]   BookName=[3]\n" +
                "  Status Borrow =[4]    Writer=[5]         Borrower=[6]\n" +
                "  DateBorrow=[7]        DateReverse=[8]");
        String keys = Initial.myObj.nextLine();
        String query ;
        switch (keys){
            case "1":
                System.out.println("Code book start in ST and follow type \n" +
                        "01 = Sport\n" +
                        "02 = Kids\n" +
                        "03 = Economy\n" +
                        "04 = Health\n" +
                        "05 = Adult 18+\n" +
                        "06 = Car\n" +
                        "07 = News\n" +
                        "99 = Another\n");
                query = Initial.myObj.nextLine();

                searchByValue("key",query,"Admin");
                //Answer(objBook);

            case "2":
                System.out.println("BookCategory follow type keys \n" +
                        "1 = Sport\n" +
                        "2 = Kids\n" +
                        "3 = Economy\n" +
                        "4 = Health\n" +
                        "5 = Adult 18+\n" +
                        "6 = Car\n" +
                        "7 = News\n" +
                        "8 = Another\n");
                query = Initial.myObj.nextLine();

                searchByValue("type",query,"Admin");
                break;
            case "3":
                System.out.println("BookName key Namebook like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("Name",query,"Admin");

                break;
            case "4":
                System.out.println("Status Borrow follow type keys \n" +
                        "y = Already\n" +
                        "n = Borrow\n");
                query = Initial.myObj.nextLine();

                if(query.equals("y")){
                    query = "Already" ;
                }else{
                    query = "Borrow" ;
                }

                searchByValue("status",query,"Admin");

                break;
            case "5":
                System.out.println("Writer key Writer like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("bookWriter",query,"Admin");

                break;
            case "6":
                System.out.println("Borrower key NameUser like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("bookBorrower",query,"Admin");

                break;
            case "7":
                System.out.println("DateBorrow key DateBorrow like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("bookDateBorrow",query,"Admin");

                break;
            case "8":
                System.out.println("DateReverse key DateReverse like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("bookDateReverse",query,"Admin");

                break;
            default:
                searchMethod () ;
                System.out.println("Try again no choice");
                break;

        }
    }

    public static void searchByValue(String key,String strName,
                                     String chkAdmin){
        ArrayList<HashMap<String, String>> objQueryBooks = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map ;
        String typeShow = "" ;
        int countShow = 1;
        System.out.println("------------------------------------------------------");
        int inCheck = 0 ;
        for (int i = 0; i < Book.getBooks().size(); i++) {
            String queryKeys = Book.getBooks().get(i).get(key).toString();
            if(queryKeys.contains(strName)){
                map = new HashMap<String, String>();
                typeShow = Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString()));
                System.out.println("["+(countShow)+"]"+" BookCode      = " + Book.getBooks().get(i).get("key").toString());
                System.out.println("["+(countShow)+"]"+" BookCategory  = " + Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString())));
                System.out.println("["+(countShow)+"]"+" BookName      = " + Book.getBooks().get(i).get("Name").toString());
                System.out.println("["+(countShow)+"]"+" Status        = " + Book.getBooks().get(i).get("status").toString());
                System.out.println("["+(countShow)+"]"+" Writer        = " + Book.getBooks().get(i).get("bookWriter").toString());
                System.out.println("["+(countShow)+"]"+" Borrower      = " + Book.getBooks().get(i).get("bookBorrower").toString());
                System.out.println("["+(countShow)+"]"+" DateBorrow    = " + Book.getBooks().get(i).get("bookDateBorrow").toString());
                System.out.println("["+(countShow)+"]"+" DateReverse   = " + Book.getBooks().get(i).get("bookDateReverse").toString());
                System.out.println("------------------------------------------------------");
                inCheck ++ ;
                countShow ++ ;

                map.put("key", Book.getBooks().get(i).get("key").toString());
                map.put("Name",Book.getBooks().get(i).get("Name").toString());
                map.put("type", Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString())));
                map.put("status", Book.getBooks().get(i).get("status").toString());
                map.put("bookBorrower",Book.getBooks().get(i).get("bookBorrower").toString());
                map.put("bookDateBorrow",Book.getBooks().get(i).get("bookDateBorrow").toString());
                map.put("bookDateReverse",Book.getBooks().get(i).get("bookDateReverse").toString());
                map.put("bookWriter",Book.getBooks().get(i).get("bookWriter").toString());

                objQueryBooks.add(map);
            }

        }


        if(chkAdmin.equals("Admin")){
            saveQueryArray(objQueryBooks,key+" = "+typeShow);
            answer();
        }else{

            if(key.equals("type")){
                employConfirm(objQueryBooks);
            }else{
                saveQueryArray(objQueryBooks,key+" = UserID "+Employee.getEmpCode());
            }

        }


    }

    public static void searchALL(){
        //books = ReadFile();
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < Book.getBooks().size(); i++) {

            System.out.println("BookCode      = " + Book.getBooks().get(i).get("key").toString());
            System.out.println("BookCategory  = " + Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                    "type").toString())));
            System.out.println("BookName      = " + Book.getBooks().get(i).get("Name").toString());
            System.out.println("Status        = " + Book.getBooks().get(i).get("status").toString());
            System.out.println("Writer        = " + Book.getBooks().get(i).get("bookWriter").toString());
            System.out.println("Borrower      = " + Book.getBooks().get(i).get("bookBorrower").toString());
            System.out.println("DateBorrow    = " + Book.getBooks().get(i).get("bookDateBorrow").toString());
            System.out.println("DateReverse   = " + Book.getBooks().get(i).get("bookDateReverse").toString());
            System.out.println("------------------------------------------------------");

        }
        saveQueryArray(Book.getBooks(),"All books");
        answer();


    }

    private static void saveQueryArray(ArrayList<HashMap<String,String>>objBook,String typrQuery){

        File saveFile = new File(Initial.getPathFile_query());
        if(typrQuery.equals("Borrow")){
            saveFile = new File(Initial.getPathFile_borrow()+Employee.getEmpCode()+".txt");
        }else{
            saveFile = new File(Initial.getPathFile_query());
        }

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

            if(typrQuery.equals("All books")){
                BufferedWriter bufferWriter = new BufferedWriter(bookFileWrite);
                bufferWriter.write("Report Data Query type : "+typrQuery);
                bufferWriter.write("\n======================================================");
                bufferWriter.write("\nBook Count : "+objBook.size()+"\n");
                int type1 = 0,type2 = 0,type3 = 0,type4 = 0,type5 = 0,type6 = 0,type7 = 0,type8 = 0;
                for (int i = 0;i < objBook.size();i++){

                    if(objBook.get(i).get("type").toString().equals("1")){
                        type1 ++ ;
                    }else if(objBook.get(i).get("type").toString().equals("2")){
                        type2 ++ ;
                    }else if(objBook.get(i).get("type").toString().equals("3")){
                        type3 ++ ;
                    }else if(objBook.get(i).get("type").toString().equals("4")){
                        type4 ++ ;
                    }else if(objBook.get(i).get("type").toString().equals("5")){
                        type5++ ;
                    }else if(objBook.get(i).get("type").toString().equals("6")){
                        type6++ ;
                    }else if(objBook.get(i).get("type").toString().equals("7")){
                        type7++ ;
                    }else if(objBook.get(i).get("type").toString().equals("8")){
                        type8++ ;
                    }
                }
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(1)+"      |  count : "+type1+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(2)+"       |  count : "+type2+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(3)+"    |  count : "+type3+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(4)+"     |  count : "+type4+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(5)+"  |  count : "+type5+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(6)+"        |  count : "+type6+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(7)+"       |  count : "+type7+"\n");
                bufferWriter.write("Book type : "+CreateKeysBook.genTypeBooks(8)+"    |  count : "+type8+"\n");
                bufferWriter.write("------------------------------------------------------\n");

                for(int i = 0 ;i < objBook.size();i++){
                    bufferWriter.write("Book Key      : "+objBook.get(i).get("key").toString()+
                            "\nBook Name     : "+objBook.get(i).get("Name").toString()+
                            "\nBook Category : "+objBook.get(i).get("type").toString()+
                            "\nBook Status   : "+objBook.get(i).get("status").toString()+
                            "\nUser Borrow   : "+objBook.get(i).get("bookBorrower").toString()+
                            "\nBR date/start : "+objBook.get(i).get("bookDateBorrow").toString()+
                            "\nBR date/end   : "+objBook.get(i).get("bookDateReverse").toString()+
                            "\nBook Writer   : "+objBook.get(i).get("bookWriter").toString()+"\n");
                    bufferWriter.write("------------------------------------------------------\n");

                }

                //bufferWriter.write(books.toString());
                bufferWriter.close();

                //System.out.println("Company data saved at file location: " + pathFile + "\n");

                //File file = new File(pathFile_query);
                Desktop desktop = Desktop.getDesktop();

                if(saveFile.exists()) {
                    try {
                        desktop.open(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                BufferedWriter bufferWriter = new BufferedWriter(bookFileWrite);
                bufferWriter.write("Report Data Query type : "+typrQuery);
                bufferWriter.write("\n======================================================");
                bufferWriter.write("\nBook Count : "+objBook.size()+"\n");
                bufferWriter.write("------------------------------------------------------\n");

                for(int i = 0 ;i < objBook.size();i++){
                    bufferWriter.write("Book Key      : "+objBook.get(i).get("key").toString()+
                            "\nBook Name     : "+objBook.get(i).get("Name").toString()+
                            "\nBook Category : "+objBook.get(i).get("type").toString()+
                            "\nBook Status   : "+objBook.get(i).get("status").toString()+
                            "\nBook Status   : "+objBook.get(i).get("status").toString()+
                            "\nUser Borrow   : "+objBook.get(i).get("bookBorrower").toString()+
                            "\nBR date/start : "+objBook.get(i).get("bookDateBorrow").toString()+
                            "\nBR date/end   : "+objBook.get(i).get("bookDateReverse").toString()+
                            "\nBook Writer   : "+objBook.get(i).get("bookWriter").toString()+"\n");
                    bufferWriter.write("------------------------------------------------------\n");

                }

                bufferWriter.close();

            }

        } catch (IOException e) {
            System.out.println("error while saving  " + e.toString());
        }

        File file ;
        if(typrQuery.equals("Borrow")){
            file = new File(Initial.getPathFile_borrow()+Employee.getEmpCode()+".txt");
        }else{
            file = new File(Initial.getPathFile_query());
        }
        Desktop desktop = Desktop.getDesktop();

        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void answer(){
        System.out.println("Do you want to search agian ??? please y/n \n" +
                "n keydown back to login ???\n" +
                "What do you want ???");
        String answer = Initial.myObj.nextLine();
        if(answer.equals("y")){
            searchMethod();
        }else if(answer.equals("n")){
            System.out.println("Black to main /////////////////////////////");
            Main.login();
            //objMain.LoginOneAgian(books);
        }else{
            System.out.println("Try agian ???");
            answer();
        }
    }

    private static void employConfirm(ArrayList<HashMap<String,String>> objQueryBooks) {

        ArrayList<HashMap<String, String>> objConfirm = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        System.out.println("Choose number for Borrow in lengt [1..." + objQueryBooks.size() + "]\n" +
                "you can put more than 1 \n" +
                "use [,] key [1] for each book\n");
        String query = Initial.myObj.nextLine();

        if (query.equals("1")) {
            System.out.println("Please keys number Choose etc 1,2,3,4,5");
            query = Initial.myObj.nextLine();
            String strRex = "[0-9,]+";

            Boolean x = query.matches(strRex);
            strChangeEmp = query;
            if (x) {
                int n = 1;
                for (int i = 1; i < query.length(); i++) {
                    String chkChar = "";
                    char c = query.charAt(i);
                    String Char = String.valueOf(c);
                    if (Char.equals(",")) {
                        n++;
                    }

                }
                int loop = 0;
                while (loop < n) {
                    String outPutShow = checkItemBeforBorrow(strChangeEmp);
                    if (!outPutShow.equals("")) {
                        System.out.println("list : [" + (loop + 1) + "] " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("key"));
                        System.out.println("Name       " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get(
                                "Name"));
                        System.out.println("Status     " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get(
                                "status"));
                        System.out.println("============================================");
                        //System.out.println("")


                        map = new HashMap<String, String>();
                        map.put("key", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("key"));
                        map.put("Name", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("Name"));
                        map.put("type", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("type"));
                        map.put("status", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("status"));
                        map.put("bookBorrower", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookBorrower"));
                        map.put("bookDateBorrow", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookDateBorrow"));
                        map.put("bookDateReverse", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookDateReverse"));
                        map.put("bookWriter", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookWriter"));

                        objConfirm.add(map);


                    }
                    loop++;
                }
                chooseConfirm(objConfirm);
            } else {
                System.out.println("Try agian is wrong !!!");

            }

        } else {
            employConfirm(objQueryBooks);
        }
    }

        public static void chooseConfirm(ArrayList<HashMap<String,String>> objConfirm){
            System.out.println("Do you want to confirm to borrow or choose agian ?\n" +
                    "[1] Confirm\n" +
                    "[2] ChooseNew\n" +
                    "[3] BackMain");

            String keys = Initial.myObj.nextLine();

            switch (keys){
                case "1":
                    /// query update
//
                    for(int i = 0; i < objConfirm.size();i++){
                        //System.out.println(objConfirm.get(i));
                        int index = Initial.getIndexBooks(Book.getBooks(),objConfirm.get(i).get("key"));

                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        Date dateplus = new Date();
                        Calendar c = Calendar.getInstance();
                        c.setTime(dateplus);
                        c.add(Calendar.DATE, 7);
                        dateplus = c.getTime();

                        String dateChange = dateFormat.format(date) ;
                        String Strdateplus = dateFormat.format(dateplus) ;

                        Book.getBooks().get(index).replace("status","Borrow");
                        Book.getBooks().get(index).replace("bookDateReverse",Strdateplus);
                        Book.getBooks().get(index).replace("bookDateBorrow",dateChange);
                        Book.getBooks().get(index).replace("bookBorrower",Employee.getEmpCode());
                    }
                    Initial.saveArrayTofile();
                    Employee.employeeStart(2);
                    //SaveQueryArray(objConfirm,"Borrow");
                    //Main.Login();
                    break;
                case "2":
                    /// ChooseConfirm
                    //BorrowBooks();
                    break;
                case "3":
                    break;

            }
        }


    public static String checkItemBeforBorrow(String str){
        int lenStr = str.length();
        String chkChar ="" ;
        String Char ="" ;
        for(int i = 0 ; i < lenStr ;i ++){
            char c = str.charAt(i);
            Char = String.valueOf(c);

            if (Char.equals(",")){
                chkChar = chkChar.substring(0,i);
                strChangeEmp = str.substring(i+1,lenStr);

                return chkChar ;

            }else{
                chkChar += String.valueOf(c) ;
            }
        }

        return chkChar ;
    }

    public static void borrowBooks(){
        System.out.println("Do you want a [type book] or [name book] for search ?");

        System.out.println("Please keydown \n" +
                "Show type [1] , Search Name book [2]");
        String keys = Initial.myObj.nextLine();
        String query ;
        switch (keys){
            case "1":
                System.out.println("BookCategory follow type keys \n" +
                        "1 = Sport\n" +
                        "2 = Kids\n" +
                        "3 = Economy\n" +
                        "4 = Health\n" +
                        "5 = Adult 18+\n" +
                        "6 = Car\n" +
                        "7 = News\n" +
                        "8 = Another\n");
                query = Initial.myObj.nextLine();

                searchByValue("type",query,"emp");
                break;
            case "2":
                System.out.println("BookName key Namebook like command SQL");
                query = Initial.myObj.nextLine();

                searchByValue("Name",query,"emp");
                break;
            default:
                borrowBooks();
                break;
        }
    }
    public static ArrayList<HashMap<String,String>> readFile() {
        ArrayList<HashMap<String,String>> bookRead = new ArrayList<HashMap<String,String>>();
        File bookFile = new File(Initial.getPathFile());
        if (!bookFile.exists())
            System.out.println("File doesn't exist");

        InputStreamReader isReader;
        try {

            FileInputStream fis = new FileInputStream(Initial.getPathFile());
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
        //System.out.println("\nComapny Data loaded successfully from file " + pathFile);

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

    public static void reversBook(String key,String strName,
                                     String chkAdmin){
        ArrayList<HashMap<String, String>> objQueryBooks = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map ;
        String typeShow = "" ;
        int countShow = 1;
        System.out.println("------------------------------------------------------");
        int inCheck = 0 ;
        for (int i = 0; i < Book.getBooks().size(); i++) {
            String queryKeys = Book.getBooks().get(i).get(key).toString();
            if(queryKeys.contains(strName)){
                map = new HashMap<String, String>();
                typeShow = Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString()));
                System.out.println("["+(countShow)+"]"+" BookCode      = " + Book.getBooks().get(i).get("key").toString());
                System.out.println("["+(countShow)+"]"+" BookCategory  = " + Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString())));
                System.out.println("["+(countShow)+"]"+" BookName      = " + Book.getBooks().get(i).get("Name").toString());
                System.out.println("["+(countShow)+"]"+" Status        = " + Book.getBooks().get(i).get("status").toString());
                System.out.println("["+(countShow)+"]"+" Writer        = " + Book.getBooks().get(i).get("bookWriter").toString());
                System.out.println("["+(countShow)+"]"+" Borrower      = " + Book.getBooks().get(i).get("bookBorrower").toString());
                System.out.println("["+(countShow)+"]"+" DateBorrow    = " + Book.getBooks().get(i).get("bookDateBorrow").toString());
                System.out.println("["+(countShow)+"]"+" DateReverse   = " + Book.getBooks().get(i).get("bookDateReverse").toString());
                System.out.println("------------------------------------------------------");
                inCheck ++ ;
                countShow ++ ;

                map.put("key", Book.getBooks().get(i).get("key").toString());
                map.put("Name",Book.getBooks().get(i).get("Name").toString());
                map.put("type", Initial.GentType(Integer.valueOf(Book.getBooks().get(i).get(
                        "type").toString())));
                map.put("status", Book.getBooks().get(i).get("status").toString());
                map.put("bookBorrower",Book.getBooks().get(i).get("bookBorrower").toString());
                map.put("bookDateBorrow",Book.getBooks().get(i).get("bookDateBorrow").toString());
                map.put("bookDateReverse",Book.getBooks().get(i).get("bookDateReverse").toString());
                map.put("bookWriter",Book.getBooks().get(i).get("bookWriter").toString());

                objQueryBooks.add(map);
            }

        }

            employReversConfirm(objQueryBooks);


    }

    private static void employReversConfirm(ArrayList<HashMap<String,String>> objQueryBooks) {

        ArrayList<HashMap<String, String>> objConfirm = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        System.out.println("Choose number for Revers in lengt [1..." + objQueryBooks.size() + "]\n" +
                "you can put more than 1 \n" +
                "revers [,] key [1] for each book\n" +
                "revers All key [2] for a book\n");
        String query = Initial.myObj.nextLine();

        if (query.equals("1")) {
            System.out.println("Please keys number Choose etc 1,2,3,4,5");
            query = Initial.myObj.nextLine();
            String strRex = "[0-9,]+";

            Boolean x = query.matches(strRex);
            strChangeEmp = query;
            if (x) {
                int n = 1;
                for (int i = 1; i < query.length(); i++) {
                    String chkChar = "";
                    char c = query.charAt(i);
                    String Char = String.valueOf(c);
                    if (Char.equals(",")) {
                        n++;
                    }

                }
                int loop = 0;
                while (loop < n) {
                    String outPutShow = checkItemBeforBorrow(strChangeEmp);
                    if (!outPutShow.equals("")) {
                        System.out.println("list : [" + (loop + 1) + "] " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("key"));
                        System.out.println("Name       " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get(
                                "Name"));
                        System.out.println("Status     " + objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get(
                                "status"));
                        System.out.println("============================================");
                        //System.out.println("")


                        map = new HashMap<String, String>();
                        map.put("key", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("key"));
                        map.put("Name", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("Name"));
                        map.put("type", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("type"));
                        map.put("status", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("status"));
                        map.put("bookBorrower", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookBorrower"));
                        map.put("bookDateBorrow", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookDateBorrow"));
                        map.put("bookDateReverse", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookDateReverse"));
                        map.put("bookWriter", objQueryBooks.get(Integer.valueOf(outPutShow) - 1).get("bookWriter"));

                        objConfirm.add(map);


                    }
                    loop++;
                }
                chooseConfirmRevers(objConfirm);
            } else {
                System.out.println("Try agian is wrong !!!");

            }

        } else if (query.equals("2")) {
            int loop = 0;
            while (loop < objQueryBooks.size()) {

                    System.out.println("list : [" + (loop + 1) + "] " + objQueryBooks.get(Integer.valueOf(loop)).get(
                            "key"));
                    System.out.println("Name       " + objQueryBooks.get(Integer.valueOf(loop)).get(
                            "Name"));
                    System.out.println("Status     " + objQueryBooks.get(Integer.valueOf(loop)).get(
                            "status"));
                    System.out.println("============================================");
                    //System.out.println("")


                    map = new HashMap<String, String>();
                    map.put("key", objQueryBooks.get(Integer.valueOf(loop)).get("key"));
                    map.put("Name", objQueryBooks.get(Integer.valueOf(loop)).get("Name"));
                    map.put("type", objQueryBooks.get(Integer.valueOf(loop)).get("type"));
                    map.put("status", objQueryBooks.get(Integer.valueOf(loop)).get("status"));
                    map.put("bookBorrower", objQueryBooks.get(Integer.valueOf(loop)).get("bookBorrower"));
                    map.put("bookDateBorrow", objQueryBooks.get(Integer.valueOf(loop)).get("bookDateBorrow"));
                    map.put("bookDateReverse", objQueryBooks.get(Integer.valueOf(loop)).get("bookDateReverse"));
                    map.put("bookWriter", objQueryBooks.get(Integer.valueOf(loop)).get("bookWriter"));

                    objConfirm.add(map);

                    loop++;
            }
            chooseConfirmRevers(objConfirm);
        } else {
            employConfirm(objQueryBooks);
        }
    }

    public static void chooseConfirmRevers(ArrayList<HashMap<String,String>> objConfirm){
        System.out.println("Do you want to confirm to Reverse or choose agian ?\n" +
                "[1] Confirm\n" +
                "[2] ChooseNew\n" +
                "[3] BackMain");

        String keys = Initial.myObj.nextLine();

        switch (keys){
            case "1":
                /// query update
//
                for(int i = 0; i < objConfirm.size();i++){
                    //System.out.println(objConfirm.get(i));
                    int index = Initial.getIndexBooks(Book.getBooks(),objConfirm.get(i).get("key"));

                    Book.getBooks().get(index).replace("status","Already");
                    Book.getBooks().get(index).replace("bookDateReverse","-");
                    Book.getBooks().get(index).replace("bookDateBorrow","-");
                    Book.getBooks().get(index).replace("bookBorrower","-");
                }
                Initial.saveArrayTofile();
                Employee.employeeStart(2);
                break;
            case "2":
                /// ChooseConfirm
                //BorrowBooks();
                break;
            case "3":
                break;

        }
    }


    public static String getStrChangeEmp() {
        return strChangeEmp;
    }


}

