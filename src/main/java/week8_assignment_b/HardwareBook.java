package week8_assignment_b;

public class HardwareBook extends Book implements BookDetails{
    String hardwareCategory;
    String publisher;

    public HardwareBook(String authorName, String bookTitle, double bookPrice, int stock, int numberOfPages, String hardwareCategory, String publisher){
        super(authorName, bookTitle, bookPrice, stock, numberOfPages);
        this.hardwareCategory = hardwareCategory;
        this.publisher = publisher;
    }

    public HardwareBook(){};

    public HardwareBook acceptBookDetails(){
        System.out.print("Enter author's name: ");
        String authorName = sc.next();

        System.out.print("Enter book title: ");
        String bookTitle = sc.next();

        System.out.print("Enter book price: ");
        String priceReceived = sc.next();
        double bookPrice = validateDouble(priceReceived);

        System.out.print("Enter current book stock: ");
        int stock = validateInt(sc.next());

        System.out.print("Enter number of pages: ");
        int numberOfPages = validateInt(sc.next());

        System.out.print("Enter book category: ");
        String hardwareCategory = sc.next();

        System.out.print("Enter book publisher: ");
        String publisher = sc.next();

        HardwareBook newBook = new HardwareBook(authorName, bookTitle, bookPrice, stock, numberOfPages, hardwareCategory, publisher);
        System.out.println("Book details saved.");
        newBook.displayBookDetails();
        return newBook;
    }

    public void displayBookDetails(){
        System.out.printf("Book author: %s \n", this.authorName);
        System.out.printf("Book title: %s \n", this.bookTitle);
        System.out.printf("Book price: %6.2f \n", this.bookPrice);
        System.out.printf("Current stock: %s \n", this.stock);
        System.out.printf("Number of pages: %s, \n", this.numberOfPages);
        System.out.printf("Hardware category: %s \n", this.hardwareCategory);
        System.out.printf("Publisher: %s \n", this.publisher);
    }
}
