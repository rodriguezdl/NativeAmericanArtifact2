package com.example.daniel.signin3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final LinearLayout messages = findViewById(R.id.messages_container);
        final EditText messageField = findViewById(R.id.message_field);
        final Button btnSubmit = findViewById(R.id.btn_submit);

        chatUtils.addOnMessageListener(new chatUtils.OnMessageListener() {
            @Override
            public void onMessage(String newMessage) {
                TextView newMessageText = new TextView(getApplicationContext());
                newMessageText.setText(newMessage);
                messages.addView(newMessageText);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = messageField.getText().toString();
                chatUtils.sendMessage(userMessage);
                messageField.getText().clear();
            }
        });
    }
}
