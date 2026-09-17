import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        // Putting the scanner inside try (...) satisfies VS Code's suggestion
        try (Scanner scanner = new Scanner(System.in)) {

            int grandTotalQuantity = 0;
            double grandTotalBeforeDiscount = 0.0;
            double grandTotalDiscount = 0.0;
            double grandFinalAmount = 0.0;

            char orderAgain = 'Y';
            // MAIN MENU LOOP >:p
            while (orderAgain == 'Y' || orderAgain == 'y') {
                System.out.println("===== CANTEEN MENU =====");
                System.out.println("1. Pepperoni Pizza         - Php 33.00");
                System.out.println("2. TenderJuicy Hotdog      - Php 35.00");
                System.out.println("3. Shawarma                - Php 65.00");
                System.out.println("4. Pancit Canton           - Php 30.00");
                System.out.println("5. Fruit Juice             - Php 20.00");
                System.out.println("========================");

                System.out.print("Enter item number: ");
                int itemNumber = scanner.nextInt();

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                // Amount mainterer kineme 
                if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
                    System.out.println("Invalid order! Please enter a valid item (1-5) and quantity (1-10).\n");
                    
                    System.out.print("Do you want to order again? (Y/N): ");
                    orderAgain = scanner.next().charAt(0);
                    System.out.println();
                    continue;
                }

                System.out.print("Are you a student? (Y/N): ");
                char studentInput = scanner.next().charAt(0);
                boolean isStudent = (studentInput == 'Y' || studentInput == 'y');

                // PRICES
               double itemPrice = switch (itemNumber) {
                case 1 -> 33.00;
                case 2 -> 35.00;
                case 3 -> 65.00;
                case 4 -> 30.00;
                case 5 -> 20.00;
                default -> 0.0;
            };
                double subtotal = itemPrice * quantity;
                double discountRate = 0.0;

                if (isStudent && subtotal >= 500.0) {
                    discountRate = 0.15;
                } else if (isStudent) {
                    discountRate = 0.10;
                } else if (subtotal >= 500.0) {
                    discountRate = 0.05;
                }

                double discountAmount = subtotal * discountRate;
                double orderTotal = subtotal - discountAmount;

                grandTotalQuantity += quantity;
                grandTotalBeforeDiscount += subtotal;
                grandTotalDiscount += discountAmount;
                grandFinalAmount += orderTotal;

                System.out.printf("Subtotal: Php %.2f%n", subtotal);
                System.out.printf("Discount: Php %.2f%n", discountAmount);
                System.out.printf("Order total: Php %.2f%n", orderTotal);

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().charAt(0);
                System.out.println();
            }

            System.out.println("===== ORDER SUMMARY =====");
            System.out.println("Total items: " + grandTotalQuantity);
            System.out.printf("Total before discount: Php %.2f%n", grandTotalBeforeDiscount);
            System.out.printf("Total discount: Php %.2f%n", grandTotalDiscount);
            System.out.printf("Final amount: Php %.2f%n", grandFinalAmount);
            System.out.println("Thank you for ordering! Enjoy your meal!");

        } // >:b
    }
}