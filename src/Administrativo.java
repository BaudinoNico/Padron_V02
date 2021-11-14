public class Administrativo extends Empleado {
    String area;
    double salario;

    public Administrativo(int dni, String nombre, String apellido, String direccion, String institucion, String area, double salario) {
        super(dni, nombre, apellido, direccion, institucion);
        this.area = area;
        this.salario = salario;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() +
                "area='" + area + '\n' +
                "salario=" + salario + '\n';
    }
}
