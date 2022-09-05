package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Comanda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private int CD_PERSON;
	private int NR_COMANDA;
	private int CD_AREA_EVT;
	private String TP_PERSON;
	//private Date DH_ATD;
	private int CD_USU_ATD;
	private Boolean TP_SIT;
	//private Date DH_ATU;
	private int CD_USU_ATU;
	
	
	public Comanda(int iD, int cD_PERSON, int nR_COMANDA, int cD_AREA_EVT, String tP_PERSON, int cD_USU_ATD, Boolean tP_SIT, int cD_USU_ATU) {
		ID = iD;
		CD_PERSON = cD_PERSON;
		NR_COMANDA = nR_COMANDA;
		CD_AREA_EVT = cD_AREA_EVT;
		TP_PERSON = tP_PERSON;
		//DH_ATD = dH_ATD;
		CD_USU_ATD = cD_USU_ATD;
		TP_SIT = tP_SIT;
		//DH_ATU = dH_ATU;
		CD_USU_ATU = cD_USU_ATU;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCD_PERSON() {
		return CD_PERSON;
	}

	public void setCD_PERSON(int cD_PERSON) {
		CD_PERSON = cD_PERSON;
	}

	public int getNR_COMANDA() {
		return NR_COMANDA;
	}

	public void setNR_COMANDA(int nR_COMANDA) {
		NR_COMANDA = nR_COMANDA;
	}

	public int getCD_AREA_EVT() {
		return CD_AREA_EVT;
	}

	public void setCD_AREA_EVT(int cD_AREA_EVT) {
		CD_AREA_EVT = cD_AREA_EVT;
	}

	public String getTP_PERSON() {
		return TP_PERSON;
	}

	public void setTP_PERSON(String tP_PERSON) {
		TP_PERSON = tP_PERSON;
	}

//	public Date getDH_ATD() {
//		return DH_ATD;
//	}
//
//	public void setDH_ATD(Date dH_ATD) {
//		DH_ATD = dH_ATD;
//	}

	public int getCD_USU_ATD() {
		return CD_USU_ATD;
	}

	public void setCD_USU_ATD(int cD_USU_ATD) {
		CD_USU_ATD = cD_USU_ATD;
	}

	public Boolean getTP_SIT() {
		return TP_SIT;
	}

	public void setTP_SIT(Boolean tP_SIT) {
		TP_SIT = tP_SIT;
	}

//	public Date getDH_ATU() {
//		return DH_ATU;
//	}
//
//	public void setDH_ATU(Date dH_ATU) {
//		DH_ATU = dH_ATU;
//	}

	public int getCD_USU_ATU() {
		return CD_USU_ATU;
	}

	public void setCD_USU_ATU(int cD_USU_ATU) {
		CD_USU_ATU = cD_USU_ATU;
	}



	@Override
	public int hashCode() {
		return Objects.hash(CD_PERSON, ID);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		return Objects.equals(CD_PERSON, other.CD_PERSON) && Objects.equals(ID, other.ID);
	}



	@Override
	public String toString() {
		return "Comanda [ID=" + ID + ", CD_PERSON=" + CD_PERSON + ", NR_COMANDA=" + NR_COMANDA + ", CD_AREA_EVT="
				+ CD_AREA_EVT + ", TP_PERSON=" + TP_PERSON + ", CD_USU_ATD=" + CD_USU_ATD
				+ ", TP_SIT=" + TP_SIT + ", CD_USU_ATU=" + CD_USU_ATU + "]";
	}
	
}
