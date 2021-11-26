public abstract class Empleado{
    private int dni;
    private String nombre,apellido,direccion,institucion;

    public Empleado(int dni, String nombre, String apellido, String direccion, String institucion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.institucion = institucion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return  "- DNI = " + dni + '\n' +
                "- Nombre = " + nombre + '\n' +
                "- Apellido = " + apellido + '\n' +
                "- Direccion = " + direccion + '\n' +
                "- Institucion = " + institucion + '\n';
    }

    public String campos() {
        return  "1- DNI\n" +
                "2- Nombre\n" +
                "3- Apellido\n" +
                "4- Direccion\n" +
                "5- Institucion\n";
    }
}
