package com.hmyo.market.domain;

public class KullaniciDomain {

	private int id;
	private String adi;
	private String soyadi;
	private String kullaniciAdi;
	private String parola;
	private int yetki;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public int getYetki() {
		return yetki;
	}

	public void setYetki(int yetki) {
		this.yetki = yetki;
	}

	@Override
	public String toString() {
		return "KullaniciDomain [adi=" + adi + ", soyadi=" + soyadi + ", kullaniciAdi=" + kullaniciAdi + "]";
	}

	

}
