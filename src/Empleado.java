public abstract class Empleado {
    private int dni;
    private String nombre,apellido,direccion,institucion,puesto;

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
        return  "dni=" + dni + '\n' +
                "nombre='" + nombre + '\n' +
                "apellido='" + apellido + '\n' +
                "direccion='" + direccion + '\n' +
                "institucion='" + institucion + '\n';
    }
}
