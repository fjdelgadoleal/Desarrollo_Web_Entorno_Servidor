package es.iessoterohernandez.daw.dwes.nominas;

import es.iessoterohernandez.daw.dwes.nominas.laboral.*;

/**
 * Hello Nóminas!
 *
 */
public class CalculaNominas 
{
    public static void main( String[] args )
    {
        try {
        	//cambio el dni del enunciado de ambos empleados por uno correcto porque estoy hacendo la validación del mismo
	    	Empleado e1=new Empleado("James Coslng","48811600B",'M',4,7); 
	        Empleado e2=new Empleado("Ada Lovelace", "48814047C", 'F');
	        escribe(e1, e2);
	        
	        e2.anyos++;
	        e1.setCategoria(9);
	        escribe(e1, e2);
        }catch (DatosNoCorrectosException e) {
        	System.out.println(e.getMessage());
        }
    }
    
    private static void escribe(Empleado e1, Empleado e2) {
    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
    	System.out.println(e2.imprime() + " - Sueldo="+ Nomina.sueldo(e2));
    }
}
