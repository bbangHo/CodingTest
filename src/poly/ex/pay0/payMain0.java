package poly.ex.pay0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class payMain0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PayService payService = new PayService();

        while(true) {
            System.out.print("결제 수단을 입력하세요:");
            String option = br.readLine();
            if (option.equalsIgnoreCase("exit")) {
                System.out.print("프로그램을 종료합니다.");
                return;
            }

            System.out.print("결제 금액을 입력하세요:");
            int amount = Integer.parseInt(br.readLine());

            payService.processPay(option, amount);
        }
    }
}
