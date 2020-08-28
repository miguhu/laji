package com.example.lzz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lzz.message_wechat_Adapter;
import com.example.lzz.message_wechat_test;

import java.util.ArrayList;
import java.util.List;

public class Test_wechat extends AppCompatActivity {
    private List<message_wechat_test> msgList = new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private message_wechat_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_wechat);
//        initMsgs(); // 初始化消息数据
        inputText = (EditText) findViewById(R.id.input_wechat);
        send = (Button) findViewById(R.id.send_wechat);
        msgRecyclerView = (RecyclerView) findViewById(R.id.wechat_recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new message_wechat_Adapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    message_wechat_test msg = new message_wechat_test(content, message_wechat_test.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新RecyclerView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将RecyclerView定位到最后一行
                    inputText.setText("");
                    message_wechat_test msg1 = new message_wechat_test("收到！", message_wechat_test.TYPE_RECEIVED);
                    msgList.add(msg1);
                }
            }
        });
    }
}