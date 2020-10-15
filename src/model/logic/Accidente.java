package model.logic;

import java.util.Date;

public class Accidente {

    Date fechaInicio;
    int severidad;


    public Accidente(Date fechaIn, int severity)
    {
        fechaInicio = fechaIn;
        severidad = severity;
    }

    public Date darFechaInicio() {
        return fechaInicio;
    }

    public int darSeverity() {
        return severidad;
    }
}
