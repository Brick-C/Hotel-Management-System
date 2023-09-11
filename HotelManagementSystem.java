// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class FoodItem implements Serializable {
    int items;
    int quantity;
    float price;

    FoodItem(int items, int quantity) { 
        this.items = items;
        this.quantity = quantity;
        switch (items) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;

                break;
            case 5:
                price = quantity * 15;
                break;

                case 6:
                price = quantity *290;
            
            
        }
    }
}

class Singleroom implements Serializable {
    String name;
    String contact;
    String gender;
    ArrayList<FoodItem> food = new ArrayList<>(); // interface

    Singleroom() {
        this.name = "";
    }

    Singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

class Doubleroom extends Singleroom{
    String name2;
    String contact2; 
    String gender2;

    Doubleroom() {
        this.name = "";
        this.name2 = "";
    }

    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

class NotAvailable extends Exception {
    public String toString() {
        return "Not Available !";                 
    }
}

class customer {
    Doubleroom luxury_doublerrom[] = new Doubleroom[10]; 
    Doubleroom deluxe_doublerrom[] = new Doubleroom[20]; 
    Singleroom luxury_singleerrom[] = new Singleroom[10]; 
    Singleroom deluxe_singleerrom[] = new Singleroom[20]; 
}

public class HotelManagementSystem extends Hotel{
    public static void main(String[] args) {

    
            Scanner sc = new Scanner(System.in);
            
            Hotel Hotel = new Hotel();
            WelcomeMessage wm = new WelcomeMessage();
            GoodByeMessage gm = new GoodByeMessage();

            int ch, ch2;
            char yes;
            x: do {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd    HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));
                
                wm.welcomeMessage();

                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Super Deluxe Double Room \n3.Luxury Single Room \n4.Super Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Super Deluxe Double Room \n3.Luxury Single Room\n4.Super Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Super Deluxe Double Room \n3.Luxury Single Room\n4.Super Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number: ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("This Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.order(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.order(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.order(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.order(ch2 - 1, 1);
                        else
                            System.out.println("This Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number: ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("The Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.deallocate(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.deallocate(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.deallocate(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.deallocate(ch2 - 1, 1);
                        else
                            System.out.println("The Room doesn't exist");
                        break;
                    case 6:
                        gm.showGoodByeMessage();
                        break x;

                }

                System.out.println("\nDo you want to continue ? IF Continue press (y) else doesn't continue press (n)");
                yes = sc.next().charAt(0);
                if (!(yes == 'y' || yes == 'Y' || yes== 'n' || yes == 'N')) {
                    System.out.println("Invalid Option");
                    System.out.println(
                            "\nDo you want to continue ? IF Continue press (y) else doesn't continue press (n)");
                    yes = sc.next().charAt(0);
                }

            } while (yes == 'y' || yes== 'Y');

            sc.close();
    }
}