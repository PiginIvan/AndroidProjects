package com.example.greeting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> ResultActivity;
    String greeting = "Hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greetingMessage = findViewById(R.id.greetingMessage);
        Button senderGreeting = findViewById(R.id.senderFirst);

        greetingMessage.setText(greetingMessage.getText()  + " '" + greeting + "' ");

        senderGreeting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("greeting", greeting);
            ResultActivity.launch(intent);
        });

        ResultActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String name = data.getStringExtra("name");
                            String greetingWithName = greeting + " " + name + "!";
                            greetingMessage.setText(greetingWithName);
                        }
                    }
                });
    }
}