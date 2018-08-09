package com.example.ayush.firstapp.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;

public class CompoundView extends LinearLayout {

  @BindView(R.id.image) ImageView image;
  @BindView(R.id.caption) TextView caption;

  public CompoundView(Context context) {
    this(context, null);
  }

  public CompoundView(Context context,
      @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CompoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }
  public CompoundView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs);
  }

  private void init(@Nullable AttributeSet set) {
    inflate(getContext(), R.layout.compund_view, this);

    ButterKnife.bind(this);

    TypedArray typedArray = getContext().obtainStyledAttributes(set, R.styleable.CompoundView);

    image.setImageDrawable(typedArray.getDrawable(R.styleable.CompoundView_image));
    caption.setText(typedArray.getString(R.styleable.CompoundView_text));

    typedArray.recycle();
  }
}
