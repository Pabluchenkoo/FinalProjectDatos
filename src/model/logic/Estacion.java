package model.logic;

public class Estacion implements Comparable<Estacion> {

    private String nombreEstacion;

    private int iDEstacion;

    private double longitud;

    private double latitud;



    public Estacion (String stationName, int stationID, double longitud, double latitud)
    {
        this.nombreEstacion = stationName;
        this.iDEstacion = stationID;
        this.longitud = longitud;
        this.latitud = latitud;
    }


    public String darStationName() {
        return nombreEstacion;
    }

    public int darStationID() {
        return iDEstacion;
    }

    public double darLongitud() {
        return longitud;
    }

    public double darLatitud() {
        return latitud;
    }

    @Override
    public String toString() {
        return "<ID: "+iDEstacion+" Name: "+nombreEstacion+">";
    }

    @Override
    public int compareTo(Estacion o) {
        return 0;
    }

    public boolean equals(Estacion o) {
        return iDEstacion==o.darStationID();
    }




}