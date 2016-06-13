package by.epam.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.exception.custom.DaoException;
import by.epam.model.iface.ReservationDAO;
import by.epam.model.bean.AncillaryAirComponent;
import by.epam.model.bean.Customer;
import by.epam.model.bean.FareFamily;
import by.epam.model.bean.Payment;
import by.epam.model.bean.ResComponent;
import by.epam.model.bean.Reservation;

public class ReservationImplXml implements ReservationDAO {
	private Reservation reservation;
	
	public ReservationImplXml() {
		reservation = new Reservation();
	}
	
	public Reservation getReservation() throws DaoException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			
			InitialContext ic = new InitialContext();
			String uri = (String) ic.lookup("java:comp/env/xmlLocation");
			
			Document doc = docBuilder.parse(uri);
			
			Element reservationElement = doc.getDocumentElement();
			buildReservation(reservationElement);
			
			return reservation;
			
		} catch (ParserConfigurationException e) {
			throw new DaoException("Parser configuration error", e);
			
		} catch (IOException | SAXException | NamingException e) {
			throw new DaoException("File processing error", e);
		}
	}
	
	private void buildReservation(Element reservationElement) {
		String code = reservationElement.getAttribute("Code");
		String description = reservationElement.getAttribute("Description");
		
		NodeList resComponentsNodeList = reservationElement.getElementsByTagName("ResComponent");
		List<ResComponent> resComponents = buildResComponents(resComponentsNodeList);
		
		Element customerElement = (Element) reservationElement.getElementsByTagName("Customer").item(0);
		Customer customer = buildCustomer(customerElement);
		
		Element fareFamilyElement = (Element) reservationElement.getElementsByTagName("FareFamily").item(0);
		FareFamily fareFamily = buildFareFamily(fareFamilyElement);
		
		reservation.setCode(code);
		reservation.setDescription(description);
		reservation.setResComponents(resComponents);
		reservation.setCustomer(customer);
		reservation.setFareFamily(fareFamily);
	}
	
	private List<ResComponent> buildResComponents(NodeList resComponentsNodeList) {
		List<ResComponent> resComponents = new ArrayList<>();
		
		for (int i = 0; i < resComponentsNodeList.getLength(); i++) {
			Element resComponentElement = (Element) resComponentsNodeList.item(i);
			ResComponent resComponent = buildResComponent(resComponentElement);
			resComponents.add(resComponent);
		}
		return resComponents;
	}
	
	private ResComponent buildResComponent(Element resComponentElement) {
		String componentTypeCode = resComponentElement.getAttribute("ComponentTypeCode");
		String createDateTime = resComponentElement.getAttribute("CreateDateTime");
		String internalStatus = resComponentElement.getAttribute("InternalStatus");
		String sequence = resComponentElement.getAttribute("Sequence");
		
		return new ResComponent(componentTypeCode, createDateTime, internalStatus, sequence);
	}
	
	private Customer buildCustomer(Element customerElement) {
		String firstName = customerElement.getAttribute("FirstName");
		String lastName = customerElement.getAttribute("LastName");
		
		Element emailElement = (Element) customerElement.getElementsByTagName("Email").item(0);
		String emailAddress = emailElement.getAttribute("EmailAddress");
		
		Element phoneElement = (Element) customerElement.getElementsByTagName("Phone").item(0);
		String phoneNumber = phoneElement.getAttribute("PhoneNumber");
		
		NodeList paymentsNodeList = customerElement.getElementsByTagName("Payment");
		List<Payment> payments = buildPayments(paymentsNodeList);
		
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailAddress(emailAddress);
		customer.setPhoneNumber(phoneNumber);
		customer.setPayments(payments);
		
		return customer;
	}
	
	private List<Payment> buildPayments(NodeList paymentsNodeList) {
		List<Payment> payments = new ArrayList<>();
		
		for (int i = 0; i < paymentsNodeList.getLength(); i++) {
			Element paymentElement = (Element) paymentsNodeList.item(i);
			Payment payment = buildPayment(paymentElement);
			payments.add(payment);
		}
		return payments;
	}
	
	private Payment buildPayment(Element paymentElement) {
		String amountPaid = paymentElement.getAttribute("AmountPaid");
		String formOfPaymentTypeCode = paymentElement.getAttribute("FormOfPaymentTypeCode");
		String currencyCode = paymentElement.getAttribute("CurrencyCode");
		
		Payment payment = new Payment(amountPaid, formOfPaymentTypeCode, currencyCode);
		
		return payment;
	}
	
	private FareFamily buildFareFamily(Element fareFamilyElement) {
		String fareFamilyCode = fareFamilyElement.getAttribute("FareFamilyCode");
		
		NodeList ancillaryAirComponentsNodeList = fareFamilyElement.getElementsByTagName("AncillaryAirComponent");
		List<AncillaryAirComponent> components = buildAncillaryAirComponents(ancillaryAirComponentsNodeList);
		
		FareFamily fareFamily = new FareFamily();
		fareFamily.setFareFamilyCode(fareFamilyCode);
		fareFamily.setAncillaryAirComponents(components);
		
		return fareFamily;
	}
	
	private List<AncillaryAirComponent> buildAncillaryAirComponents(NodeList ancillaryAirComponentsNodeList) {
		List<AncillaryAirComponent> components = new ArrayList<>();
		
		for (int i = 0; i < ancillaryAirComponentsNodeList.getLength(); i++) {
			Element ancillaryAirComponentElement = (Element) ancillaryAirComponentsNodeList.item(i);
			AncillaryAirComponent component = buildAncillaryAirComponent(ancillaryAirComponentElement);
			components.add(component);
		}
		return components;
	}
	
	private AncillaryAirComponent buildAncillaryAirComponent(Element ancillaryAirComponentElement) {
		String ancillaryAirComponentCode = ancillaryAirComponentElement.getAttribute("AncillaryAirComponentCode");
		
		return new AncillaryAirComponent(ancillaryAirComponentCode);
	}
}
