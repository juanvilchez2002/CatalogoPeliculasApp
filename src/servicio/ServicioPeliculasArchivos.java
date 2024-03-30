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
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);

        try{
            //revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));

            //agregamos pelicula con el metodo println
            salida.println(pelicula);
            salida.close();

            System.out.println("Se agrego al archivo: "+ pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula: "+e.getMessage());
        }

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        var archivo = new File(NOMBRE_ARCHIVO);

        try{
            //abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto!=null){
                //buscamos sin importar mayusculas ni minusculas
                if(peliculaBuscar!= null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //leemos la sgte linea antes de la sgte interaccion
                lineaTexto = entrada.readLine();
                indice++;
            }

            //imprimimos los resultados de la busqueda
            if(encontrada){
                System.out.println("Pelicua "+lineaTexto+" encontrada - linea "+indice);
            }else {
                System.out.println("No se encontro la pelicula: "+pelicula.getNombre());
            }

            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar en el archivo la pelicula: "+e.getMessage());
        }
    }
}
