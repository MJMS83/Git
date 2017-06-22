package una.ac.cr.git;

/**
 * Created by WILLIAM on 19/06/2017.
 */

public class TomaPresion {

    private String sistolica;
    private String diastolica;
    private String fechaToma;
    private String condicion;
    private String NombreDeUsuario;
    public TomaPresion() {
    }

    public TomaPresion(String sistolica, String diastolica, String condicion, String fechaToma
    ,String NombreDeUsuario) {
        this.sistolica = sistolica;
        this.diastolica = diastolica;
        this.condicion = condicion;
        this.fechaToma = fechaToma;
        this.NombreDeUsuario=NombreDeUsuario;
    }

    public TomaPresion(String sistolica, String diastolica, String condicion) {
        this.sistolica = sistolica;
        this.diastolica = diastolica;
        this.condicion = condicion;
    }

    public TomaPresion(String sistolica, String diastolica, String fechaToma, String condicion) {
        this.sistolica = sistolica;
        this.diastolica = diastolica;
        this.fechaToma = fechaToma;
        this.condicion = condicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {this.condicion = condicion;
    }

    public String getSistolica() {
        return sistolica;
    }

    public void setSistolica(String sistolica) {
        this.sistolica = sistolica;
    }

    public String getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(String diastolica) {
        this.diastolica = diastolica;
    }

    public String getFechaToma() {
        return fechaToma;
    }

    public void setFechaToma(String fechaToma) {
        this.fechaToma = fechaToma;
    }

    public String getNombreDeUsuario() { return NombreDeUsuario;}

    public void setNombreDeUsuario(String nombreDeUsuario) {NombreDeUsuario = nombreDeUsuario;}
}
