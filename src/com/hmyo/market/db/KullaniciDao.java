package com.hmyo.market.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hmyo.market.domain.KullaniciDomain;

public class KullaniciDao {
	public static void tabloOlustur() {
		Connection baglanti = VeriTabaniBaglantisi.baglantiAl();

		try {
			String sql = "CREATE TABLE kullanici (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, adi VARCHAR(100), soyadi VARCHAR(100), kullanici_adi VARCHAR(100), parola VARCHAR(100), yetki INTEGER)";

			PreparedStatement sorgu = baglanti.prepareStatement(sql);

			sorgu.executeUpdate();

			sorgu.close();
			baglanti.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Kullanıcı tablosu zaten var");
		}

	}

	public static void ekle(KullaniciDomain eklenecekKullaniciDoman) {
		Connection baglanti = VeriTabaniBaglantisi.baglantiAl();

		try {
			String sql = "INSERT INTO kullanici(adi, soyadi, kullanici_adi, parola, yetki) VALUES(?,?,?,?,?)";
			PreparedStatement sorgu = baglanti.prepareStatement(sql);

			sorgu.setString(1, eklenecekKullaniciDoman.getAdi());
			sorgu.setString(2, eklenecekKullaniciDoman.getSoyadi());
			sorgu.setString(3, eklenecekKullaniciDoman.getKullaniciAdi());
			sorgu.setString(4, eklenecekKullaniciDoman.getParola());
			sorgu.setInt(5, eklenecekKullaniciDoman.getYetki());

			sorgu.executeUpdate();

			sorgu.close();
			baglanti.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static boolean kontrol(KullaniciDomain kontrolEdilecekKullaniciDomaim) {
		boolean sonuc = false;

		Connection baglanti = VeriTabaniBaglantisi.baglantiAl();

		try {
			String sql = "SELECT * FROM kullanici WHERE kullanici_adi = ? AND parola = ?";
			PreparedStatement sorgu = baglanti.prepareStatement(sql);

			sorgu.setString(1, kontrolEdilecekKullaniciDomaim.getKullaniciAdi());
			sorgu.setString(2, kontrolEdilecekKullaniciDomaim.getParola());

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				sonuc = true;
			}

			sorgu.close();
			baglanti.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return sonuc;

	}

	public static boolean kullaniciVarMi() {
		boolean sonuc = false;

		Connection baglanti = VeriTabaniBaglantisi.baglantiAl();

		try {
			String sql = "SELECT COUNT(*) FROM kullanici";
			PreparedStatement sorgu = baglanti.prepareStatement(sql);

			ResultSet rs = sorgu.executeQuery();

			if (rs.next()) {
				sonuc = rs.getInt(1) > 0;
			}

			rs.close();
			sorgu.close();
			baglanti.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sonuc;
	}

	public static boolean yetkiKontrol(KullaniciDomain kontrolEdilecekKullaniciDomain) {
		boolean sonuc = false;

		Connection baglanti = VeriTabaniBaglantisi.baglantiAl();

		try {
			String sql = "SELECT yetki FROM kullanici WHERE kullanici_adi = ? AND parola = ?";
			PreparedStatement sorgu = baglanti.prepareStatement(sql);

			sorgu.setString(1, kontrolEdilecekKullaniciDomain.getKullaniciAdi());
			sorgu.setString(2, kontrolEdilecekKullaniciDomain.getParola());
			
			ResultSet rs = sorgu.executeQuery();

			if (rs.next()) {
				sonuc = (rs.getInt(1) == 1);
			}

			rs.close();
			sorgu.close();
			baglanti.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sonuc;
	}

}
