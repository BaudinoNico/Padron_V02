public class Docente extends Empleado {
    String titulo,materia;
    double horas,costoH;

    public Docente(int dni, String nombre, String apellido, String direccion, String institucion, String titulo, String materia, double horas, double costoh) {
        super(dni, nombre, apellido, direccion, institucion);
        this.titulo = titulo;
        this.materia = materia;
        this.horas = horas;
        this.costoH = costoh;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getCostoH() {
        return costoH;
    }

    public void setCostoh(double costoh) {
        this.costoH = costoh;
    }

    @Override
    public String toString() {
        return super.toString() +
                "titulo='" + titulo + '\n' +
                "materia='" + materia + '\n' +
                "horas=" + horas + '\n' +
                "costoh=" + costoH + '\n';
    }
}
