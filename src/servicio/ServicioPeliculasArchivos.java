package servicio;

import dominio.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivos implements IServicioPeliculas{

    //usaremos un archivo para guardar
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivos() {
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            //si ya existe el archivo no se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //se crea el archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "+e.getMessage());
        }
    }



    @Override
    public void listarPeliculas() {

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
