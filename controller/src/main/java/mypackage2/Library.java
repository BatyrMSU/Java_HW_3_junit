package mypackage2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import mypackage.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public Book[] books;

    private GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private Gson gson = builder.create();

    public Library(int capacity, String path) throws Exception {
        books = new Book[capacity];

        BooksFactory booksFactory = new FileBookFactory(path);

        List<Book> fileBooks = (ArrayList<Book>) booksFactory.books();
        if (fileBooks.size() > capacity) {
            throw new Exception("size error");
        }

        for (int i = 0; i < fileBooks.size(); i++) {
            books[i] = fileBooks.get(i);
        }
    }



    public void getBook(int i) throws Exception {

        if (books[i] == null) throw new Exception("Empty cell");

        BookCellInfo info = new BookCellInfo(i, books[i]);
        String json = gson.toJson(info);
        System.out.println(json);
        books[i] = null;

    }


    public void addBook(Book book) throws Exception {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        throw new Exception("No free cells left");
    }


    public void printAllBooks() {
        for (Book book: books) {
            String json = gson.toJson(book);
            System.out.println(json);
        }
    }

    @AllArgsConstructor
    public static class BookCellInfo {
        int cell;
        Book book;
    }



}
