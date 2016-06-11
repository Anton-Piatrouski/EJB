package by.epam.model.bean;

import java.io.Serializable;

public class ResComponent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String componentTypeCode;
	private String createDateTime;
	private String internalStatus;
	private String sequence;
	
	public ResComponent() {
		
	}

	public ResComponent(String componentTypeCode, String createDateTime, String internalStatus, String sequence) {
		this.componentTypeCode = componentTypeCode;
		this.createDateTime = createDateTime;
		this.internalStatus = internalStatus;
		this.sequence = sequence;
	}

	public String getComponentTypeCode() {
		return componentTypeCode;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public String getSequence() {
		return sequence;
	}

	public void setComponentTypeCode(String componentTypeCode) {
		this.componentTypeCode = componentTypeCode;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
}
