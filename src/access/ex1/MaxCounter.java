package access.ex1;

public class MaxCounter {
    private int count;
    private int max;

    public MaxCounter(int max) {
        count = 0;
        this.max = max;
    }

    public void increment() {
        if(count < max)
            count++;
        else    // else 지양
            System.out.println("최대값을 초과할 수 없습니다.");
    }

    public int getCount() {
        return count;
    }
}
