package com.example.intentplayground;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings("unused")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_user_input)
    TextInputEditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
    }

    @OnClick(R.id.btn_explicit)
    public void triggerExplicitIntent() {
        // Explicit Intent
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_explicit_extra)
    public void triggerExplicitIntentWithData() {
        // We will check if etMessage has some text first
        Editable text = etMessage.getText();
        // if the test is not null and the text string is not empty run the first part
        // else show the dialog
        if (text != null && !text.toString().isEmpty()) {
            String msg = text.toString();

            // Explicit Intent with Extra
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(Constant.MESSAGE, msg);
            startActivity(intent);
        } else {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("No Message Provided")
                    .setMessage("Please provide a message to continue")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show();
        }
    }

    @OnClick(R.id.btn_implicit)
    public void triggerImplicitIntent() {
        // Implicit Intent Example

        String url = "http://www.google.com"; // Url to load
        // Intent object with
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        // Checks to make sure we have an activ
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
