package topic.Find_Different;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Find_Different extends Activity 
{
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST+1;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        MyCanvas myCanvas = new MyCanvas(this);
        setContentView(myCanvas);
    }          

    public boolean onCreateOptionsMenu(Menu menu)
    {
    	super.onCreateOptionsMenu(menu);
    	menu.add(Menu.NONE,MENU_ABOUT,0,R.string.menu_about);
    	menu.add(Menu.NONE,MENU_QUIT,0,R.string.menu_quit);
    	return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) 
    {
    	switch(item.getItemId()) 
    	{
	    	case MENU_ABOUT:    	
	    		new AlertDialog.Builder(this)	    		
	    		.setTitle("Ãö©ó")
	    		.setMessage("109719006 ¶À¬RÀM 109719008 ³¢Äm¸à 109719009 «J©y¨k 109719024 ½²µØ´Ð")
	    		.setPositiveButton("½T©w",
			    					new DialogInterface.OnClickListener() 
									{
							    		public void onClick(DialogInterface
							    		dialoginterface, int i) 
							    		{
							    		}
									})
	    		.show();
	    		
	    		break;
	    	case MENU_QUIT:
	    		finish();
	    		break;
    	}
		return false;
    }
    
}