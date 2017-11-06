package book_shop;

public class Book {

    private String title;
    private String author;
    private double price;

    public Book(String author, String title,  double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] authorNames = author.split("\\s+");
        if (authorNames.length == 2 && Character.isDigit(authorNames[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price <1){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ")
                .append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ")
                .append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ")
                .append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ")
                .append(this.getPrice())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
