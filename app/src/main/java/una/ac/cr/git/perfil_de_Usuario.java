package una.ac.cr.git;

/**
 * Created by josue on 09/06/17.
 */

public class perfil_de_Usuario {
    //Atributos de la clase
    String nombre,apellido,correo,contrasena;
    Integer edad;
    Float peso,altura;
    String sexo;
    //Contructor sin parametros

    public perfil_de_Usuario() {
    }

    //Constructor con parametros
    public perfil_de_Usuario(String nombre, String apellido, String correo,
                             String contrasena, Integer edad, Float peso,
                             Float altura, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }
    //Metodos get y set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public Float getAltura() {
        return altura;
    }
    public void setAltura(Float altura) {
        this.altura = altura;
    }
    public String getSexo() {return sexo;}
    public void setSexo(String sexo){this.sexo = sexo;}
}

