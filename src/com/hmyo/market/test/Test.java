package com.hmyo.market.test;

import javax.swing.SwingUtilities;

import com.hmyo.market.db.KullaniciDao;
import com.hmyo.market.ui.GirisGui;
import com.hmyo.market.ui.YetkiliKullaniciGui;

public class Test {
	public static void main(String[] args) {

	    KullaniciDao.tabloOlustur();

	    SwingUtilities.invokeLater(new Runnable() {

	        @Override
	        public void run() {
	            if (KullaniciDao.kullaniciVarMi()) {
	                new GirisGui();
	            } else {
	                new YetkiliKullaniciGui();
	            }
	        }
	    });
	}

}
