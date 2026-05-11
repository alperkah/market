package com.hmyo.market.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeriTabaniBaglantisi {
	
	private static final int MIN_DESTEKLENEN_JAVA_SURUMU = 19;
	private static final String YOL = "jdbc:derby:market;create=true";
	private static final String KULLANICI = "";
	private static final String PAROLA = "";
	
	public static Connection baglantiAl(){
		javaSurumuDogrula();
		surucuyuYukle();

		try {
			return DriverManager.getConnection(YOL, KULLANICI, PAROLA);
		} catch (SQLException e) {
			throw new IllegalStateException("Veritabanına bağlanılamadı.", e);
		}
	}

	private static void javaSurumuDogrula() {
		int mevcutSurum = Runtime.version().feature();
		if (mevcutSurum < MIN_DESTEKLENEN_JAVA_SURUMU) {
			throw new IllegalStateException(
					"Derby sürücüsü Java " + MIN_DESTEKLENEN_JAVA_SURUMU + "+ gerektirir. Mevcut Java: " + mevcutSurum);
		}
	}

	private static void surucuyuYukle() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Derby EmbeddedDriver bulunamadı. Classpath'i kontrol edin.", e);
		} catch (LinkageError e) {
			throw new IllegalStateException("Derby sürücüsü mevcut Java sürümüyle uyumlu değil.", e);
		}
	}
	

}
