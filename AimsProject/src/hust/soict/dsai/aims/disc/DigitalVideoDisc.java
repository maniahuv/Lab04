package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc{
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDiscs++;
        this.id=nbDigitalVideoDiscs;
        this.title=title;
        this.category=category;
        this.director=director;
        this.length=length;
        this.cost=cost;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++;
        this.id=nbDigitalVideoDiscs;
        this.title=title;
        this.category=category;
        this.cost=cost;
    }
    public DigitalVideoDisc(String title) {
        nbDigitalVideoDiscs++;
        this.id=nbDigitalVideoDiscs;
        this.title=title; 
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public int getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
    public boolean isMatch(String title) {
        return title.equals(this.title);
    }
}