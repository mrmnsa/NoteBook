package com.example.diary;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private DBOpenHelper mDBOpenHelper;
    private Button mBtRegisteractivityRegister;
    private ImageView mIvRegisteractivityBack;
    private EditText mEtRegisteractivityUsername;
    private EditText mEtRegisteractivityPassword1;
    private EditText mEtRegisteractivityPassword2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void initView() {
        mBtRegisteractivityRegister = findViewById(R.id.bt_registeractivity_register);
        mIvRegisteractivityBack = findViewById(R.id.iv_registeractivity_back);
        mEtRegisteractivityUsername = findViewById(R.id.et_registeractivity_username);
        mEtRegisteractivityPassword1 = findViewById(R.id.et_registeractivity_password);
        mEtRegisteractivityPassword2 = findViewById(R.id.et_registeractivity_password2);
        /**
         * 注册页面能点击的就三个地方
         * top处返回箭头、、注册按钮
         */
        mIvRegisteractivityBack.setOnClickListener(this);
        mBtRegisteractivityRegister.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_registeractivity_back: //返回登录页面
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.bt_registeractivity_register:    //注册按钮
                //获取用户输入的用户名、
                String username = mEtRegisteractivityUsername.getText().toString().trim();
                String password1 = mEtRegisteractivityPassword1.getText().toString().trim();
                String password2 = mEtRegisteractivityPassword2.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1)&& !TextUtils.isEmpty(password2) ) {
                        if (password1.equals(password2)) {
                            if (username.equals("maire")) {
                                //将用户名和密码加入到数据库中
                                mDBOpenHelper.add(username, password2);
                                Intent intent2 = new Intent(this, MainActivity.class);
                                startActivity(intent2);
                                finish();
                                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                            } else
                                {
                                mDBOpenHelper.add(username, password2);
                                Intent intent2 = new Intent(this, LoginActivity.class);
                                startActivity(intent2);
                                finish();
                                Toast.makeText(this, "作者名不一致，需要重新登录", Toast.LENGTH_SHORT).show();
                            }
                        }else

                        {
                            Toast.makeText(this, "密码输入不一致,请重新输入", Toast.LENGTH_SHORT).show();
                        }

                }else {
                    Toast.makeText(this, "未完善信息，修改失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

