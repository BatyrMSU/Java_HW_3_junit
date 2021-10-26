package mypackage2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(@NotNull String[] args) throws Exception {

        final Injector injector = Guice.createInjector(new Module());
        injector.getInstance(LibraryFactory.class).createLibrary(Integer.parseInt(args[0]), args[1]);
    }

}
