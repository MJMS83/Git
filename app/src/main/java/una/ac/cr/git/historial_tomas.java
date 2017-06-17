package una.ac.cr.git;

/**
 * Created by josue on 17/06/17.
 */

public class historial_tomas {
    String condicion;
    Integer diastolica;
    Integer sistolica;

    public historial_tomas(String condicion, Integer diastolica, Integer sistolica) {
        this.condicion = condicion;
        this.diastolica = diastolica;
        this.sistolica = sistolica;
    }

    public historial_tomas() {
    }

    public String getCondicion() {return condicion; }
    public void setCondicion(String condicion){this.condicion = condicion; }
    public Integer getDiastolica() {return diastolica;}
    public void setDiastolica(Integer diastolica){this.diastolica = diastolica;}
    public Integer getSistolica(){return sistolica;}
    public void setSistolica(Integer sistolica) {this.sistolica = sistolica;}
}
