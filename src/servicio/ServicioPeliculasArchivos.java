package servicio;

import dominio.Pelicula;

import java.io.*;

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
        //volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Peliculas");
            //abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));

            //leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //leemos todas las lineas disponibles
            while (linea!=null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //antes de leer el ciclo se vuelve a leer la sgte linea
                linea = entrada.readLine();
            }

            //cerramos el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo: "+e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
