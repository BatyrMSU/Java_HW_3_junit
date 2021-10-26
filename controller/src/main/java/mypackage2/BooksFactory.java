package mypackage2;

import mypackage.Book;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface BooksFactory {

    @NotNull
    Collection<Book> books();
}
