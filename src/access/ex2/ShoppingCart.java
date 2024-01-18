package access.ex2;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public ShoppingCart() {
        itemCount = 0;
    }

    public void addItem (Item item) {
        items[itemCount++] = item;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");

        int count = 0;

        for(Item item : items) {
            System.out.println("상품명:" + item.getName() + ", 합계:" + item.getQuantity() * item.getPrice());
            count += item.getPrice() * item.getQuantity();
        }

        System.out.println("전체 가격 합:" + count);
    }
}
