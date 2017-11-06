package book_shop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);

    }

//    @Override
//    protected void setPrice(double price) {
//        price += price*0.3;
//        super.setPrice(price);
//    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice()*0.30;
    }
}
