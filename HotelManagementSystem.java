import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


class Singleroom{
    String name;
    String contact;
    String gender;
    ArrayList<FoodItem> food = new ArrayList<>();

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


public class HotelManagementSystem extends Hotel{
    public static void main(String[] args) {

    
            Scanner sc = new Scanner(System.in);

            Hotel Hotel = new Hotel();
            WelcomeMessage wm = new WelcomeMessage();
            Menu m = new Menu();
            GoodByeMessage gm = new GoodByeMessage();

            int ch, ch2;
            char yes;
            do {
                
                wm.welcomeMessage();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("\tyyyy/MM/dd    \tHH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));

                m.showMenuOptions();

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
                        System.out.print("\tRoom Number: ");
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
                        System.out.print("\tRoom Number: ");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("This Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.checkout(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.checkout(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.checkout(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.checkout(ch2 - 1, 1);
                        else
                            System.out.println("This Room doesn't exist");
                        break;
                    case 6:
                        gm.showGoodByeMessage();
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;

                }

                System.out.println("\nDo you want to continue ? IF Continue press (y); else press (n)");
                yes = sc.next().charAt(0);
                if (!(yes == 'y' || yes == 'Y' || yes== 'n' || yes == 'N')) {
                    System.out.println("Invalid Input");
                    System.out.println(
                            "\nDo you want to continue ? IF Continue press (y); else press (n)");
                    yes = sc.next().charAt(0);
                }
                else if (yes == 'n' || yes == 'N') {
                    gm.showGoodByeMessage();
                }

            } while (yes == 'y' || yes== 'Y');

            sc.close();
    }
}