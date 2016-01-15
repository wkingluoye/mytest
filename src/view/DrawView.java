package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
	private Paint pa = new Paint();
	private Boolean yn = false;
	public DrawView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		yn = !yn;
		if(yn){
			pa.setColor(Color.GRAY);
		}else {
			pa.setColor(Color.WHITE);
		}
		canvas.drawRect(10,10,100,100, pa);
		pa.setColor(Color.YELLOW);
		if(yn){
			pa.setColor(Color.YELLOW);
		}else {
			pa.setColor(Color.BLUE);
		}
		pa.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawLine(10, 55, 100, 55, pa);
		canvas.drawLine(55, 10, 55, 100, pa);
		
		pa.setColor(Color.RED);
		canvas.drawRect(50,50,60,60, pa);
	}

}
