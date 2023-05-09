import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class GuncelleMenu extends JFrame implements ActionListener {
	
	private JLabel lbl1, lbl2;
	private JTextField txt1, txt2;
	private JButton btn1;

	public GuncelleMenu() {
		super("Güncelleme Sayfasý");
		
		setLayout(null);
		
		lbl1 = new JLabel("Güncellemek Istediginiz Ucreti Giriniz:");
		txt1 = new JTextField();
		lbl2 = new JLabel("Yeni Ucreti Giriniz:");
		txt2 = new JTextField();
		btn1 = new JButton("Güncelle");
		
		lbl1.setBounds(50, 50, 250, 50);
		txt1.setBounds(280, 60, 130, 30);
		lbl2.setBounds(50, 100, 170, 50);
		txt2.setBounds(280, 110, 130, 30);
		btn1.setBounds(310, 150, 100, 30);
		
		btn1.addActionListener(this);
		
		add(lbl1);
		add(txt1);
		add(lbl2);
		add(txt2);
		add(btn1);

		setVisible(true);
		setSize(460,270);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn1) {
			
			String price = txt1.getText();
			String newPrice = txt2.getText();
			
			FileIslemler fileIslemler = new FileIslemler("", "", "", "", price);
			try {
				fileIslemler.updateData(newPrice);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	// Created by Mehmet Baran Ozdeniz - baranozdeniz.com
	
}
