package com.example.lr5_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.lr5_.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button btn_form;
    EditText FIO,Email;
    ActivityMainBinding binding;

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

            }

            return true;
        });

        setContentView(R.layout.activity_main);
        FIO = findViewById(R.id.editText_FIO);
        Email = findViewById(R.id.editTextEmail);
        btn_form = findViewById(R.id.btn_form);

        btn_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIO.setText("");
                Email.setText("");
                Toast myToast= Toast.makeText(getApplicationContext(),"УСПЕХ!",Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}