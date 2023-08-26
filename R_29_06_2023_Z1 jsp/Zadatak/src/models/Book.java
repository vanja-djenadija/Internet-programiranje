package models;

import java.io.Serializable;

public class Book implements Serializable{ 
	
	private static final long serialVersionUID = -7908103731386848581L;
	
	private String naslov;
	private String pisac;
	private String linkKaDetaljima;
	private String linkKaSlici;
	private Integer cijena;
	
	public Book() {
		super();
	}

	public Book(String naslov, String pisac, String linkKaDetaljima, String linkKaSlici, Integer cijena) {
		super();
		this.naslov = naslov;
		this.pisac = pisac;
		this.linkKaDetaljima = linkKaDetaljima;
		this.linkKaSlici = linkKaSlici;
		this.cijena = cijena;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public String getLinkKaDetaljima() {
		return linkKaDetaljima;
	}

	public void setLinkKaDetaljima(String linkKaDetaljima) {
		this.linkKaDetaljima = linkKaDetaljima;
	}

	public String getLinkKaSlici() {
		return linkKaSlici;
	}

	public void setLinkKaSlici(String linkKaSlici) {
		this.linkKaSlici = linkKaSlici;
	}

	public Integer getCijena() {
		return cijena;
	}

	public void setCijena(Integer cijena) {
		this.cijena = cijena;
	}

	@Override
	public String toString() {
		return "Book [naslov=" + naslov + ", pisac=" + pisac + ", linkKaDetaljima=" + linkKaDetaljima + ", linkKaSlici="
				+ linkKaSlici + ", cijena=" + cijena + "]";
	}

}
