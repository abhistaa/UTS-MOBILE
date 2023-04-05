package id.ac.umn.umnlive;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button leftButton, rightButton, btnLogin;
    private TextInputLayout til_inputUsername;

    private int[] gambarList = {R.drawable.avatar1, R.drawable.avatar2};
    private int indexGambar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imageView = findViewById(R.id.avatar);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        btnLogin = findViewById(R.id.btnLogin);
        til_inputUsername = findViewById(R.id.til_inputUsername);

        int imageResourceId = R.drawable.avatar1;

        String textInputValue = til_inputUsername.getEditText().getText().toString();

        // Membuat objek Parcelable dari nilai TextInputLayout
        TextInputLayoutParcelable textInputParcelable = new TextInputLayoutParcelable(textInputValue);

        // menampilkan gambar pertama kali
        imageView.setImageResource(gambarList[indexGambar]);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexGambar--;
                if (indexGambar < 0) {
                    indexGambar = gambarList.length - 1;
                }
                imageView.setImageResource(gambarList[indexGambar]);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexGambar++;
                if (indexGambar >= gambarList.length) {
                    indexGambar = 0;
                }
                imageView.setImageResource(gambarList[indexGambar]);
            }
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,AreaPermainanActivity.class);
            intent.putExtra("textInputParcelable", textInputParcelable);
            intent.putExtra("imageResourceId", imageResourceId);
            startActivity(intent);
        });
    }


}


