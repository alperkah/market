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

public class GirisGui extends JDialog {

	public GirisGui() {
		initDialog();
	}

	private void initDialog() {
		add(initPanel());
		setTitle("Kullanıcı Girişi");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private JPanel initPanel() {
		JPanel anaPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		JLabel kullaniciAdiLabel = new JLabel("Kullanici Adı", JLabel.RIGHT);
		JTextField kullaniciAdiField = new JTextField(10);
		JLabel parolaLabel = new JLabel("Parola", JLabel.RIGHT);
		JTextField parolaField = new JTextField(10);
		JButton girisButton = new JButton("Giriş");
		JButton iptalButton = new JButton("İptal");

		anaPanel.add(kullaniciAdiLabel);
		anaPanel.add(kullaniciAdiField);
		anaPanel.add(parolaLabel);
		anaPanel.add(parolaField);
		anaPanel.add(girisButton);
		anaPanel.add(iptalButton);

		girisButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KullaniciDomain kontrolEdilecekKullaniciDomain = new KullaniciDomain();
				kontrolEdilecekKullaniciDomain.setKullaniciAdi(kullaniciAdiField.getText());
				kontrolEdilecekKullaniciDomain.setParola(parolaField.getText());

				if (KullaniciDao.kontrol(kontrolEdilecekKullaniciDomain)) {
					if(KullaniciDao.yetkiKontrol(kontrolEdilecekKullaniciDomain)) {
						new AnaPencereGui(YetkiSeviyeleri.YONETICI);
					}else {
						new AnaPencereGui(YetkiSeviyeleri.KASIYER);
					}

					
				} else {
					System.out.println("Sisteme giriş başarısız");
				}

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
