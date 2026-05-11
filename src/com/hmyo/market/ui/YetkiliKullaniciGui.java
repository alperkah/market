package com.hmyo.market.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hmyo.market.db.KullaniciDao;
import com.hmyo.market.domain.KullaniciDomain;
import com.hmyo.market.util.YetkiSeviyeleri;

public class YetkiliKullaniciGui extends JDialog {

	public YetkiliKullaniciGui() {
		initDialog();
	}

	private void initDialog() {
		add(initPanel());
		setTitle("Yetkili Kullanici Olusturma");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private JPanel initPanel() {
		JPanel anaPanel = new JPanel(new GridLayout(6, 2, 5, 5));
		JLabel adiLabel = new JLabel("Adı",JLabel.RIGHT);
		JTextField adiField = new JTextField(10);
		JLabel soyadiLabel = new JLabel("Soyadı", JLabel.RIGHT);
		JTextField soyadiField = new JTextField(10);
		JLabel kullaniciAdiLabel = new JLabel("Kullanici Adı", JLabel.RIGHT);
		JTextField kullaniciAdiField = new JTextField(10);
		JLabel parolaLabel = new JLabel("Parola", JLabel.RIGHT);
		JTextField parolaField = new JTextField(10);
		JLabel parolaTekrariLabel = new JLabel("Parola Tekrarı", JLabel.RIGHT);
		JTextField parolaTekrariField = new JTextField(10);
		JButton olusturButton = new JButton("Oluştur");
		JButton iptalButton = new JButton("İptal");

		anaPanel.add(adiLabel);
		anaPanel.add(adiField);
		anaPanel.add(soyadiLabel);
		anaPanel.add(soyadiField);
		anaPanel.add(kullaniciAdiLabel);
		anaPanel.add(kullaniciAdiField);
		anaPanel.add(parolaLabel);
		anaPanel.add(parolaField);
		anaPanel.add(parolaTekrariLabel);
		anaPanel.add(parolaTekrariField);
		anaPanel.add(olusturButton);
		anaPanel.add(iptalButton);
		
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		olusturButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KullaniciDomain eklenecekKullaniciDomain = new KullaniciDomain();
				eklenecekKullaniciDomain.setAdi(adiField.getText());
				eklenecekKullaniciDomain.setSoyadi(soyadiField.getText());
				eklenecekKullaniciDomain.setKullaniciAdi(kullaniciAdiField.getText());
				eklenecekKullaniciDomain.setParola(parolaField.getText());
				eklenecekKullaniciDomain.setYetki(YetkiSeviyeleri.YONETICI);
				
				KullaniciDao.ekle(eklenecekKullaniciDomain);
				
				if(KullaniciDao.kullaniciVarMi()) {
					dispose();
					new GirisGui();
				}else {
					System.out.println("Kullanıcı eklenememiş");
				}
				
				dispose();
				
			}
		});
		
		iptalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		return anaPanel;
	}

}
