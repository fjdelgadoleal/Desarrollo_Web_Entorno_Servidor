/**
 * 
 */
package es.iessoterohernandez.daw.dwes.nominas.laboral;

/**
 * @author fjdl
 *
 */
public class Nomina {
	private static final int[] SUELDO_BASE = 
		{50000, 70000, 90000, 110000, 130000, 
				150000, 170000, 190000, 210000, 230000};

	public static int[] getSueldoBase() {
		return SUELDO_BASE;
	}


}
