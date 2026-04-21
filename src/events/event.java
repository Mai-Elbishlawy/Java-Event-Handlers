package events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class event extends MouseAdapter implements ActionListener, ItemListener,KeyListener{
         JFrame frame=new JFrame ();
		 JPanel panel=new JPanel();
		 JTextField textfield=new JTextField(); 
		 JButton button=new JButton ("Copy");
		 JLabel label =new JLabel ();
		 JRadioButton rbutton1=new JRadioButton("Enabled");
		 JRadioButton rbutton2=new JRadioButton("Disabled");
		 JCheckBox cbox1=new JCheckBox("Blod");
		 JCheckBox cbox2=new JCheckBox("Italic");
		 JCheckBox cbox3=new JCheckBox("Plain");
		 JCheckBox cbox4=new JCheckBox("UnderLine");
		 JLabel photor =new JLabel ();
		 JLabel photog =new JLabel ();
		 JLabel selectl =new JLabel ();
		 JButton buttons =new JButton ("Save");
		 int x=500;
		 int y=50;
		 //constructor
	public event() {
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  
		 //create frame
		frame.setLayout(null);
		frame.setSize(900, 650);
		frame.setLocation(0, 0);
		frame.setBackground(Color.WHITE);
		frame.setResizable(true);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		
		//create panel
		panel.setLayout(null);
		panel.setSize(900, 650);
		panel.setLocation(0, 0);
		panel.setBackground(Color.WHITE);
		
		
	    //create textfield 
		textfield.setBounds(100, 50, 200, 100);
		textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		textfield.addMouseListener(this);
		panel.add(textfield);
		
		//create button
		button.setBounds(350, 85, 90, 25);
		button.addActionListener(this);
		panel.add(button);
		
		//create lable
		label.setBounds(x, y, 200, 100);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.add(label);
		
	    //redio button
		rbutton1.setBounds(100, 200, 85, 35);
		rbutton1.addActionListener(this);
		panel.add(rbutton1);
		rbutton2.setBounds(220, 200, 85, 35);
		rbutton2.addActionListener(this);
		panel.add(rbutton2);
		
		//group to redio button
		ButtonGroup group=new ButtonGroup();
		group.add(rbutton1);
		group.add(rbutton2);
		rbutton1.setSelected(true);
		
		//checkboxs
		cbox1.setBounds(100,250,90,45);
		cbox1.addItemListener(this);
		panel.add(cbox1);
		cbox2.setBounds(220,250,90,45);
		cbox2.addItemListener(this);
		panel.add(cbox2);
		cbox3.setBounds(340,250,90,45);
		cbox3.addItemListener(this);
		panel.add(cbox3);
		cbox4.setBounds(460,250,90,45);
		cbox4.addItemListener(this);
		panel.add(cbox4);
		cbox3.setSelected(true);
		
		//photos
		ImageIcon iconr=new ImageIcon("Images/red.png");
		Image imager=iconr.getImage();
		Image newimager=imager.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newiconr=new ImageIcon (newimager);
		photor.setIcon(newiconr);
		photor.setText("RED");
		//photor.setHorizontalAlignment(JLabel.CENTER);
		photor.setVerticalTextPosition(JLabel.BOTTOM);
		photor.setHorizontalTextPosition(JLabel.CENTER);
		photor.setBounds(100, 350, 100, 100);
		photor.setForeground(Color.RED);
		photor.addMouseListener(this);
		photor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(photor);
		
		ImageIcon icong=new ImageIcon("Images/green.png");
		Image imageg=icong.getImage();
		Image newimageg=imageg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newicong=new ImageIcon (newimageg);
		photog.setIcon(newicong);
		photog.setText("Green");
		photog.setVerticalTextPosition(JLabel.BOTTOM);
		photog.setHorizontalTextPosition(JLabel.CENTER);
		photog.setBounds(200, 350, 100, 100);
		photog.setForeground(Color.GREEN);
		photog.addMouseListener(this);
		photog.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(photog);
		
		
		selectl.setBounds(750, 85, 90, 25);
		selectl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		panel.add(selectl);
		
		
		buttons.setBounds(350, 500, 90, 25);
		buttons.addActionListener(this);
		panel.add(buttons);
		
		frame.add(panel);
		panel.setVisible(true);
		frame.requestFocus();
	    frame.setVisible(true);
	}
	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			String s=textfield.getText();
		    if (cbox4.isSelected()) {
	            label.setText("<html><u>" + s + "</u></html>");
	        } else {
	            label.setText(s);
	        }
		    frame.requestFocus();
		}
		if (e.getSource()==rbutton1) {
			textfield.setEditable(true);
		}
		if (e.getSource()==rbutton2) {
			textfield.setEditable(false);
		}
		if (e.getSource()==buttons) {
			JOptionPane.showMessageDialog(frame, "Data Saved Successfully!", "NEW MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		//in java each font represented by an integer constant
		int style=Font.PLAIN;
		String s=textfield.getText();
		if (cbox1.isSelected()) {
			style+=Font.BOLD;
		}
        if (cbox2.isSelected()) {
        	style+=Font.ITALIC;
        }
        if (cbox3.isSelected()) {
        	style+=Font.PLAIN;
        }
        if (cbox4.isSelected()) {
        	label.setText("<html><u>" + s + "</u></html>");
        }
	   else {
        label.setText(s); // السطر ده هو اللي هيشيل الخط لما تشيلي الـ Check
       }
        label.setFont(new Font("Arial",style,20));	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource()==photor) {
			label.setForeground(Color.RED);
		}
		if (e.getSource()==photog) {
			label.setForeground(Color.GREEN);
		}	
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == textfield) {
		String selected = textfield.getSelectedText();
		if (selected!=null) {
              selectl.setText("Length: "+selected.length());
		}
		else {
			 selectl.setText("Length: 0");
		}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		if (code==KeyEvent.VK_UP) {
			y=y-5;
			label.setLocation(x, y);
		}
		if (code==KeyEvent.VK_DOWN) {
			y=y+5;
			label.setLocation(x,y);
		}
		if (code==KeyEvent.VK_LEFT) {
			x=x-5;
			label.setLocation(x,y);
		}
		if (code==KeyEvent.VK_RIGHT) {
			x=x+5;
			label.setLocation(x,y);
		}
		
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {}

	
}
