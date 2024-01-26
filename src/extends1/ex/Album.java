package extends1.ex;

public class Album extends Item {
    private String artist;

    public Album(String name, int price, String artist){
        super(name, price);
        super.name = name;
        super.price = price;
        this.artist = artist;
    }

    public void print(){
        super.print();
        System.out.println("- 아티스트:" + artist);
    }
}
