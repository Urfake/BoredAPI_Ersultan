package com.example.boredapi;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout back;
    private TextView what;
    private TextView price;
    private Button button;
    private String link;
    private ImageView heart;
    private TextView type;
    private TextView links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = findViewById(R.id.back);
        what = findViewById(R.id.what);
        price = findViewById(R.id.price);
        button = findViewById(R.id.button);
        button.setBackgroundColor(Color.BLUE);
        heart = findViewById(R.id.heart);
        type = findViewById(R.id.type);
        links = findViewById(R.id.links);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heart.setImageDrawable(getResources().getDrawable(R.drawable.heart));
                MyGetter myGetter = retrofit.create(MyGetter.class);
                Call<Message> call = myGetter.getMessage();
                call.enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        button.setBackgroundColor(Color.BLUE);
                        what.setText(response.body().getActivity());
                        price.setText(response.body().getPrice()+" $");
                        type.setText(response.body().getType());
                        link = response.body().getLink();
                        links.setText(link + "\nPress to the button and learn more");
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        what.setText(t.getMessage());
                    }
                });
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!link.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(link));
                    startActivity(intent);
                }
                return true;
            }
        });

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heart.setImageDrawable(getResources().getDrawable(R.drawable.red_heart));
            }
        });

    }
}