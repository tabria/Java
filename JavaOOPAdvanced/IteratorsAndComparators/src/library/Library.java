package library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book>{
        private int index;

        public LibraryIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return books.length < this.index;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }
}
