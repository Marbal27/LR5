package com.example.lr5_;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class TextFragment extends Fragment {

    EditText FIO,Email;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }




//    public void form_btn(View view) {
//        FIO.setText("");
//        Email.setText("");
////        Toast myToast= Toast.makeText(getApplicationContext(),"УСПЕХ!",Toast.LENGTH_SHORT);
////        myToast.show();
//    }
}