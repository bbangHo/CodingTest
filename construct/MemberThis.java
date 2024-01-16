package construct;

public class MemberThis {
    String nameField;
    void initMember(String nameParameter) {
        this.nameField = nameParameter; // 요즘은 멤버변수 색깔로 잘 구분해주기 때문에 지역(매개)변수랑 이름 다르면 굳이 쓸 필요없음!
    }
}
