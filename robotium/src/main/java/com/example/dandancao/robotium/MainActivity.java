package com.example.dandancao.robotium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(id = R.id.et_input)
    EditText et_input;
    @BindView(id = R.id.et_input2)
    EditText et_input2;
    @BindView(id = R.id.btn_submit, click = true)
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindUtils.initBindView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                et_input.setText("This is EditTextActivity");
                et_input2.setText("This is EditTextActivity2");
                break;

        }
    }
}
