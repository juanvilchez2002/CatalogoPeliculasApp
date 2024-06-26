package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivos;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {

    public static void main(String[] args) {

        var salir = false;
        Scanner consola = new Scanner(System.in);

        //agregamos la implementacion del servicio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivos();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
            System.out.println("");
        }//fin while
    }

    public static void mostrarMenu(){
        System.out.print("""
                **** Catalogo de Peliculas ***
                1. Agregar peliculas
                2. Lisar Peliculas
                3. Buscar Peliculas
                4. Salir
                Eligue una opción:                 
                """);
    }

    public static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas){

        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion){
            case 1:
                System.out.println("Ingrese nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
                break;
            case 2:
                servicioPeliculas.listarPeliculas();
                break;
            case 3:
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
                break;
            case 4:
                System.out.println("Hasta pronto!!!");
                salir = true;
                break;
            default:
                System.out.println("Opción no reconocida: "+opcion);
        }//fin switch
        return salir;
    }
}
