package partidos.modelo;


public class Partido {
    private String fechaPartido;
    private String equipoRival;
    private int golesEquipoRival;
    private int golesUniverdidad;

    public Partido(String fechaPartido, String equipoRival, int golesEquipoRival, int golesUniverdidad) {
        this.fechaPartido = fechaPartido;
        this.equipoRival = equipoRival;
        this.golesEquipoRival = golesEquipoRival;
        this.golesUniverdidad = golesUniverdidad;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getEquipoRival() {
        return equipoRival;
    }

    public void setEquipoRival(String equipoRival) {
        this.equipoRival = equipoRival;
    }

    public int getGolesEquipoRival() {
        return golesEquipoRival;
    }

    public void setGolesEquipoRival(int golesEquipoRival) {
        this.golesEquipoRival = golesEquipoRival;
    }

    public int getGolesUniverdidad() {
        return golesUniverdidad;
    }

    public void setGolesUniverdidad(int golesUniverdidad) {
        this.golesUniverdidad = golesUniverdidad;
    }

    @Override
    public String toString() {
        return fechaPartido + "- UNI (" + golesUniverdidad + ") VS (" + golesEquipoRival +") " + equipoRival  ;
    }

}
