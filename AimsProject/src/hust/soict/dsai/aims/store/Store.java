package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static int maxDvdInStore=100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[maxDvdInStore];
    private static int qtyAvailable = 0;
    public void addDvd(DigitalVideoDisc dvd) {
        if (qtyAvailable < maxDvdInStore) {
            itemsInStore[qtyAvailable++] = dvd;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The store is almost full.");
        }
    }
    public void removeDvd(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyAvailable; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < qtyAvailable - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyAvailable - 1] = null;
                qtyAvailable--; 
                System.out.println("The disc has been removed.");
                return;
            }
        }
    }
}
