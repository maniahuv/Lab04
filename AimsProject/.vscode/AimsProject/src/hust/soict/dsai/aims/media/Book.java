package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBook = 0;
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        nbBook++;
        setId(nbBook);
        this.authors=authors;
    }
    public List<String> getAuthors(){
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public void addAuthor(String authorName) {
        boolean a=false;
        for (String author : authors){
            if (author.equals(authorName)){
                a=true;
                System.out.println("Error, cannot add authorname!");
            }
        }
        if (a==false) authors.add(authorName);
    }
    public void removeAuthor(String authorName) {
        boolean a=false;
        for (String author : authors){
            if (author.equals(authorName)){
                a=true;
                authors.remove(authorName);
                System.out.println("Remove success!");
            }
        }
        if (a==false) authors.add(authorName);
    }
    public String toString() {
        return "Book: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Authors: " + authors;
    }
}
