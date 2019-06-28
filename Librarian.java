package com.company;

public class Librarian extends MainFunction {

    private void createAutoBooks(int countBook){
        Book Book = new Book(countBook);
    }
    public void librarianStart(){
        System.out.println("Hey Librarian \nYou want to Create book or Research book ?\n" +
                "[1] Search book keydown     \n" +
                "[2] Create Autobook keydown      \n" +
                "[3] BackMenu keydown  \n");
        String keyStep = Initial.myObj.nextLine();
        switch (keyStep){
            case ("1"):
                String bookCount = "";
                bookCount = String.valueOf(Book.getBooks().size());
                if(bookCount.equals("0")){
                    System.out.println("Book Count : 0 Please input Books ");
                    librarianStart();
                }else searchMethod();
                break;
            case("2"):
                System.out.println("Hey Librarian \nYou please count of book for create store");
                int counts = Integer.valueOf(Initial.myObj.nextLine());
                createAutoBooks(counts);
                System.out.println("Create success");
                librarianStart();

                break;
            case("3"):
                Main.login();
                break;
            default:
                librarianStart();
                break;
        }
    }

}

