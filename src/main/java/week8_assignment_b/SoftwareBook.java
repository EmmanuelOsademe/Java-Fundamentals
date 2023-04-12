package week8_assignment_b;

public class SoftwareBook extends Book implements BookDetails {
    String softwareVersion;
    String softwareName;

    public SoftwareBook(String authorName, String bookTitle, double bookPrice, int stock, int numberOfPages, String softwareName, String softwareVersion){
        super(authorName, bookTitle, bookPrice, stock, numberOfPages);
        this.softwareVersion = softwareVersion;
        this.softwareName = softwareName;
    }

    public SoftwareBook(){};

    public SoftwareBook acceptBookDetails(){
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

        System.out.print("Enter software version: ");
        String softwareVersion = sc.next();

        System.out.print("Enter software name: ");
        String softwareName = sc.next();

        SoftwareBook newBook = new SoftwareBook(authorName, bookTitle, bookPrice, stock, numberOfPages, softwareName, softwareVersion);
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
        System.out.printf("Software name: %s \n", this.softwareName);
        System.out.printf("Software version: %s \n", this.softwareVersion);
    }

}
