package week8_assignment;

public class Order {
    FurnitureTypes furniture;

    String orderID;

    String customer;
    double price;
    double width;
    double height;

    public Order(FurnitureTypes furniture, String orderID, String customer, double price, double width, double height){
        this.furniture = furniture;
        this.orderID = orderID;
        this.customer = customer;
        this.price = price;
        this.width = width;
        this.height = height;
    }
}
