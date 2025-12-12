public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String genero;
    private double salario;

    public Empleado(int id, String nombre, String apellido, String genero, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido +
               " | Género: " + genero +
               " | Salario: $" + salario;
    }
}
