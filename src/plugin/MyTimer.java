package plugin;


 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MyTimer {

	protected Timer timer;
	
	public MyTimer() {
		this.timer = new Timer(1000, new MyTimerActionListener());
	}

    public void start(int milliseconds){
    	if(timer!=null){
    	} 
    }



class MyTimerActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {

    System.out.println("asdf");

  }
}
}