import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaEmpleados {

    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", "M", 2952670));
        empleados.add(new Empleado(2, "Teresa Nicolás", "Otaño", "F", 2338617));
        empleados.add(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", "F", 2355228));
        empleados.add(new Empleado(4, "Ivellisse", "Estévez Ventura", "M", 1801728));
        empleados.add(new Empleado(5, "Margarita", "Núñez de la Cruz", "F", 3124269));
        empleados.add(new Empleado(6, "Belkis Josefina", "Hernández", "F", 2975450));
        empleados.add(new Empleado(7, "Ruth", "Ortega", "F", 2306902));
        empleados.add(new Empleado(8, "Lourdes", "Florentino de la Cruz", "F", 2583729));
        empleados.add(new Empleado(9, "Luisa", "Mejía", "F", 2160378));
        empleados.add(new Empleado(10, "Cándido", "Mercedes Vargas", "M", 1961114));

        // Ordenar la lista por salario
        Collections.sort(empleados, Comparator.comparingDouble(Empleado::getSalario));

        System.out.println("LISTA ORDENADA POR SALARIO:\n");
        for (Empleado e : empleados) {
            System.out.println(e);
        }

        // ---------------- BÚSQUEDA LINEAL ----------------
        System.out.println("\nBÚSQUEDA LINEAL:");
        double salarioBuscado = 2583729;

        Empleado resultadoLineal = busquedaLineal(empleados, salarioBuscado);

        if (resultadoLineal != null) {
            System.out.println("Empleado encontrado: " + resultadoLineal);
        } else {
            System.out.println("Empleado no encontrado.");
        }

        // ---------------- BÚSQUEDA BINARIA ----------------
        System.out.println("\nBÚSQUEDA BINARIA:");
        int indice = busquedaBinaria(empleados, salarioBuscado);

        if (indice >= 0) {
            System.out.println("Empleado encontrado: " + empleados.get(indice));
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Método de búsqueda lineal
    public static Empleado busquedaLineal(ArrayList<Empleado> lista, double salarioBuscado) {
        for (Empleado e : lista) {
            if (e.getSalario() == salarioBuscado) {
                return e;
            }
        }
        return null;
    }

    // Método de búsqueda binaria (la lista debe estar ordenada)
    public static int busquedaBinaria(ArrayList<Empleado> lista, double salarioBuscado) {
        return Collections.binarySearch(
            lista,
            new Empleado(0, "", "", "", salarioBuscado),
            Comparator.comparingDouble(Empleado::getSalario)
        );
    }
}
