package com.example.greeting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView greetingMessage = findViewById(R.id.greetingMessage);
        EditText name = findViewById(R.id.getName);
        Button senderName = findViewById(R.id.senderSecond);

        String greeting = getIntent().getStringExtra("greeting");
        greetingMessage.setText(greetingMessage.getText() + " '"  + greeting + "' ");

        senderName.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
