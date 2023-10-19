package com.example.lr5_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lr5_.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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
//              break;
            } else if (menuId == R.id.question) {
                replaceFragment(new QuestionFragment());
//              break;
            } else if (menuId == R.id.bell) {
                replaceFragment(new BellFragment());
//              break;
            }

//            switch (menuId){
//                case R.id.text:
//                    replaceFragment(new TextFragment());
//                    break;
//                case R.id.question:
//                    replaceFragment(new QuestionFragment());
//                    break;
//                case R.id.bell:
//                    replaceFragment(new BellFragment());
//                    break;
//            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}