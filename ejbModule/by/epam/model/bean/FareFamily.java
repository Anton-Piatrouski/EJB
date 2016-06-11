package by.epam.model.bean;

import java.io.Serializable;
import java.util.List;

public class FareFamily implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fareFamilyCode;
	private List<AncillaryAirComponent> ancillaryAirComponents;
	
	public FareFamily() {
		
	}

	public String getFareFamilyCode() {
		return fareFamilyCode;
	}

	public List<AncillaryAirComponent> getAncillaryAirComponents() {
		return ancillaryAirComponents;
	}

	public void setFareFamilyCode(String fareFamilyCode) {
		this.fareFamilyCode = fareFamilyCode;
	}

	public void setAncillaryAirComponents(List<AncillaryAirComponent> ancillaryAirComponents) {
		this.ancillaryAirComponents = ancillaryAirComponents;
	}
}
