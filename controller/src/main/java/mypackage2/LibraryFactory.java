package mypackage2;

import javax.inject.Inject;

public class LibraryFactory {

    public Library createLibrary(int capacity, String path) throws Exception {
        return new Library(capacity, path);
    }

}
