package topic.Find_Different;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View
{
	boolean isRunning = true;
	
	float x=0.0f , y=0.0f; 
	boolean drawB = false;
	boolean drawC = false;
	boolean drawD = false;
	
	//DisplayMetrics dm = new DisplayMetrics();
	
	Bitmap img_01 = null;
	Bitmap img_02 = null;
	Bitmap img_03 = null;
	Bitmap img_04 = null;
			
	Matrix matrix = new Matrix();
	
	public MyCanvas(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void onDraw(Canvas canvas) 
	{
		//getWindowManager().getDefaultDisplay().getMetrics(dm);
		        		
		canvas.drawColor( Color.rgb(100, 100, 255) );
		Paint Paint_01 = new Paint();
		Paint_01.setColor(Color.RED);

		img_01 = BitmapFactory.decodeResource( getResources(), R.drawable.a );
		img_02 = BitmapFactory.decodeResource( getResources(), R.drawable.b );
		img_03 = BitmapFactory.decodeResource( getResources(), R.drawable.c );
		img_04 = BitmapFactory.decodeResource( getResources(), R.drawable.d );
		
		
		canvas.drawBitmap(img_01,matrix,Paint_01);
		
		if(drawB)
			canvas.drawBitmap(img_02,matrix,Paint_01);
		if(drawC)
			canvas.drawBitmap(img_03,matrix,Paint_01);
		if(drawD)
			canvas.drawBitmap(img_04,matrix,Paint_01);
		
		invalidate();
	}
	
	//建立 Runnable
	private Runnable Runnable = new Runnable()
	{
	    public void run() 
	    {
	        long startTime=0, endTime=0;
	        while( isRunning==true )
	        {
	            startTime = System.currentTimeMillis(); //FPS
	            Handler.sendMessage( Handler.obtainMessage() ); 
	            endTime = System.currentTimeMillis(); //FPS
	            try 
	            {
	            	Thread.sleep( 1 ); //頓一下, FPS.
	            } 
	            catch ( InterruptedException ie )  
	            { 
	                ie.printStackTrace();  
	            }
	        } 
	    }
	};

	//建立 Handler
	Handler Handler = new Handler()
	{
	    public void handleMessage( Message e_msg )
	    {
	        super.handleMessage(e_msg); 
	        invalidate(); //觸發 onDraw.
	    } 
	};
	
	
	public boolean onTouchEvent(MotionEvent event) 
	{
	     x = event.getX();
	     y = event.getY();
	    
	    try
	    {
	        switch( event.getAction() )
	        {
		        case MotionEvent.ACTION_DOWN:
		        	if( 125<=x && x<=175 && 50<=y && y<=150 && !drawC)
		        		drawB = true;
		        	else if( 125<=x && x<=175 && 50<=y && y<=150 && drawC)
		        		drawD = true;
		        	if(300<=x && x<=350 && 200<=y && y<=250 && !drawB)
		        		drawC = true;
		        	else if(300<=x && x<=350 && 200<=y && y<=250 && drawB)
		        		drawD = true;
		        	if(drawD)
		        	{
		        		drawB = false;
		        		drawC = false;
		        	}
		            break;
		        case MotionEvent.ACTION_MOVE:
		            break;
		        case MotionEvent.ACTION_UP:
		            break;
		        default:
		        	break;
	        } //end switch
	    }
	    catch( Exception e )
	    {
	        e.printStackTrace();
	    } //end try
	 // TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
}
