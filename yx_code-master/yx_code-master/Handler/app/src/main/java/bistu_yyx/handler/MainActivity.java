package bistu_yyx.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_log;
    private MyHandler handler;
    private MyThread thread;
    private ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new MyHandler();
        thread = new MyThread();
        pg = (ProgressBar) findViewById(R.id.pg_progress);

        Button btn_startThread = (Button) findViewById(R.id.btn_start_thread);
        tv_log = (TextView) findViewById(R.id.tv_log);
        btn_startThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(thread).start();
            }
        });
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            tv_log.setText(msg.arg1 + "");
            pg.setProgress(msg.arg1);
        }
    }

    private class MyThread implements Runnable {
        @Override
        public void run() {
            int progress = 0;
            Message msg;
            while (progress <= 100) {
                msg = new Message();
                msg.arg1 = progress;
                handler.sendMessage(msg);
                progress += 10;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            msg = handler.obtainMessage();//同 new Message();
            msg.arg1 = 0;
            handler.sendMessage(msg);
        }
    }
}
