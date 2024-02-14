package poly.ex.pay0;

import java.util.*;
import java.io.*;

public class PatMain0 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        PayService payService = new PayService();

        while (true){
            System.out.print("결제 수단을 입력하세요: ");
            String payOption = bf.readLine();
            if(payOption.equals("exit"))
                break;
            System.out.print("결제 금액을 입력하세요: ");
            int amount = Integer.parseInt(bf.readLine());
            payService.processPay(payOption, amount);
        }
        System.out.println("프로그램을 종료합니다.");

    }
}
