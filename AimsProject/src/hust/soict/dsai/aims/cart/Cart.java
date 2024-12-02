package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static int maxDvD=20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[maxDvD];
    private static int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < maxDvD) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList){
            if (qtyOrdered < maxDvD) {
                itemsOrdered[qtyOrdered++] = dvd;
                System.out.println("The dvd has been added.");
            } else {
                System.out.println("The cart is almost full.");
                break;
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < maxDvD) {
            itemsOrdered[qtyOrdered++] = dvd1;
            System.out.println("The dvd1 has been added.");
            if (qtyOrdered < maxDvD) {
                itemsOrdered[qtyOrdered++] = dvd2;
                System.out.println("The dvd2 has been added.");
            }
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        // Tìm kiếm disc được remove
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    // Đẩy dics ra ngoài, sắp xếp các disc còn lại theo lượt
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Cập nhật lại danh sách
                qtyOrdered--; 
                System.out.println("The disc has been removed.");
                return;
            }
        }
    }
    
    public double calculateTotalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); 
        }
        return total;
    }
    public void displayCart() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < qtyOrdered; i++) {
                DigitalVideoDisc disc = itemsOrdered[i];
                System.out.printf("%d. Title: %s, Category: %s, Director: %s, Length: %d min, Cost: $%.2f%n", disc.getId(), disc.getTitle(), disc.getCategory(), disc.getDirector() != null ? disc.getDirector() : "N/A", disc.getLength(), disc.getCost());
            }
        }
    }
    public void print() {
        System.out.println("***********************CART***********************\nOrdered Items:");
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.printf("%d. %s\n", disc.getId(), disc.toString());
            total += disc.getCost();
        }
        System.out.printf("Total cost: %.2f\n", total);
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        boolean a=false;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            if (id == disc.getId()) {
                System.out.printf("%d. %s\n", disc.getId(), disc.toString());
                a=true;
                break;
            }
        }
        if(!a) System.out.println("No match is found!\n");
    }
    public void searchByTitle(String title) {
        boolean a=false;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            if (disc.isMatch(title)) {
                System.out.printf("%d. %s\n", disc.getId(), disc.toString());
                a=true;
                break;
            }
        }
        if(!a) System.out.println("No match is found!\n");
    }
}
