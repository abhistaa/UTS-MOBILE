package id.ac.umn.umnlive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Locale;

public class AreaPermainanActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private TextView viewSalam;
//    private ImageView avatar;
    private static final int GAME_TIME_RATIO = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_permainan);

        viewSalam = findViewById(R.id.tv_salam);

//        Intent intent = getIntent();
//
//        TextInputLayoutParcelable textInputParcelable = intent.getParcelableExtra("textInputParcelable");
//        TextInputLayout textInputLayout = findViewById(R.id.til_inputUsername);
//        textInputLayout.getEditText().setText(textInputParcelable.getTextInputValue());
//
//
//        int imageResourceId = intent.getIntExtra("imageResourceId", 0);
//
//        // Menampilkan gambar dalam ImageView
//        ImageView imageView = findViewById(R.id.avatar);
//        imageView.setImageResource(imageResourceId);
//
//        if (inputUsername != null) {
//            // Lakukan sesuatu dengan editText
//        } else {
//            // editText bernilai null, lakukan sesuatu untuk menanganinya
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_info:
                Toast.makeText(getApplicationContext(), "Ini adalah informasi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_home:
                Toast.makeText(getApplicationContext(), "Ini adalah halaman home", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private String getGreeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            return "Good Morning";
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            return "Good Afternoon";
        } else {
            return "Good Night";
        }
    }

    private void updateTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long startTimeMillis = 0;
        long timeElapsed = currentTimeMillis - startTimeMillis;
        long gameTime = timeElapsed / 1000 * GAME_TIME_RATIO; // GAME_TIME_RATIO adalah perbandingan waktu permainan dengan waktu nyata

        int hours = (int) (gameTime / 60 / 60);
        int minutes = (int) ((gameTime / 60) % 60);
        int seconds = (int) (gameTime % 60);

        String timeString = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        viewSalam.setText(getGreeting() + "\n" + timeString);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updateTime();
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}


