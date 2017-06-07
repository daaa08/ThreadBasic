## Thread & Process

- 프로세스 : 프로그램을 실행시켜 동작시켜주는 것
- 쓰레드 : 한 프로세스 내에서 여러개의 일을 동시에 하는 것 ( 안드로이드에서는 기본적으로 하나의 스레드를 제공하는데 UI작성이 가능한 메인스레드가 됨)


 ###### 쓰레드 생성 방법

 ```java
 // 1 thread1 생성
        Thread thread = new Thread(){
            @Override
            public void run() {
                Log.i("Thread Test", "Hello Thread");
            }
        };

        // 1.1 thread1 실행
        thread.start();  // run() 함수를 실행시켜줌

        // 2 thread 생성2 - runnable은 Thread안에서만 실행 가능
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                Log.i("Thread Test", "Hello Runnable");
            }
        };
        // 2.1 Thread2 실행
        new Thread(thread2).start();
```
- 상속, 인터페이스로 생성
```java
// 3.1 Thread3 실행
CustomThread thread3 = new CustomThread();
thread3.start();
// 4.1 Thread4 실행
Thread thread4 = new Thread(new CustomRunnable());
thread4.start();
}
}


// 3 thread 생성3 - Thread 클래스를 상속받아서 생성
class CustomThread extends Thread{
@Override
public void run() {
Log.i("Thread Test", "Hello CustomThread");
}
}
// 4 thread 생성4 - Runnable 인터페이스 구현해서 생성 (사용도가 높음)
class CustomRunnable implements Runnable{
@Override
public void run() {
Log.i("Thread Test", "Hello CustomRunnable");
}
}
```

> Handler
- 스레드 사이에 메시지를 보내고 처리하기 위하여 사용하는 통신 메커니즘
- 두 개의 스레드 사이에 작업 내용 교환하게 함으로서 동기화 문제를 해결

> 메인스레드 / 서브스레드
- 메인 스레드: 사용자 인터페이스의 변경 사항을 전담
- 서브 스레드: 시간 소모적인 작업을 담당(UI안됨)

![enter image description here](https://image.slidesharecdn.com/random-150203095922-conversion-gate01/95/-6-638.jpg?cb=1422979422)

## Runnable
- 스레드 생성 시 run() 메소드만 채워주면 Runnable 인터페이스를 구현하여 가능
- 재사용성이 높고 일관성을 유지할 수 있어서 사용도가 높음

```java
class RunnableTest implements Runnable{
	@Override
	public void run() {
	}
}
```
- 스레드 클래스처럼 start() 메소드가 없음
- 실체 객체가 아님
- 설계구현 도구로 코드를 완성해서 넘겨줘야 함


## onDraw
- 상속된 사용자뷰 클래스에서 그리기 작업을 정의
- onDraw 메소드의 매개 변수로 전달되는 Canvas 객체를 이용하여 그리기 가능
- 접근 권한이 protected인 이유 : 외부의 다른 클래스가 임의로 사용하기 위한 것이 아니라 안드로이드 시스템에 의해서 뷰의 갱신이 필요할때 해당 클래스 내부적으로 자동으로 호출되어지는 메소드이기때문
```java
class Stage extends View {
        Paint paint;
        List<RainDrop> rainDrops = new ArrayList<>();
        public Stage(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.BLUE);
        }

        // 화면에 로드되는 순간 호출되는 함수
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //               x좌표, y좌표, 반지름, 컬러,굵기 등
            for(RainDrop drop : rainDrops) {
                canvas.drawCircle(drop.x, drop.y, drop.radius, drop.paint);
            }
        }

        public void addRainDrop(RainDrop rainDrop){
            this.rainDrops.add(rainDrop);
        }
    }
```

> Canvas
- 그림을 그리는 행위를 정의한 클래스
- 뷰에서 어떤 것을 그리고자 한다면 반드시 Canvas 클래스가 필요

> Paint
-  그릴때 사용하는 속성에대한 정의
