package com.bigdata.model;


import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean
public class CrimeMB {
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CRIME", nullable=false)
	private int id_crime;
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
	public CrimeMB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPublicaddress() {
		return publicaddress;
	}
	public void setPublicaddress(String publicaddress) {
		this.publicaddress = publicaddress;
	}
	public String getControlnbr() {
		return controlnbr;
	}
	public void setControlnbr(String controlnbr) {
		this.controlnbr = controlnbr;
	}
	public String getCCN() {
		return CCN;
	}
	public void setCCN(String cCN) {
		CCN = cCN;
	}
	public String getPrecinct() {
		return Precinct;
	}
	public void setPrecinct(String precinct) {
		Precinct = precinct;
	}
	public String getReportedDate() {
		return ReportedDate;
	}
	public void setReportedDate(String reportedDate) {
		ReportedDate = reportedDate;
	}
	public String getBeginDate() {
		return BeginDate;
	}
	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getOffense() {
		return Offense;
	}
	public void setOffense(String offense) {
		Offense = offense;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUCRCode() {
		return UCRCode;
	}
	public void setUCRCode(String uCRCode) {
		UCRCode = uCRCode;
	}
	public String getEnteredDate() {
		return EnteredDate;
	}
	public void setEnteredDate(String enteredDate) {
		EnteredDate = enteredDate;
	}
	public String getLong() {
		return Long;
	}
	public void setLong(String l) {
		Long = l;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getNeighborhood() {
		return Neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		Neighborhood = neighborhood;
	}
	public String getLastChanged() {
		return lastChanged;
	}
	public void setLastChanged(String lastChanged) {
		this.lastChanged = lastChanged;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getOBJECTID() {
		return OBJECTID;
	}
	public void setOBJECTID(String oBJECTID) {
		OBJECTID = oBJECTID;
	}
	public String getESRI_OID() {
		return ESRI_OID;
	}
	public void setESRI_OID(String eSRI_OID) {
		ESRI_OID = eSRI_OID;
	}
	@Override
	public String toString() {
		return "Crime [publicaddress=" + publicaddress + ", controlnbr=" + controlnbr + ", Offense=" + Offense
				+ ", Description=" + Description + ", Neighborhood=" + Neighborhood + "]";
	}
	
}
