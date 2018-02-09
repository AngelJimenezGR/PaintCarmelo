package com.example.angeljimenez.paintcarmelo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Angel Jimenez on 08/02/2018.
 */

public class Lienzo extends View {


    private Paint pincel;
    private Bitmap bitmap;
    private Canvas lienzo;
    private int colorFondo, colorActual, grosor;
    private MaskFilter realzar;//realzar
    private MaskFilter difuminar;//difuminar

    public Lienzo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Lienzo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        lienzo.drawColor(GONE);
        for (PaintPath pp : paths) {
            pincel.setColor(pp.color);
            pincel.setStrokeWidth(pp.strokeWidth);
            pincel.setMaskFilter(null);

            if (pp.emboss)
                pincel.setMaskFilter(mEmboss);
            else if (pp.blur)
                pincel.setMaskFilter(mBlur);

            lienzo.drawPath(pp.path, pincel);

        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        canvas.restore();

    }

    public void init(DisplayMetrics metrics, int BRUSH_SIZE, int DEFAULT_COLOR, int backgroundColor) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        lienzo = new Canvas(bitmap);

        this.colorFondo = backgroundColor;

        colorActual = DEFAULT_COLOR;
        grosor = BRUSH_SIZE;
        invalidate();
    }
}
