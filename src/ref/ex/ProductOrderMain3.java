package ref.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductOrderMain3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력할 주문의 개수를 입력하세요: ");
        Integer n = Integer.parseInt(br.readLine());

        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder[] productOrders = new ProductOrder[n];

        // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = br.readLine();

            System.out.print("가격: ");
            Integer price = Integer.parseInt(br.readLine());

            System.out.print("개수: ");
            Integer quantity = Integer.parseInt(br.readLine());

            productOrders[i] = createOrder(productName, price, quantity);
        }

        // printOrders()를 사용해서 상품 주문 정보 출력
        printOrders(productOrders);

        // getTotalAmount()를 사용해서 총 결제 금액 계산
        // 총 결제 금액 출력
        System.out.println(getTotalAmount(productOrders));
    }

    public static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;

        return productOrder;
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;

        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }

        return totalAmount;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

}
