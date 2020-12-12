package model.logic;

import java.awt.Point;
import java.util.Date;

public class Taxis implements Comparable<Taxis>{
	
	String TripID;
	
	String TaxiID;
	
	String TripStartTimestamp;
	
	String TripEndTimestamp;
	
	String TripSeconds;
	
	String TripMiles;
	
	String PickupCensusTract;
	
	String DropoffCensusTract;
	
	String PickupCommunityArea;
	
	String DropoffCommunityArea;
	
	String Fare;
	
	String Tips;
	
	String Tolls;
	
	String Extras;
	
	String TripTotal;
	
	String PaymentType;
	
	String Company;
	
	String PickupCentroidLatitude;
	
	String PickupCentroidLongitude;
	
	String PickupCentroidLocation;
	
	String DropoffCentroidLatitude;
	
	String DropoffCentroidLongitude;
	
	String DropoffCentroidLocation;
	
	int numero = 0;
	
	
	public Taxis(String tripID, String taxiID, String tripStartTimestamp, String tripEndTimestamp, String tripSeconds,
			String tripMiles, String pickupCensusTract, String dropoffCensusTract, String pickupCommunityArea,
			String dropoffCommunityArea, String fare, String tips, String tolls, String extras, String tripTotal,
			String paymentType, String company, String pickupCentroidLatitude, String pickupCentroidLongitude,
			String pickupCentroidLocation, String dropoffCentroidLatitude, String dropoffCentroidLongitude,
			String dropoffCentroidLocation, int pNumero)
	{
		 
		
		TripID = tripID;
		
		TaxiID = taxiID;
		
		TripStartTimestamp = tripStartTimestamp;
		
		TripEndTimestamp = tripEndTimestamp;
		
		TripSeconds = tripSeconds;
		
		TripMiles = tripMiles;
		
		PickupCensusTract = pickupCensusTract;
		
		DropoffCensusTract = dropoffCensusTract;
		
		PickupCommunityArea = pickupCommunityArea;
		
		DropoffCommunityArea = dropoffCommunityArea;
		
		Fare = fare;
		
		Tips = tips;
		
		Tolls = tolls;
		
		Extras = extras;
		
		TripTotal = tripTotal;
		
		PaymentType = paymentType;
		
		Company = company;
		
		PickupCentroidLatitude = pickupCentroidLatitude;
		
		PickupCentroidLongitude = pickupCentroidLongitude;
		
		PickupCentroidLocation = pickupCentroidLocation;
		
		DropoffCentroidLatitude = dropoffCentroidLatitude;
		
		DropoffCentroidLongitude = dropoffCentroidLongitude;
		
		DropoffCentroidLocation = dropoffCentroidLocation;
		numero = pNumero;
	}	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int pNumero) {
		numero = pNumero;
	}

	public String getTripID() {
		return TripID;
	}


	public void setTripID(String tripID) {
		TripID = tripID;
	}


	public String getTaxiID() {
		return TaxiID;
	}


	public void setTaxiID(String taxiID) {
		TaxiID = taxiID;
	}


	public String getTripStartTimestamp() {
		return TripStartTimestamp;
	}


	public void setTripStartTimestamp(String tripStartTimestamp) {
		TripStartTimestamp = tripStartTimestamp;
	}


	public String getTripEndTimestamp() {
		return TripEndTimestamp;
	}


	public void setTripEndTimestamp(String tripEndTimestamp) {
		TripEndTimestamp = tripEndTimestamp;
	}


	public String getTripSeconds() {
		return TripSeconds;
	}


	public void setTripSeconds(String tripSeconds) {
		TripSeconds = tripSeconds;
	}


	public String getTripMiles() {
		return TripMiles;
	}


	public void setTripMiles(String tripMiles) {
		TripMiles = tripMiles;
	}


	public String getPickupCensusTract() {
		return PickupCensusTract;
	}


	public void setPickupCensusTract(String pickupCensusTract) {
		PickupCensusTract = pickupCensusTract;
	}


	public String getDropoffCensusTract() {
		return DropoffCensusTract;
	}


	public void setDropoffCensusTract(String dropoffCensusTract) {
		DropoffCensusTract = dropoffCensusTract;
	}


	public String getPickupCommunityArea() {
		return PickupCommunityArea;
	}


	public void setPickupCommunityArea(String pickupCommunityArea) {
		PickupCommunityArea = pickupCommunityArea;
	}


	public String getDropoffCommunityArea() {
		return DropoffCommunityArea;
	}


	public void setDropoffCommunityArea(String dropoffCommunityArea) {
		DropoffCommunityArea = dropoffCommunityArea;
	}


	public String getFare() {
		return Fare;
	}


	public void setFare(String fare) {
		Fare = fare;
	}


	public String getTips() {
		return Tips;
	}


	public void setTips(String tips) {
		Tips = tips;
	}


	public String getTolls() {
		return Tolls;
	}


	public void setTolls(String tolls) {
		Tolls = tolls;
	}


	public String getExtras() {
		return Extras;
	}


	public void setExtras(String extras) {
		Extras = extras;
	}


	public String getTripTotal() {
		return TripTotal;
	}


	public void setTripTotal(String tripTotal) {
		TripTotal = tripTotal;
	}


	public String getPaymentType() {
		return PaymentType;
	}


	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}


	public String getCompany() {
		return Company;
	}


	public void setCompany(String company) {
		Company = company;
	}


	public String getPickupCentroidLatitude() {
		return PickupCentroidLatitude;
	}


	public void setPickupCentroidLatitude(String pickupCentroidLatitude) {
		PickupCentroidLatitude = pickupCentroidLatitude;
	}


	public String getPickupCentroidLongitude() {
		return PickupCentroidLongitude;
	}


	public void setPickupCentroidLongitude(String pickupCentroidLongitude) {
		PickupCentroidLongitude = pickupCentroidLongitude;
	}


	public String getPickupCentroidLocation() {
		return PickupCentroidLocation;
	}


	public void setPickupCentroidLocation(String pickupCentroidLocation) {
		PickupCentroidLocation = pickupCentroidLocation;
	}


	public String getDropoffCentroidLatitude() {
		return DropoffCentroidLatitude;
	}


	public void setDropoffCentroidLatitude(String dropoffCentroidLatitude) {
		DropoffCentroidLatitude = dropoffCentroidLatitude;
	}


	public String getDropoffCentroidLongitude() {
		return DropoffCentroidLongitude;
	}


	public void setDropoffCentroidLongitude(String dropoffCentroidLongitude) {
		DropoffCentroidLongitude = dropoffCentroidLongitude;
	}


	public String getDropoffCentroidLocation() {
		return DropoffCentroidLocation;
	}


	public void setDropoffCentroidLocation(String dropoffCentroidLocation) {
		DropoffCentroidLocation = dropoffCentroidLocation;
	}


	@Override
	public int compareTo(Taxis arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
