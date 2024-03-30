package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    public final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: "+pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //regresa el indice de la pelicula econtrada
        int indice = peliculas.indexOf(pelicula);

        if(indice == -1)
            System.out.println("No se encontro la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: "+indice);
    }

    public static void main(String[] args) {
        //creamos obj de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        //creamos el servicio (patron de diseño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        //agregamos las peliculas
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //listamos
        servicioPeliculas.listarPeliculas();

        //buscamos
        //se debe implementar el metodo equals y hashCode
        servicioPeliculas.buscarPelicula(new Pelicula("casaMia"));
    }
}
