package book_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int     year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    @Override
    public int compareTo(Book o) {
        return  this.getTitle().compareTo(o.getTitle()) == 0 ? this.getYear() - o.getYear() : this.getTitle().compareTo(o.getTitle());
    }

}
