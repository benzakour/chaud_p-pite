package plugin;


 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MyTimer implements ActionListener  {

	protected Timer timer;
	protected final ActionListener listener;
	
	public MyTimer(ActionListener listener) {
		this.listener= listener;
	}

    public void start(int milliseconds){
    	if(timer!=null){
    		stop();
    	} 
    	timer= new Timer(milliseconds, this);
    	timer.start();
    }

    public void stop(){
    	timer.stop();
    	timer=null;
    }

	public void actionPerformed(ActionEvent e) {
		listener.actionPerformed(e);
	}

}