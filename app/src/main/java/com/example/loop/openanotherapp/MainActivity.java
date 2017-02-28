package com.example.loop.openanotherapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText to = (EditText) findViewById(R.id.email_to);
        EditText subject = (EditText) findViewById(R.id.email_subject);
        EditText body = (EditText) findViewById(R.id.email_body);
        Button send = (Button) findViewById(R.id.email_send);
        send.setOnClickListener(v -> composeEmail(to.getText().toString(), subject.getText().toString(), body.getText().toString()));
    }


    private void composeEmail(String to, String subject, String body) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
