package mx.com.itam.adsi.ejercicio; 
 
import org.apache.log4j.Logger; 
 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 

/**
  *Clase CuentaLineas
  *
  *Contiene el número de líneas del archivo especificado
  *@author Mónica E. Alba Glez. 160502
*/ 
public class CuentaLineas{ 
  private final static Logger LOG = Logger.getLogger(CuentaLineas.class);
  /**
    *Dirección ruta del archivo
  */ 
  private static String nom;
  /**
    *Número total de líneas del archivo
  */ 
  public int numLineas;
  /**
    *Número total del comentarios del archivo
  */ 
  public int numComent;
  /**
    *Número total de líneas codificables del archivo
  */ 
  public int numCode;
  /**
    *Número de líneas dentro de los comentarios de bloque
  */ 
  public int dentroComent; 

  /**
    *Constructor que inicializa los parámetros del total de líneas en 0.
  */ 
  CuentaLineas(){ 
    numLineas = 0; 
    numCode = 0; 
    numComent = 0; 
    dentroComent = 0;     
  } 

  /**
    *Constructor que inicializa los parámetros del total de líneas en 0.
    *@param i número de archivo que se desea contar
  */ 
  CuentaLineas(int i){ 
    switch(i){ 
      case 1: 
        nom = System.getProperty("user.dir") + "\\art1.txt"; 
        break; 
      case 2: 
        nom = System.getProperty("user.dir") + "\\art2.txt"; 
        break; 
      case 3: 
        nom = System.getProperty("user.dir") + "\\art3.txt"; 
        break; 
      case 4: 
        nom = System.getProperty("user.dir") + "\\art4.txt"; 
        break; 
      case 5: 
        nom = System.getProperty("user.dir") + "\\art5.txt"; 
        break; 
    } 
    numLineas = 0; 
    numCode = 0; 
    numComent = 0; 
    dentroComent = 0; 
  } 

  /**
    *El main manda a llamar el método cuentaL para el archivo número 5.
    *No necesita parámetros.
    *No regresa nada, pero manda al LOG los resultados obtenidos.
  */ 
  public static void main(String...argv) { 
    int numArch = 5; 
    CuentaLineas p = new CuentaLineas(numArch); 
    p.cuentaL(nom); 
    LOG.info("Cuenta lineas del archivo 5"); 
    LOG.info("Lineas: "+p.numLineas); 
    LOG.info("Comentarios: "+p.numComent); 
    LOG.info("Codigo: "+p.numCode); 
  } 
  
  /**
    *Cuenta las líneas totales del código, las que son codificables y las que son de comentarios.
    *Modifica los atributos de la clase con los resultados de la cuenta.
    *@param nombreArchivo el nombre del archivo del que se quiere contar las líneas.
    *
  */ 
  public void cuentaL(String nombreArchivo){
    LOG.info("Cuenta lineas del archivo "+nombreArchivo);
      BufferedReader buffer = null;
      FileReader file = null;

      try {

        //buffer = new BufferedReader(new FileReader(FILENAME));
        file = new FileReader(nombreArchivo);
        buffer = new BufferedReader(file);

        String linea = "";

        while ((linea = buffer.readLine()) != null) {
          
          int l;
          l = linea.length();
          if(l != 0){ //Verifica la longitud de la línea para no contar las que están en blanco
        LOG.info("Cuenta lineas que no está vacía");
            numLineas++;
            if(linea.contains("/*")){
          LOG.info("Cuenta lineas que están en bloque de comentarios");
              numComent++;;
              if(linea.trim().indexOf("/")!=0){
                numCode++;
              }
              

              while(!linea.contains("*/")){
                //cuenta las líneas que están dentro del bloque de comentarios sin que se cuente la útlima línea, que se contó anteriormente. Es decir, se cuenta desde la primera (/**) hasta la línea antes del cierre(*/)
                dentroComent++;
                linea = buffer.readLine();
              }
              numLineas+=dentroComent;
              numComent+=dentroComent;
              dentroComent=0;
            }else{
              if(linea.contains("//")){
                if(!linea.contains("\"//\"")){    //Esto no es un comentario
                
                  LOG.info("Cuenta comentario normal");
                  numComent++;
                  
                  if(linea.trim().indexOf("/")!=0){ //este if verifica si hay comentarios en una misma línea de código
                    numCode++; 
                  }
                }   
              }else{
                LOG.info("Cuenta lineas de código sin comentarios");
                numCode++;
              }
            }  
          }
          
        }

      } catch (IOException e) {

        System.out.println(e);

      } finally {

      try {

        if (buffer != null)
          buffer.close();

        if (file != null)
          file.close();

      } catch (IOException ex) {

        System.out.println(ex);

      }

    }

  } 
}
