package una.ac.cr.git;

/**
 * Created by josue on 24/06/17.
 */

public class Perfil_Usuario {
    private  String nombre;
    private String  edad;
    private  String peso;
    private String altura;
    private String  sexo;
    private String clave;

    public Perfil_Usuario(String nombre, String edad, String peso, String altura, String sexo, String clave) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.clave = clave;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre; }

    public String getEdad() {return edad;}

    public void setEdad(String edad) {this.edad = edad;}

    public String getPeso() {return peso;}

    public void setPeso(String peso) {this.peso = peso;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getClave() {return clave;}

    public void setClave(String clave) {this.clave = clave; }

    public String getAltura() { return altura; }

    public void setAltura(String altura) {this.altura = altura;}
}
