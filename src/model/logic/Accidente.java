package model.logic;

import java.util.Date;

public class Accidente implements Comparable <Accidente>
{
	
	String ID;
	
	String Source;
	
	String TMC;
	
	double Severity;
	
	Date Start_Time;
	
	Date End_Time;
	
	double Start_Lat;
	
	double Start_Lng;
	
	String End_Lat;
	
	String End_Lng;
	
	String Distance_mi;
	
	String Description;
	
	String number;
	
	String street;
	
	String side;
	
	String city;
	
	String county;
	
	String state;
	
	String zipcode;
	
	String country;
	


	String timeZone;
	
	String airportCode;
	
	String weather_Timestamp;
	
	String temperaturaF;
	
	String windChillF;
	
	String Humidity;
	
	String pressure;
	
	String visibility;
	
	String windDirection;
	
	String windSpeedmph;
	
	String precipitation;
	
	String weatherCondition;
	
	boolean amenity ;
	
	boolean bump;
	
	boolean crossing;
	
	boolean give_way;
	
	boolean junction;
	
	boolean noExit;
	
	boolean railway;
	
	
	boolean roundAbout;
	
	boolean station;
	
	boolean stop;
	
	boolean trafficCalming;
	
	boolean trafficSignal;
	
	boolean turningLoop;
	
	String sunriseSunset;
	
	String civilTwilight;
	
	String nauticalTwilight;
	
	String astronomicalTwilight;
	
	
	public Accidente(String iD, String source, String tMC, double severity, Date start_Time, Date end_Time,
			double start_Lat, double start_Lng, String end_Lat, String end_Lng, String distance_mi, String description,
			String number, String street, String side, String city, String county, String state, String zipcode,
			String country, String timeZone, String airportCode, String weather_Timestamp, String temperaturaF,
			String windChillF, String humidity, String pressure, String visibility, String windDirection,
			String windSpeedmph, String precipitation, String weatherCondition, boolean amenity, boolean bump,
			boolean crossing, boolean give_way, boolean junction, boolean noExit, boolean railway, boolean roundAbout,
			boolean station, boolean stop, boolean trafficCalming, boolean trafficSignal, boolean turningLoop,
			String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight ) {
		super();
		ID = iD;
		Source = source;
		TMC = tMC;
		Severity = severity;
		Start_Time = start_Time;
		End_Time = end_Time;
		Start_Lat = start_Lat;
		Start_Lng = start_Lng;
		End_Lat = end_Lat;
		End_Lng = end_Lng;
		Distance_mi = distance_mi;
		Description = description;
		this.number = number;
		this.street = street;
		this.side = side;
		this.city = city;
		this.county = county;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.timeZone = timeZone;
		this.airportCode = airportCode;
		this.weather_Timestamp = weather_Timestamp;
		this.temperaturaF = temperaturaF;
		this.windChillF = windChillF;
		Humidity = humidity;
		this.pressure = pressure;
		this.visibility = visibility;
		this.windDirection = windDirection;
		this.windSpeedmph = windSpeedmph;
		this.precipitation = precipitation;
		this.weatherCondition = weatherCondition;
		this.amenity = amenity;
		this.bump = bump;
		this.crossing = crossing;
		this.give_way = give_way;
		this.junction = junction;
		this.noExit = noExit;
		this.railway = railway;
		this.roundAbout = roundAbout;
		this.station = station;
		this.stop = stop;
		this.trafficCalming = trafficCalming;
		this.trafficSignal = trafficSignal;
		this.turningLoop = turningLoop;
		this.sunriseSunset = sunriseSunset;
		this.civilTwilight = civilTwilight;
		this.nauticalTwilight = nauticalTwilight;
		this.astronomicalTwilight = astronomicalTwilight;
//		this.fechaInicio = fechaInicio;
//		this.severidad = severidad;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getSource() {
		return Source;
	}


	public void setSource(String source) {
		Source = source;
	}


	public String getTMC() {
		return TMC;
	}


	public void setTMC(String tMC) {
		TMC = tMC;
	}


	public double getSeverity() {
		return Severity;
	}


	public void setSeverity(double severity) {
		Severity = severity;
	}


	public Date getStart_Time() {
		return Start_Time;
	}


	public void setStart_Time(Date start_Time) {
		Start_Time = start_Time;
	}


	public Date getEnd_Time() {
		return End_Time;
	}


	public void setEnd_Time(Date end_Time) {
		End_Time = end_Time;
	}


	public double getStart_Lat() {
		return Start_Lat;
	}


	public void setStart_Lat(double start_Lat) {
		Start_Lat = start_Lat;
	}


	public double getStart_Lng() {
		return Start_Lng;
	}


	public void setStart_Lng(double start_Lng) {
		Start_Lng = start_Lng;
	}


	public String getEnd_Lat() {
		return End_Lat;
	}


	public void setEnd_Lat(String end_Lat) {
		End_Lat = end_Lat;
	}


	public String getEnd_Lng() {
		return End_Lng;
	}


	public void setEnd_Lng(String end_Lng) {
		End_Lng = end_Lng;
	}


	public String getDistance_mi() {
		return Distance_mi;
	}


	public void setDistance_mi(String distance_mi) {
		Distance_mi = distance_mi;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getTimeZone() {
		return timeZone;
	}


	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	public String getAirportCode() {
		return airportCode;
	}


	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}


	public String getWeather_Timestamp() {
		return weather_Timestamp;
	}


	public void setWeather_Timestamp(String weather_Timestamp) {
		this.weather_Timestamp = weather_Timestamp;
	}


	public String getTemperaturaF() {
		return temperaturaF;
	}


	public void setTemperaturaF(String temperaturaF) {
		this.temperaturaF = temperaturaF;
	}


	public String getWindChillF() {
		return windChillF;
	}


	public void setWindChillF(String windChillF) {
		this.windChillF = windChillF;
	}


	public String getHumidity() {
		return Humidity;
	}


	public void setHumidity(String humidity) {
		Humidity = humidity;
	}


	public String getPressure() {
		return pressure;
	}


	public void setPressure(String pressure) {
		this.pressure = pressure;
	}


	public String getVisibility() {
		return visibility;
	}


	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}


	public String getWindDirection() {
		return windDirection;
	}


	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}


	public String getWindSpeedmph() {
		return windSpeedmph;
	}


	public void setWindSpeedmph(String windSpeedmph) {
		this.windSpeedmph = windSpeedmph;
	}


	public String getPrecipitation() {
		return precipitation;
	}


	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}


	public String getWeatherCondition() {
		return weatherCondition;
	}


	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}


	public boolean isAmenity() {
		return amenity;
	}


	public void setAmenity(boolean amenity) {
		this.amenity = amenity;
	}


	public boolean isBump() {
		return bump;
	}


	public void setBump(boolean bump) {
		this.bump = bump;
	}


	public boolean isCrossing() {
		return crossing;
	}


	public void setCrossing(boolean crossing) {
		this.crossing = crossing;
	}


	public boolean isGive_way() {
		return give_way;
	}


	public void setGive_way(boolean give_way) {
		this.give_way = give_way;
	}


	public boolean isJunction() {
		return junction;
	}


	public void setJunction(boolean junction) {
		this.junction = junction;
	}


	public boolean isNoExit() {
		return noExit;
	}


	public void setNoExit(boolean noExit) {
		this.noExit = noExit;
	}


	public boolean isRailway() {
		return railway;
	}


	public void setRailway(boolean railway) {
		this.railway = railway;
	}


	public boolean isRoundAbout() {
		return roundAbout;
	}


	public void setRoundAbout(boolean roundAbout) {
		this.roundAbout = roundAbout;
	}


	public boolean isStation() {
		return station;
	}


	public void setStation(boolean station) {
		this.station = station;
	}


	public boolean isStop() {
		return stop;
	}


	public void setStop(boolean stop) {
		this.stop = stop;
	}


	public boolean isTrafficCalming() {
		return trafficCalming;
	}


	public void setTrafficCalming(boolean trafficCalming) {
		this.trafficCalming = trafficCalming;
	}


	public boolean isTrafficSignal() {
		return trafficSignal;
	}


	public void setTrafficSignal(boolean trafficSignal) {
		this.trafficSignal = trafficSignal;
	}


	public boolean isTurningLoop() {
		return turningLoop;
	}


	public void setTurningLoop(boolean turningLoop) {
		this.turningLoop = turningLoop;
	}


	public String getSunriseSunset() {
		return sunriseSunset;
	}


	public void setSunriseSunset(String sunriseSunset) {
		this.sunriseSunset = sunriseSunset;
	}


	public String getCivilTwilight() {
		return civilTwilight;
	}


	public void setCivilTwilight(String civilTwilight) {
		this.civilTwilight = civilTwilight;
	}


	public String getNauticalTwilight() {
		return nauticalTwilight;
	}


	public void setNauticalTwilight(String nauticalTwilight) {
		this.nauticalTwilight = nauticalTwilight;
	}


	public String getAstronomicalTwilight() {
		return astronomicalTwilight;
	}


	public void setAstronomicalTwilight(String astronomicalTwilight) {
		this.astronomicalTwilight = astronomicalTwilight;
	}


	@Override
	public int compareTo(Accidente o) 
	{
		int comparador = 1;
        if(Severity==o.getSeverity()) 
        {
            comparador = 0;
        }else if(Severity<o.getSeverity()) 
        {
            comparador = -1;
        }
        return comparador;

	}
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	Date fechaInicio;
//    
//	
//	
//	
//	int severidad;
//
//
//    public Accidente(Date fechaIn, int severity)
//    {
//        fechaInicio = fechaIn;
//        severidad = severity;
//    }
//
//    public Date darFechaInicio() {
//        return fechaInicio;
//    }
//
//    public int darSeverity() {
//        return severidad;
//    }
}
