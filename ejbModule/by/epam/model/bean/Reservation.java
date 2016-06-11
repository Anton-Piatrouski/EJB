package by.epam.model.bean;

import java.util.List;

public class Reservation {
	private String code;
	private String description;
	private List<ResComponent> resComponents;
	private Customer customer;
	private FareFamily fareFamily;
	
	public Reservation() {
		
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public List<ResComponent> getResComponents() {
		return resComponents;
	}

	public Customer getCustomer() {
		return customer;
	}

	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setResComponents(List<ResComponent> resComponents) {
		this.resComponents = resComponents;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}
}
