package extends1.ex;

public class Item {
    protected String name;
    protected int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public void print(){
        System.out.println("이름:" + name + ", 가격:" + price);
    }
}
