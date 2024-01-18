package access.ex2;

public class ShoppingCartRefactoring {
    private Item[] items = new Item[10];
    private int itemCount;

    public ShoppingCartRefactoring() {
        itemCount = 0;
    }

    public void addItem (Item item) {
        if(itemCount > 10)
            return;
        items[itemCount++] = item;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        
        for(int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명:" + item.getName() + ", 합계:" + item.getTotalPrice());
        }

        displayTotalCartPrice();
    }

    private void displayTotalCartPrice() {
        int count = 0;
        
        for(int i = 0; i < itemCount; i++) {
            count += items[i].getTotalPrice();
        }

        System.out.println("전체 가격 합:" + count);
    }
}
