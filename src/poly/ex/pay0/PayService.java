package poly.ex.pay0;

public class PayService {

    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Pay pay = getPay(option);

        if (!isNull(pay) && pay.pay(amount)) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }

    private Pay getPay(String option) {
        if (NaverPay.option.equalsIgnoreCase(option))
            return new NaverPay();
        else if (KakaoPay.option.equalsIgnoreCase(option))
            return new KakaoPay();
        else
            return null;
    }

    private boolean isNull(Pay pay) {
        if(pay == null) {
            System.out.println("결제 수단이 없습니다.");
            return true;
        } else
            return false;
    }
}