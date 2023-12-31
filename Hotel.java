import java.util.*;

class Customer {
    Doubleroom luxury_doubleroom[] = new Doubleroom[10]; 
    Doubleroom deluxe_doubleroom[] = new Doubleroom[20]; 
    Singleroom luxury_singleroom[] = new Singleroom[10]; 
    Singleroom deluxe_singleroom[] = new Singleroom[20]; 
}

public class Hotel {
     Customer  hotel_ob = new Customer();
     Scanner sc = new Scanner(System.in);

    public void GuestDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";

        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact = sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();

        if (i < 3) {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2 = sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:
                hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("You choose Wrong option!!");
                break;
        }
    }

    public void bookroom(int i) {
        int j;
        int rn;
        System.out.println("\nChoose Room Number from The Given Room Here : ");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null) {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.println("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.luxury_doubleroom[rn] != null)
                        throw new NotAvailable();
                    GuestDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null) {
                        System.out.print(j + 11 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doubleroom[rn] != null)
                        throw new NotAvailable();
                    GuestDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null) {
                        System.out.print(j + 31 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 31;
                    if (hotel_ob.luxury_singleroom[rn] != null)
                        throw new NotAvailable();
                    GuestDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null) {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (hotel_ob.deluxe_singleroom[rn] != null)
                        throw new NotAvailable();
                    GuestDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("\nRoom Booked!!");
    }

    public void features(int i) {
        switch (i) {
            case 1:
                System.out.println("\nNumber of double beds : 1\nAC : Yes\nFree breakfast : Yes\nFree Wifi : Yes\nCharge per night BDT:6999 ");
                break;
            case 2:
                System.out.println("\nNumber of double beds : 1\nAC : Yes\nFree breakfast : Yes\nFree Wifi : No\nCharge per night BDT:6549  ");
                break;
            case 3:
                System.out.println("\nNumber of single beds : 1\nAC : Yes\nFree breakfast : Yes\nFree Wifi : No\nCharge per night BDT:5999  ");
                break;
            case 4:
                System.out.println("\nNumber of single beds : 1\nAC : Yes\nFree breakfast : Yes\nFree Wifi : No\nCharge per night BDT:5549 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    public void availability(int i) {
        int j, count = 0;
        switch (i) {
            case 1:
                for (j = 0; j < 10; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null)
                        count++;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null)
                        count++;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleroom.length; j++) {
                    if (hotel_ob.luxury_singleroom[j] == null)
                        count++;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleroom.length; j++) {
                    if (hotel_ob.deluxe_singleroom[j] == null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : " + count);
    }

    public void bill(int rn, int rtype) {
        double amount = 0;
        String list[] = { "Sandwich", "Pasta", "Noodles", "Coke", "water", "Khichuri" };
        System.out.println("\t************");
        System.out.println(" \t-:INVOICE:-");
        System.out.println("\t************");

        switch (rtype) {
            case 1:
                
                System.out.println("\t\t  Room Charge BDT- " + 6999);
                System.out.println("........................................");
                System.out.println("        Food cost BDT-                  ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("      Item       Quantity       Price     ");
                System.out.println("----------------------------------------");
                for (FoodItem obb : hotel_ob.luxury_doubleroom[rn].food) {
                    amount += obb.price + 6999;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.items - 1], obb.quantity, obb.price);
                }

                break;
            case 2:
                
                System.out.println("\t\tRoom Charge BDT -" + 6549);
                System.out.println("........................................");
                System.out.println("        Food cost BDT-                   ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("      Item       Quantity       Price");
                System.out.println("----------------------------------------");
                for (FoodItem obb : hotel_ob.deluxe_doubleroom[rn].food) {
                    amount += obb.price + 6549;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.items - 1], obb.quantity, obb.price);
                }
                break;
            case 3:
               
                System.out.println("\t\tRoom Charge BDT -" + 5999);
                System.out.println("........................................");
                System.out.println("        Food cost BDT- "                  );
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("      Item       Quantity       Price");
                System.out.println("----------------------------------------");
                for (FoodItem obb : hotel_ob.luxury_singleroom[rn].food) {
                    amount += obb.price + 5999;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.items - 1], obb.quantity, obb.price);
                }
                break;
            case 4:
                
                System.out.println("Room Charge - BDT-" + 5549);
                System.out.println(".......................................");
                System.out.println("        Food cost BDT- "                );
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("      Item       Quantity       Price");
                System.out.println("----------------------------------------");
                for (FoodItem obb : hotel_ob.deluxe_singleroom[rn].food) {
                    amount += obb.price + 5549;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.items - 1], obb.quantity, obb.price);
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- " + amount);
    }

    public void checkout(int rn, int rtype) {
        
        char w;
        switch (rtype) {
            case 1:
                if (hotel_ob.luxury_doubleroom[rn] != null)
                    System.out.println("\tRoom used by " + hotel_ob.luxury_doubleroom[rn].name + " and " + hotel_ob.luxury_doubleroom[rn].name2);
                else {
                    System.out.println("\tEmpty Already");
                    return;
                }
                System.out.println("Do You Want to Checkout From Our Hotel ? if Yes, press (y) else press(n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_doubleroom[rn] = null;
                    System.out.println("--Checkout succesfull--");
                }

                break;
            case 2:
                if (hotel_ob.deluxe_doubleroom[rn] != null)
                    System.out.println("\tRoom used by " + hotel_ob.deluxe_doubleroom[rn].name + " and " + hotel_ob.deluxe_doubleroom[rn].name2);
                else {
                    System.out.println("\tEmpty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_doubleroom[rn] = null;
                    System.out.println("--Checkout succesfull--");
                }

                break;
            case 3:
                if (hotel_ob.luxury_singleroom[rn] != null)
                    System.out.println("\tRoom used by " + hotel_ob.luxury_singleroom[rn].name);
                else {
                    System.out.println("\tEmpty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_singleroom[rn] = null;
                    System.out.println("--Checkout succesfully--");
                }

                break;
            case 4:
                if (hotel_ob.deluxe_singleroom[rn] != null)
                    System.out.println("\tRoom used by " + hotel_ob.deluxe_singleroom[rn].name);
                else {
                    System.out.println("\tEmpty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_singleroom[rn] = null;
                    System.out.println("--Checkout succesfully--");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    public void order(int rn, int rtype) {
        int i, q;
        char yes;
        try {
            System.out.println("\n ===========================\n \t:Our Menu:  \n ===========================\n");
            System.out.println(" Item\t\t  Price");
            System.out.println("-------\t-----\t---------");
            System.out.println("1.Sandwich\tBDT: 155");
            System.out.println("2.Pasta(oven)\tBDT: 260");
            System.out.println("3.Noodles\tBDT: 70");
            System.out.println("4.Coke(250ml)\tBDT: 25");
            System.out.println("5.Water(250ml)\tBDT: 15");
            System.out.println("6.Khichuri\tBDT:200");

            do {
                System.out.print("\nEnter item number: ");
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q = sc.nextInt();

                switch (rtype) {
                    case 1:
                        hotel_ob.luxury_doubleroom[rn].food.add(new FoodItem(i, q));
                        break;
                    case 2:
                        hotel_ob.deluxe_doubleroom[rn].food.add(new FoodItem(i, q));
                        break;
                    case 3:
                        hotel_ob.luxury_singleroom[rn].food.add(new FoodItem(i, q));
                        break;
                    case 4:
                        hotel_ob.deluxe_singleroom[rn].food.add(new FoodItem(i, q));
                        break;

                }
                System.out.println("Do you want to order more ? (y/n)");
                yes = sc.next().charAt(0);
            } while (yes == 'y' || yes == 'Y');
        } catch (NullPointerException e) {
            System.out.println("\nRoom not booked");
        } catch (Exception e) {
            System.out.println("Cannot be done");
        }
    }
}

