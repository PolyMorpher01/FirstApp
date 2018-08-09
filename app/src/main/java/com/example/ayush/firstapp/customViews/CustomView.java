package com.example.ayush.firstapp.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.example.ayush.firstapp.R;
import timber.log.Timber;

public class CustomView extends View {
  Rect rect;
  Paint paintRect;
  Paint paintCircle;
  int squareColor;
  int squareSize;
  float cx = 0, cy = 0;
  float radius = 80f;

  Bitmap img;

  public CustomView(Context context) {
    super(context);

    init(null);
  }

  public CustomView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);

    init(attrs);
  }

  public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    init(attrs);
  }

  public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);

    init(attrs);
  }

  private void init(@Nullable AttributeSet set) {
    rect = new Rect();
    paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);

    paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
    paintCircle.setColor(Color.BLUE);

    //img = BitmapFactory.decodeResource(getResources(), R.drawable.img_tree1);
    //img = getResizedBitmap(img, getWidth(),getHeight());

    if (set == null) {
      return;
    }
    TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

    squareColor = typedArray.getColor(R.styleable.CustomView_square_color, Color.GREEN);
    squareSize = typedArray.getDimensionPixelSize(R.styleable.CustomView_square_size, 100);

    paintRect.setColor(squareColor);

    typedArray.recycle();
  }

 /* private Bitmap getResizedBitmap(Bitmap img, int width, int height) {
    Matrix matrix = new Matrix();

    RectF src = new RectF(0,0, img.getWidth(), img.getHeight());
    RectF dest = new RectF(0,0, width, height);

    matrix.setRectToRect(src, dest, Matrix.ScaleToFit.CENTER);

    return Bitmap.createBitmap(img,0,0,img.getWidth(),img.getHeight(),matrix,true);

  }*/

  public void swapColor() {
    paintRect.setColor(paintRect.getColor() == Color.GREEN ? Color.RED : squareColor);
    postInvalidate();
  }

  @Override protected void onDraw(Canvas canvas) {
    //canvas.drawColor(Color.RED);

    rect.left = squareSize;
    rect.top = squareSize;
    rect.right = squareSize * 2;
    rect.bottom = squareSize * 2;

    canvas.drawRect(rect, paintRect);

    if (cx == 0 && cy == 0) {
      cx = getWidth() / 2;
      cy = getHeight() / 2;
    }

    //cx = getWidth() - radius - 20;
    //cy = rect.top + rect.bottom / 4;

    canvas.drawCircle(cx, cy, radius, paintCircle);

    //canvas.drawBitmap(img,0,0,null);

  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    boolean value = super.onTouchEvent(event);

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN: {
        return true;
      }

      case MotionEvent.ACTION_MOVE: {
        float x = event.getX();
        float y = event.getY();

        double dx = Math.pow(x - cx, 2);
        double dy = Math.pow(x - cy, 2);

        Timber.e("touched out");

        //if (dx + dy < Math.pow(radius, 2)) {
        //touched
        Timber.e("touched");
        cx = x;
        cy = y;

        postInvalidate();
        //return true;
        //}

        return true;
      }
    }

    return value;
  }
}
