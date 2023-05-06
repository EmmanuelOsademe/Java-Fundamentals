package week10_assignment.books;

public class Book {
    String bookName;
    String authorName;
    Double price;

    public Book(String bookName, String authorName, Double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
