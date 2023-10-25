package com.example.lr5_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.lr5_.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private Button btn_form;
//    EditText FIO,Email;
    ActivityMainBinding binding;

    private static final String CHANEL_ID = "ch1";
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TextFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int menuId = item.getItemId();
            if(menuId == R.id.text){
                replaceFragment(new TextFragment());

            } else if (menuId == R.id.question) {
                replaceFragment(new QuestionFragment());

            } else if (menuId == R.id.bell) {
                replaceFragment(new BellFragment());
                onclick_notification();
            }

            return true;
        });


    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    public void onclick_notification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANEL_ID,
                    "channel_2",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManagerCompat = notificationManagerCompat.from(this);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), CHANEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Лабораторная работа №5")
                        .setContentText("Беляева Мария Т-403901-ИСиТ")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManagerCompat.notify(1, builder.build());
    }
}