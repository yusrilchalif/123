package com.example.resultintent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        draw();
        setContentView(ourView);
    }

    public void draw() {
        Bitmap blankBitmap;
        blankBitmap = Bitmap.createBitmap(800, 800, Bitmap.Config.ARGB_8888);

        Canvas canvas;
        canvas = new Canvas(blankBitmap);

        ourView = new ImageView(this);
        ourView.setImageBitmap(blankBitmap);

        Paint paint;
        paint = new Paint();

        canvas.drawColor(Color.argb(255, 0, 255, 255));

        Bitmap bitmapSlime;
        bitmapSlime = BitmapFactory.decodeResource(this.getResources(), R.drawable.slime);
        canvas.drawBitmap(bitmapSlime, 360, 400, paint);

        paint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawText("Monter Slime", 365, 380, paint);

        paint.setColor(Color.argb(255, 200, 0, 255));
        canvas.drawCircle(800, 0, 200, paint);

        paint.setColor(Color.argb(255, 225, 0, 200));
        canvas.drawCircle(0, 0, 300, paint);

        paint.setColor(Color.argb(255, 100, 0, 255));
        canvas.drawCircle(800, 800, 400, paint);

        paint.setColor(Color.argb(255, 225, 200, 200));
        canvas.drawCircle(0, 800, 350, paint);

        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawRect(100, 100, 50, 50, paint);
    }
}
