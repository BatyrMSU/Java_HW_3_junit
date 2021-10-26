package mypackage3;

import mypackage.Author;
import mypackage.Book;
import mypackage2.BooksFactory;
import mypackage2.FileBookFactory;
import mypackage2.Library;
import mypackage2.LibraryFactory;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class MainTest {

    @NotNull
    private final Library myLibrary = new LibraryFactory().createLibrary(150, "books.txt");
    @NotNull
    private final BooksFactory booksFactory = new FileBookFactory("books.txt");


    public MainTest() throws Exception {
    }

    @Test(expected = Exception.class) // size error
    public void testLackOfCapacity() throws Exception {
        Library library = new LibraryFactory().createLibrary(90, "books.txt");
    }


    @Test
    public void testMatchingOrderOfBooks() throws Exception {
        // taking books from file
        BooksFactory booksFactory = new FileBookFactory("books.txt");
        List<Book> fileBooks = (ArrayList<Book>) booksFactory.books();

        // taking books from library
        Library library = new LibraryFactory().createLibrary(200, "books.txt");
        Book[] libraryBooks = library.books;

        // Comparing books
        for (int i = 0; i < libraryBooks.length; i++) {
            if (i < fileBooks.size()) {
                assertEquals(libraryBooks[i].name, fileBooks.get(i).name);
                assertEquals(libraryBooks[i].author.name, fileBooks.get(i).author.name);
            }
            else { // if the library capacity greater than number of books in file
                assertNull(libraryBooks[i]);
            }
        }
    }

    @Test(expected = Exception.class)
    public void testGetBookFromEmptyCell() throws Exception {
        myLibrary.getBook(122);
    }


    @Test
    public void testAddedBookInFirstEmptyCell() throws Exception {
        assertNull(myLibrary.books[100]);

        Book newBook = new Book("TESTBOOK", new Author("Jack"));
        myLibrary.addBook(newBook);

        assertNotNull(myLibrary.books[100]);
    }


    @Test(expected = Exception.class)
    public void testNoFreeCell() throws Exception {
        Library library = new LibraryFactory().createLibrary(100, "books.txt");
        Book newBook = new Book("TESTBOOK", new Author("Jack"));
        library.addBook(newBook);

    }


}
