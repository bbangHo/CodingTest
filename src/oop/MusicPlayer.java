package oop;

public class MusicPlayer {
    int volume;
    boolean isOn;

    public void on() {
        isOn = true;
        System.out.println("실행");
    }
    public void off() {
        isOn = false;
        System.out.println("종료");
    }

    public void volumeUp() {
        volume++;
        System.out.println("현재 볼륨: " + volume);
    }

    public void volumeDown() {
        volume--;
        System.out.println("현재 볼륨: " + volume);
    }

    public void showStatus() {
        if(isOn)
            System.out.println("현재 볼륨: " + volume);
        else
            System.out.println("꺼져 있음");

    }


}
