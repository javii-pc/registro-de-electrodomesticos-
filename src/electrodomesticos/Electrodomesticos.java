package electrodomesticos;

import java.util.Scanner;

public class Electrodomesticos {

    public static void main(String[] args)  
        electrodomestico datos[] = new electrodomestico[15]
    
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (op != 5) {
            System.out.println("-----------MENU-------------");
            System.out.println("1. Nuevo electrodomestico");
            System.out.println("2. Buscar electrodomestico ");
            System.out.println("3. Ver electrodomesticos guardados");
            System.out.println("4. Modificar datos del electrodomestico");
            System.out.println("5. Salir");
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese el numero de opcion ");

            op = teclado.nextInt();
           
            if (op == 1) {
                System.out.println("-------------------------------");
                System.out.println("Ingrese el codigo");
                int codigo = teclado.nextInt();
                System.out.println("-------------------------------");
                System.out.println("Ingrese el tipo de electrodomestico ");
                String nombre = letras.nextLine();
                System.out.println("-------------------------------");
                System.out.println("Ingrese la marca");
                String marca = letras.nextLine();
                System.out.println("-------------------------------");
                System.out.println(nuevoElectrodomestico(codigo, nombre, marca, datos));
             
            } else if (op == 2) {
                System.out.println("------------------------");
                System.out.println("Ingrese el codigo ");
                int codigo = teclado.nextInt();
                System.out.println(buscarelectrodomestico(codigo, datos));
            } else if (op == 3) {
                System.out.println("--------------------------");
                System.out.println(imprimirtodo(datos));
            } else if (op == 4) {
                System.out.println("----------------------------");
                System.out.println("Ingrese el codigo ");
                int codigo = teclado.nextInt();
                if (buscarelectrodomestico2(codigo, datos)) {
                    System.out.println("Ingrese el nuevo nombre ");
                    String nombre = letras.nextLine();
                    System.out.println("-------------------------------");
                    System.out.println("Ingrese la nueva marca");
                    String marca = letras.nextLine();
                    System.out.println("--------------------------------");
                    System.out.println(modificardatos(codigo,nombre,marca,datos));
                    

                } else {
                    System.out.println("el codigo no existe ");
                }

            }
        }

    }

  
    public static String nuevoElectrodomestico(int codigo, String nombre, String marca, electrodomestico arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new electrodomestico(codigo, nombre, marca);
                lleno = false;
                break;
            } else if (arreglo[i].getCodigo() == codigo) {
                return "el codigo ya existe";
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
            return "ERROR!! Ya no queda espacio";
        }

    }

    
    public static String buscarelectrodomestico(int codigo, electrodomestico arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return "Los datos son \n nombre: " + arreglo[i].getNombre() + "\n" + "La Marca: " + arreglo[i].getMarca();
            }
        }
        return "el codigo es inexistente";
    }

    public static boolean buscarelectrodomestico2(int codigo, electrodomestico arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public static String imprimirtodo(electrodomestico arreglo[]) {
        String cadena = " ";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getCodigo() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getMarca() + "\n";
            }
        }
        return cadena;
    }

    
    public static String modificardatos(int codigo, String nombre, String marca,electrodomestico arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getCodigo() == codigo) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setMarca(marca);
                return "se actualizo con exito" ;
            }
        }
        return "";
    }
}
