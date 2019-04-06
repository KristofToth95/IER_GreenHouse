// Environment code for project GreenHouse.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GreenHouseJava extends Environment {

    private Logger logger = Logger.getLogger("GreenHouse.mas2j."+GreenHouseJava.class.getName());
	private GreenHouseGUI gui = new GreenHouseGUI();
	
	private Object modelLock = new Object(); 

    /** Called before the MAS execution with the args informed in .mas2j */

	public GreenHouseJava(){
		
		new Thread() {
            public void run() {
                try {
                    while (isRunning()) {
						 gui.paintAll(gui.getGraphics());
						 Thread.sleep(1000);
						 }
                } catch (Exception e) {} 
            }
        }.start();  
	}
	
    @Override
    public void init(String[] args) {
      /*  super.init(args);
        addPercept(ASSyntax.parseLiteral("percept(demo)"));*/
    }



    @Override

    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        if (true) { // you may improve this condition
             informAgsEnvironmentChanged();
        }
     
		 gui.paintAll(gui.getGraphics());
		 return true; // the action was executed with success
    }



    /** Called before the end of MAS execution */

    @Override
    public void stop() {
        super.stop();
		gui.setVisible(false);
    }
	
	
	 class GreenHouseGUI extends JFrame {
		 Panel p = new Panel();
		 
		 GreenHouseGUI(){
			 super("Okos UvegHaz");
			 
			  
			 setPreferredSize(new Dimension(900,700));
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			 
			 this.add(p);
			 p.add(new Button("Riasztas"), BorderLayout.SOUTH);
			 p.add(new Button("Ontozes"), BorderLayout.SOUTH);
			 
			 pack();
             setVisible(true);
             paint();
		 }
		 
		/* void actionPerformed(ActionEvent e) {
					 String command = e.getActionCommand();
					 String l = "<html><center>";
					  if( command.equals("Riasztas"))  {
						   l = "<font color=\"red\" size=7><b>Riasztas</b><br></font>";
					  }
					  else if (command.equals("Ontozes")){
						  l = "<font color=\"red\" size=7><b>Ontozes</b><br></font>";
					  }
					  label.setText(l);
		}*/
				 
		 void paint(){
			/* synchronized (modelLock) {
				 Label label = new Label();
				 p.add(label);
				 label.setPreferredSize(new Dimension(180,180));
				 label.setHorizontalAlignment(BorderLayout.NORTH);
				 
				 actionPerformed();
				 
			 }*/
		 }
		 
		 
	 }

}


