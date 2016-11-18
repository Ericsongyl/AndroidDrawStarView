package com.nicksong.drawstar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class DrawStarView extends View {

	public DrawStarView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public DrawStarView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
	}
	
	public DrawStarView(Context context, AttributeSet attributeSet, int defStyleAttr) {
		super(context, attributeSet, defStyleAttr);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();  
        paint.setAntiAlias(true);  
  
        drawStar(canvas,paint,Color.RED,getHeight()/12,3,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.RED,getHeight()/12,3,true);  
        canvas.translate(-getHeight()/6,0);  
        canvas.translate(0,getHeight()/6);  
        drawStar(canvas,paint,Color.YELLOW,getHeight()/12,4,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.YELLOW,getHeight()/12,4,true);  
        canvas.translate(-getHeight()/6,0);  
        canvas.translate(0,getHeight()/6);  
        drawStar(canvas,paint,Color.GREEN,getHeight()/12,5,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.GREEN,getHeight()/12,5,true);  
        canvas.translate(-getHeight()/6,0);  
        canvas.translate(0,getHeight()/6);  
        drawStar(canvas,paint,Color.CYAN,getHeight()/12,6,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.CYAN,getHeight()/12,6,true);  
        canvas.translate(-getHeight()/6,0);  
        canvas.translate(0,getHeight()/6);  
        drawStar(canvas,paint,Color.BLUE,getHeight()/12,7,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.BLUE,getHeight()/12,7,true);  
        canvas.translate(-getHeight()/6,0);  
        canvas.translate(0,getHeight()/6);  
        drawStar(canvas,paint,Color.BLACK,getHeight()/12,8,false);  
        canvas.translate(getHeight()/6,0);  
        drawStar(canvas,paint,Color.BLACK,getHeight()/12,8,true);  
        canvas.translate(0,getHeight()/6);  
  
    }  
  
    /** 
     * 绘制彩色多边形或星形 
     * @param canvas Canvas画布 
     * @param paint Paint画笔 
     * @param color 颜色 
     * @param radius 外接圆半径 
     * @param count 外顶点数 
     * @param isStar 是否为星形 
     */  
    private void drawStar(Canvas canvas, Paint paint, int color, float radius, int count, boolean isStar){  
        canvas.translate(radius,radius);  
        if ((!isStar) && count < 3){  
            canvas.translate(-radius,-radius);  
            return;  
        }  
        if (isStar && count < 3){  
            canvas.translate(-radius,-radius);  
            return;  
        }  
        canvas.rotate(-90);  
        if (paint == null){  
            paint = new Paint();  
        }else{  
            paint.reset();  
        }  
        Path path = new Path();  
        float inerRadius = count%2==0?  
                (radius*(cos(360/count/2)-sin(360/count/2)*sin(90-360/count)/cos(90-360/count)))  
                :(radius*sin(360/count/4)/sin(180-360/count/2-360/count/4));  
        for (int i=0;i<count;i++){  
            if (i==0){  
                path.moveTo(radius*cos(360/count*i),radius*sin(360/count*i));  
            }else{  
                path.lineTo(radius*cos(360/count*i),radius*sin(360/count*i));  
            }  
            if (isStar){  
                path.lineTo(inerRadius*cos(360/count*i+360/count/2),inerRadius*sin(360/count*i+360/count/2));  
            }  
        }  
        path.close();  
        paint.setColor(color);  
        canvas.drawPath(path,paint);  
        canvas.rotate(90);  
        canvas.translate(-radius,-radius);  
    }  
      
    /** 
     * Math.sin的参数为弧度，使用起来不方便，重新封装一个根据角度求sin的方法 
     * @param num 角度 
     * @return 
     */  
    float sin(int num){  
        return (float) Math.sin(num*Math.PI/180);  
    }  
  
    /** 
     * 与sin同理 
     */  
    float cos(int num){  
        return (float) Math.cos(num*Math.PI/180);  
    }  
}
