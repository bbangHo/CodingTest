# 클래스와 데이터

**자바에서의 대입(=)은 항상 변수에 들어 있는 값을 복사해서 전달한다.**

```java
// stduent1는 참조 변수이고 얘는 참조값 x001을 가지고 있기 때문에 참조값이 
// 왼쪽에 복사됨
students[0] = student1;  // 참조값이 x001 이라 가정

students[0] = x001;
```

### 배열 최적화

- 우리가 직접 정의한 Student 타입도 일반적인 변수와 동일하게 배열을 생성할 때 포함할 수 있다.

```java
Student[] students = new Student[]{student1, student2};
```

- 생성과 선언을 동시에 하는 경우 다음과 같이 더 최적화 할 수 있다.

```java
Student[] students = {student1, student2};
```

# 자바 메모리 구조 & static & final
## 자바 메모리 구조

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/4e05d67f-7832-4a34-9070-3de95a4565ec/Untitled.png)

- 메서드, 스택, 힙 영역으로 구분됨
- 힙 영역은 GC의 대상이 된다.

> 힙 영역 안에서 인스턴스끼리 참조하는 경우에도 GC의 대상이 된다.
>

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/399e3fbf-5ded-4d12-9a45-1d6c6bbd4488/Untitled.png)

- Data 인스턴스를 100개 생성하면 힙 영역에 100개의 인스턴스가 생김
- 하지만 각 인스턴스의 내부 값은 서로 다를지라도, **메서드는 공통된 코드를 공유한다.**

## static 변수

- static이 붙은 멤버 변수는 메서드 영역에서 관리한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/1a3181c5-dbd1-4769-b318-3e73f91bcd04/Untitled.png)

```java
class Data {
		public String name;
		public **static** int count; //static

		// ...
}
```

### 변수 생명주기

- `지역 변수(매개변수 포함)`
    - 스택 영역에 있는 스택 프레임 안에 보관되는 변수
    - 메서드가 종료되면 스택 프레임도 제거 되는데 이때 해당 스택 프레임에 포함된 지역 변수도 함께 제거된다
- `인스턴스 변수`
    - 힙 영역에 보관되는 변수
    - GC가 발생하기 전까지 생존함
- `클래스 변수`
    - 메서드 영역에 static 영역에 보관되는 변수
    - 클래스 변수는 해당 클래스가 JVM에 로딩 되는 순간 생성된다. 그리고 JVM이 종료될 때 까지 생명주기가 어어진다

### import static

```java
import static static2.DecoData.staticCall;
```

- 이렇게 선언하면 `DecoData` 클래스의 static 메서드 혹은 static 변수를 `.` 을 붙이지 않고 사용할 수 있다

## final

```java
public class FieldInit {
 static final int CONST_VALUE = 10;
 final int value = 10;
}
// -----

public class FinalFieldMain { 
    public static void main(String[] args) {
        FieldInit fieldInit1 = new FieldInit();
 		FieldInit fieldInit2 = new FieldInit();
 		FieldInit fieldInit3 = new FieldInit();
 		System.out.println(fieldInit1.value);
 		System.out.println(fieldInit2.value);
 		System.out.println(fieldInit3.value);
	}
}
```

- 이 경우 메모리는 어떻게 될까?

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/9a703a19-985f-4561-a3cf-0383f17f94af/Untitled.png)

    - `FieldInit` 인스턴스가 생성될 때 모든 인스턴스에게 `final int value = 10;` 이 할당된다.

      = 메모리 낭비

    - `value` 에 static을 붙인다면 어떻게 될까?
        - static 영역은 단 하나만 존재하는 영역이다.
        - static 영역에 `value = 10;` 이 정의되어 중복을 피할 수 있따.

  > 필드에 final + 필드 초기화를 사용하는 경우 static 을 붙여서 사용하는 것이 효과적이다.


### final 변수와 참조

- final 을 기본형 변수에 사용하면 **값을 변경할 수 없다**
- final 을 참조형 변수에 사용하면 **참조값을 변경할 수 없다**

```java
public class Data {
		public int value;
}

public class FinalRefMain {
		public static void main(String[] args) {
			  final Data data = new Data();
				//data = new Data(); //final 변경 불가 컴파일 오류

					data.value = 10;   //static 변수가 아니라 변경 가능
}
```

# 상속과 메모리 구조
# 상속과 메모리 구조

- `ElectricCar electricCar = new ElectricCar();`

  ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/7f0abbf2-b24d-40a0-aecb-07d9b2c8b049/Untitled.png)

    - `ElectricCar` 인스턴스를 만들었지만 그 속에는 `Car`와 `ElectricCar` 두 가지 클래스 정보가 공존한다.
    - 상속이라고 해서 부모의 멤버와 메서드만 물려 받는게 아닌 **부모의 클래스도 함께 포함하여 생성된다**

### 호출

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/0500f535-b66a-40f9-8469-64ce8e582215/Untitled.png)

- `electricCar.charge()` 호출
    - 부모인 `Car`와 자식인 `ElectricCar` 중에서 어떤 메서드를 호출할지는 **호출하는 변수의 타입을 기준으로 선택한다**
    - 위의 예에선 호출 변수 타입이 `ElectricCar` 이기 때문에 `ElectricCar`의 `charge()`를 호출한다

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/a20bffcf-8478-4932-934f-fa11c468509a/Untitled.png)

- `electricCar.move()` 호출
    - 그림 참고

### ❗정리❗

- 상속 관계의 객체를 생성하면 그 내부에는 **부모와 자식이 모두 생성**된다.
- 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다. 이때 **호출자의 타입을 통해 대상 타입을 찾는다**.
- **현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행**한다. 기능을 찾지 못하면 컴파일 오류가 발생한다.

이 이후 super 에 대해서 들어봐야할 듯 대충 이해는 됨

![1000007813.jpg](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/f85b6836-7683-4de9-ab4b-ad360dd0a0ca/1000007813.jpg)

![1000007814.jpg](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/81a1ea34-fc6d-41a4-8c69-f32c2c031a2a/1000007814.jpg)

# 다형성 
# 다형성

- 한 객체가 여러 타입의 객체로 취급될 수 있는 능력을 뜻함

## 다형적 참조

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/e6cbbba4-aa04-49f6-a6ff-30a1a68794b4/Untitled.png)

```java
Parent poly = new Child();  // ok. 다형적 참조

Child child = new Parent();  // 컴파일 에러
```

- 부모 타입의 참조 변수가 자식 인스턴스를 참조하는 경우
- 메모리에는 부모와 자식 둘 다 생성된다.
- = **부모는 자식을 담을 수 있다**

### 메서드 호출

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/87713148-8411-4106-80d7-4a93645b4573/Untitled.png)

```java
poly.parentMethod();  // ok.

poly.childMethod();   // 컴파일 오류 발생
```

- 참조변수 poly의 타입은 `Parent`이다.
- `Parent`에는 `parentMethod()`만 정의되어 있기 때문에 `childMethod()`를 알 수가 없다. 그래서 사용할 수 없음
- = 부모 탑입의 참조변수는 **자식의 기능은 호출할 수 없다**.
- 하지만 poly는 `Child` 인스턴스를 참조하기 때문에 `childMethod()` 사용할 수 있긴 해야한다.

  → 다운 캐스팅을 통해서 사용할 수 있다.


## 다형성과 캐스팅

### 다운 캐스팅

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/b79c8c6d-7664-42be-a6e6-f764697fbb8f/Untitled.png)

```java
Parent poly = new Child();
  
Child child = (Child) poly;  // 다운 캐스팅

---
Child child = (Child) poly;  //다운캐스팅을 통해 부모타입을 자식 타입으로 변환한 다음에 대입 시도
Child child = (Child) x001;  // poly에 있는 참조 값 복사
Child child = x001;  // 최종 결과
```

- 다운 캐스팅 후 실행

```java
Child child = (Child) poly;
child.childMethod();
```

- 근데 매번 참조변수 만들어야 하나? 귀찮은데? → 일시적 다운 캐스팅

```java
((Child) poly).childMethod();  // 바로 다운 캐스팅 하여 호출 가능
```

> poly의 타입은 바뀌지 않는다. 자바는 뭘 할때 무조건 복사해서 가져온다.
>

### 업 캐스팅

```java
Child child = new Child();  // ok
Parent perent = child;  // ok 

Parent parent = (Parent) child;  // 사실은 이렇게 해야하는데 생략이 가능함
```

- 업캐스팅은 캐스팅 코드를 생략할 수 있다

### 다운 캐스팅과 주의점(다운 캐스팅을 자동으로 하지 않는 이유)

- 다운캐스팅을 잘못하면 심각한 런타임 오류가 발생할 수 있다.

```java
Parent parent1 = new **Child**();
Child child1 = (Child) parent1;
child1.childMethod(); //문제 없음

Parent parent2 = new **Parent**();
Child child2 = (Child) parent2; //런타임 오류 - ClassCastException
child2.childMethod(); //실행 불가
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/351a6039-a1f1-4ac0-b1de-b70336304073/Untitled.png)

## 업캐스팅은 안전하고 다운 캐스팅은 위험한 이유

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/4a9ef04e-7c1f-4d5e-af44-f7a1cbe4dfa5/Untitled.png)

- c 생성시 상위 타입이 다 포함되어 생성되기 때문
- 하지만 하위 타입은 같이 생성되지 않기 때문에 다운 캐스팅은 위험하다

## 메서드 오버라이딩

- **`오버라이딩 된 메서드`가 `항상 우선권`을 갖는다**

```java
public class Parent {
		public String value = "parent";
		public void method() {
		System.out.println("Parent.method");
}

public class Child extends Parent {
		 public String value = "child";

		 **@Override**
		 public void method() {
		 System.out.println("Child.method");
}

Parent parent = new Child();
println(parent.value);  // parent 출력
parent.method();   // Child.method 가 출력됨
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/7ff050b2-ec0f-470d-bd9d-89ac5feaca73/dc4ca035-2304-4344-bc8e-754c445eee79/Untitled.png)






