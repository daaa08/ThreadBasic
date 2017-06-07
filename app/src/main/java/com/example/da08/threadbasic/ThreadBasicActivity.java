package com.example.da08.threadbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ThreadBasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_basic);

        // 1 thread1 생성
        Thread thread = new Thread(){
            @Override
            public void run() {
                Log.i("Thread Test", "Hello Thread");
            }
        };

        // 1.1 thread1 실행
        thread.start();  // run() 함수를 실행시켜줌

        // 2 thread 생성2
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                Log.i("Thread Test", "Hello Runnable");
            }
        };
        // 2.1 Thread2 실행
        new Thread(thread2).start();

        // 3.1 Thread3 실행
        CustomThread thread3 = new CustomThread();
        thread3.start();
        // 4.1 Thread4 실행
        Thread thread4 = new Thread(new CustomRunnable());
        thread4.start();
    }
}


// 3 thread 생성3
class CustomThread extends Thread{
    @Override
    public void run() {
        Log.i("Thread Test", "Hello CustomThread");
    }
}
// 4 thread 생성4 - Runnable구현
class CustomRunnable implements Runnable{
    @Override
    public void run() {
        Log.i("Thread Test", "Hello CustomRunnable");
    }
}

