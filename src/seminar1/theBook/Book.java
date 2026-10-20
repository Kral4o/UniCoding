package seminar1.theBook;

public class Book {

    String title;
    String author;
    double price;

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String bookTitle, String bookAuthor, double bookPrice){
        title = bookTitle;
        author = bookAuthor;
        price = bookPrice;
    }
}
