package seminar1.theBook;

import java.util.Arrays;

public class BookStack {

    private Book[] books;
    private int size;

    public BookStack(int initialCapacity) {
        books = new Book[initialCapacity];
        size = 0;
    }

    public void push(Book book) {
        if(size == books.length){
            this.books = Arrays.copyOf(books, books.length * 2);
        }
        this.books[size] = book;
        size++;
    }

    public Book pop() {
        if(size == 0) {
            return null;
        }

        Book result = books[size - 1];
        books[size - 1] = null;
        size--;
        return result;

    }

    private void resize() {
        Arrays.copyOf(books, books.length * 2);
    }


    public void searchByPrice(double minPrice) {

        boolean noMatches = true;

        for(int i = 0; i < size; i++) {
            if(books[i].price >= minPrice){
                System.out.println(books[i].title);
                noMatches = false;
            }
        }

        if(noMatches){
            System.out.println("No matches found!");
        }
    }

    public void printStackInformation() {
        if(size == 0){
            System.out.println("No books in the stack");
        }
        else {
            System.out.println("Size - " + size);
            System.out.println("Capacity - " + (books.length - size));
            for (Book book : books) {
                if(book == null){
                    break;
                }
                System.out.println(book.title + " by " + book.author + " - " + book.price);
            }
        }
    }
}
