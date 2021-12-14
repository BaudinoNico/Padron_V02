import java.io.Serializable;

public class Administrativo extends Empleado implements Serializable {
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
                "- Area = " + area + '\n' +
                "- Salario = " + salario + '\n';
    }

    @Override
    public String campos() {
        return  super.campos() +
                "6- Area\n" +
                "7- Salario\n";
    }
}
