package mx.com.itam.adsi.ejercicio;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestCuentaLineas {
    private final static Logger LOG = Logger.getLogger(TestCuentaLineas.class);
    
    

    private static String direc = "";
    

    private CuentaLineas p = new CuentaLineas();


    @Test
    public void correArchivo1() {
        direc = System.getProperty("user.dir")+"/art1.txt"; 
        LOG.info("Ejecutando la prueba 1");
        p.cuentaL(direc);
	System.out.println(p.numLineas);
	System.out.println(p.numComent);
	System.out.println(p.numCode);
        assertTrue("Calculo para archivo 1:", calc(6,0,6,p.numLineas,p.numComent,p.numCode));
    }
    
    @Test
    public void correArchivo2() {
        direc = System.getProperty("user.dir")+"/art2.txt"; 
        LOG.info("Ejecutando la prueba 2");
        p.cuentaL(direc);
	System.out.println(p.numLineas);
	System.out.println(p.numComent);
	System.out.println(p.numCode);
        assertTrue("Calculo para archivo 2:", calc(7,2,6,p.numLineas,p.numComent,p.numCode));
    }

    @Test
    public void correArchivo3() {
        direc = System.getProperty("user.dir")+"/art3.txt"; 
        LOG.info("Ejecutando la prueba 3");
        p.cuentaL(direc);
        assertTrue("Calculo para archivo 3:", calc(12,7,6,p.numLineas,p.numComent,p.numCode));
    }

    @Test
    public void correArchivo4() {
        direc = System.getProperty("user.dir")+"/art4.txt"; 
        LOG.info("Ejecutando la prueba 4");
        p.cuentaL(direc);
	System.out.println(p.numLineas);
	System.out.println(p.numComent);
	System.out.println(p.numCode);
        assertTrue("Calculo para archivo 4:", calc(13,8,6,p.numLineas,p.numComent,p.numCode));
    }

    @Test
    public void correArchivo5() {
        direc = System.getProperty("user.dir")+"/art5.txt";
        LOG.info("Ejecutando la prueba 5");
        p.cuentaL(direc);
	System.out.println(p.numLineas);
	System.out.println(p.numComent);
	System.out.println(p.numCode);
        assertTrue("Calculo para archivo 5:", calc(11,6,6,p.numLineas,p.numComent,p.numCode));
    }

    @Test
    public void correArchivoExtremo() {
        direc = System.getProperty("user.dir")+"/art6.txt";
        LOG.info("Ejecutando la prueba extrema");
        p.cuentaL(direc);
	System.out.println(p.numLineas);
	System.out.println(p.numComent);
	System.out.println(p.numCode);
        assertTrue("Calculo para archivo 5:", calc(11,6,6,p.numLineas,p.numComent,p.numCode));
    }

    private boolean calc(int nL, int nCom, int nCode, int v1, int v2, int v3) {
        
        if(nL == v1 && nCom == v2 && nCode == v3){
            return true;
        }else{
            return false;
        }
    }

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
