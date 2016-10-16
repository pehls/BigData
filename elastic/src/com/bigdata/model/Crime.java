package com.bigdata.model;

import java.io.Serializable;


public class Crime implements Serializable {
	/*
	 * publicaddress	
	 * controlnbr	
	 * CCN	
	 * Precinct	
	 * ReportedDate	
	 * BeginDate	
	 * Time	
	 * Offense	
	 * Description	
	 * UCRCode	
	 * EnteredDate	
	 * Long	
	 * Lat	
	 * x	
	 * y	
	 * Neighborhood	
	 * lastchanged	
	 * LastUpdateDate	
	 * OBJECTID	
	 * ESRI_OID
	 */
	private int id_teste;
	private String publicaddress;
	private String controlnbr;
	private String CCN;
	private String Precinct;
	private String ReportedDate;
	private String BeginDate;
	private String Time;
	private String Offense;
	private String Description;
	private String UCRCode;
	private String EnteredDate;
	private String Long;
	private String Lat;
	private String x;
	private String y;
	private String Neighborhood;
	private String lastChanged;
	private String lastUpdateDate;
	private String OBJECTID	;
	private String ESRI_OID;
	private int quant;
	private CrimeMB crimeMB;
	public Crime() {
		super();
		this.crimeMB = new CrimeMB();
		
		// TODO Auto-generated constructor stub
	}
	
	public Crime(int id_teste, String offense, int quant) {
		super();
		this.crimeMB = new CrimeMB();
		this.setId_teste(id_teste);
		this.setOffense(offense);
		this.quant = quant;
		
	}
	
	public String getPublicaddress() {
		return crimeMB.getPublicaddress();
	}

	public String getControlnbr() {
		return crimeMB.getControlnbr();
	}

	public String getCCN() {
		return crimeMB.getCCN();
	}

	public String getPrecinct() {
		return crimeMB.getPrecinct();
	}

	public String getReportedDate() {
		return crimeMB.getReportedDate();
	}

	public String getBeginDate() {
		return crimeMB.getBeginDate();
	}

	public String getTime() {
		return crimeMB.getTime();
	}

	public String getOffense() {
		return crimeMB.getOffense();
	}

	public String getDescription() {
		return crimeMB.getDescription();
	}

	public String getUCRCode() {
		return crimeMB.getUCRCode();
	}

	public String getEnteredDate() {
		return crimeMB.getEnteredDate();
	}

	public String getLong() {
		return crimeMB.getLong();
	}

	public String getLat() {
		return crimeMB.getLat();
	}

	public String getX() {
		return crimeMB.getX();
	}

	public String getY() {
		return crimeMB.getY();
	}

	public String getNeighborhood() {
		return crimeMB.getNeighborhood();
	}

	public String getLastChanged() {
		return crimeMB.getLastChanged();
	}

	public String getLastUpdateDate() {
		return crimeMB.getLastUpdateDate();
	}

	public String getOBJECTID() {
		return crimeMB.getOBJECTID();
	}

	public String getESRI_OID() {
		return crimeMB.getESRI_OID();
	}
	public int getId_teste() {
		return id_teste;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public void setId_teste(int id_teste) {
		this.id_teste = id_teste;
	}

	public void setPublicaddress(String publicaddress) {
		crimeMB.setPublicaddress(publicaddress);
	}

	public void setControlnbr(String controlnbr) {
		crimeMB.setControlnbr(controlnbr);;
	}

	public void setCCN(String cCN) {
		crimeMB.setCCN(cCN);
	}

	public void setPrecinct(String precinct) {
		crimeMB.setPrecinct(precinct);
	}

	public void setReportedDate(String reportedDate) {
		crimeMB.setReportedDate(reportedDate);
	}

	public void setBeginDate(String beginDate) {
		crimeMB.setBeginDate(beginDate);
	}

	public void setTime(String time) {
		crimeMB.setTime(time);
	}

	public void setOffense(String offense) {
		crimeMB.setOffense(offense);
	}

	public void setDescription(String description) {
		crimeMB.setDescription(description);
	}

	public void setUCRCode(String uCRCode) {
		crimeMB.setUCRCode(uCRCode);
	}

	public void setEnteredDate(String enteredDate) {
		crimeMB.setEnteredDate(enteredDate);
	}

	public void setLong(String l) {
		crimeMB.setLong(l);
	}

	public void setLat(String lat) {
		crimeMB.setLat(lat);
	}

	public void setX(String x) {
		crimeMB.setX(x);
	}

	public void setY(String y) {
		crimeMB.setY(y);
	}

	public void setNeighborhood(String neighborhood) {
		crimeMB.setNeighborhood(neighborhood);
	}

	public void setLastChanged(String lastChanged) {
		crimeMB.setLastChanged(lastChanged);
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		crimeMB.setLastUpdateDate(lastUpdateDate);
	}

	public void setOBJECTID(String oBJECTID) {
		crimeMB.setOBJECTID(oBJECTID);
	}

	public void setESRI_OID(String eSRI_OID) {
		crimeMB.setESRI_OID(eSRI_OID);
	}

	@Override
	public String toString() {
		
		return "Crime [publicaddress=" + getPublicaddress() + ", controlnbr=" + getControlnbr() + ", Offense=" + getOffense()
				+ ", Description=" + getDescription() + ", Neighborhood=" + getNeighborhood() + "]";
	}
	
}
