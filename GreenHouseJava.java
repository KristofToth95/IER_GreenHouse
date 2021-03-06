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
import java.util.Random;


public class GreenHouseJava extends Environment {
	
	private int homerseklet = (new Random()).nextInt(50);
	
	public int getHomerseklet() {
		return homerseklet;
	}
	
	public void setHomerseklet(int a){
		homerseklet = a;
	}

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
		 JPanel panel = new JPanel();
		 JLabel label = new JLabel();
		 JButton riaszt = new JButton("Riasztas");
		 JButton ontoz = new JButton("Ontozes");
		 JButton hut = new JButton("Hutes"); 
		 JButton fut = new JButton("Futes");
		 JButton uj_hom_btn = new JButton("Uj homerseklet");
		 JTextArea uj_hom_txt = new JTextArea();
		 JLabel akt_hom_txt = new JLabel("Aktualis homerseklet: " + getHomerseklet());
		 JButton reset = new JButton("Reset");
					
		 GreenHouseGUI(){
			 super("Okos UvegHaz");
			 
			  
			 setPreferredSize(new Dimension(500,500));
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			 
			 this.add(panel, BorderLayout.CENTER);
			 panel.setLayout(null);
			 /*p.add(new Button("Riasztas"), BorderLayout.SOUTH);
			 p.add(new Button("Ontozes"), BorderLayout.SOUTH);
			 p.add(new Button("Hutes"), BorderLayout.SOUTH);
			 p.add(new Button("Futes"), BorderLayout.SOUTH);
			 */
			
			riaszt.setBounds(65, 42, 142, 23);
			panel.add(riaszt);
			riaszt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(riaszt.getText());
					reset.setVisible(true);
				}
			});
			
			ontoz.setBounds(252, 42, 142, 23);
			panel.add(ontoz);
			ontoz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(ontoz.getText());
					reset.setVisible(true);
				}
			});
			
			hut.setBounds(65, 92, 142, 23);
			panel.add(hut);
			hut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(hut.getText());
					reset.setVisible(true);
				}
			});
		
			fut.setBounds(252, 92, 142, 23);
			panel.add(fut);
			fut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(fut.getText());
					reset.setVisible(true);
				}
			});
			
			uj_hom_btn.setBounds(252, 244, 142, 40);
			panel.add(uj_hom_btn);
			uj_hom_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						setHomerseklet(Integer.parseInt(uj_hom_txt.getText()));
					} catch (Exception ex){
						System.out.println("Nem megfelelo homerseklet ertek");
					}
					akt_hom_txt.setText("Aktualis homerseklet: " + getHomerseklet());
				}
			});
			
			uj_hom_txt.setBounds(65, 252, 142, 32);  
			panel.add(uj_hom_txt);
			
			akt_hom_txt.setBounds(65, 193, 329, 40);
			panel.add(akt_hom_txt);
			
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(65, 318, 329, 32);
			//label.setForeground(Color.RED);
			panel.add(label);
			
			reset.setBounds(252, 361, 142, 23);
			panel.add(reset);
			reset.setVisible(false);
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText("");
					reset.setVisible(false);
				}
			});
			 
			 pack();
             setVisible(true);
             paint();
		 }
		 
				 
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


