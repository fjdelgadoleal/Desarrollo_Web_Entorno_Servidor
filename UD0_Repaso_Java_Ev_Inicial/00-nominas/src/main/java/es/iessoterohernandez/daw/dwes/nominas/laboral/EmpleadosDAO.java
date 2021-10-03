/**
 * 
 */
package es.iessoterohernandez.daw.dwes.nominas.laboral;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author fjdl
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmpleadosDAO {

	public static List<Empleado> getEmpleados() {
		//Conexón a la base de datos
        Connection con = ConexionBD.getConnection();
        ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();
        Empleado e;
	        
        try {    
	        Statement st=con.createStatement();
	        ResultSet rs=st.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados");
	        
			while (rs.next()) {
				e = new Empleado(rs.getString(1), rs.getString(2),  rs.getString(3).toCharArray()[0], rs.getInt(4), rs.getInt(5));
				lista_empleados.add(e);
			}
        }catch (SQLException ex) {
        	ex.printStackTrace();
    	}catch (DatosNoCorrectosException ex) {
    		ex.printStackTrace();
		}
        
		return lista_empleados;

	}

	public static List<String[]> getNominas() {
		//Conexón a la base de datos
        Connection con = ConexionBD.getConnection();
        ArrayList<String[]> lista_nominas = new ArrayList<String[]>();
        String[] n = new String[2];	        
        try {    
	        Statement st=con.createStatement();
	        ResultSet rs=st.executeQuery("select dni, sueldo from nominas");
	        
			while (rs.next()) {
				n[0] = rs.getString(1);
				n[1] = String.valueOf(rs.getInt(2));
				lista_nominas.add(n);
			}
        }catch (SQLException ex) {
        	ex.printStackTrace();
		}
        
		return lista_nominas;
	}
	
	public static void altaEmpleado(Empleado e) {
		//Conexón a la base de datos
        Connection con = ConexionBD.getConnection();
	        
        try {    
	        Statement st=con.createStatement();
			//Insertamos el empleado
	        st.execute("insert into Empleados(nombre,dni,sexo,categoria,anyos) values ('"+e.nombre+"','"+e.dni+"','"+e.sexo+"','"+e.getCategoria()+"','"+e.anyos);
	        //Insertamos el sueldo del empleado
			st.execute("insert into nominas(dni, sueldo) values ('"+e.dni+"','"+Nomina.sueldo(e)+"')");
        }catch (SQLException ex) {
	    	  ex.printStackTrace();
	    }
	}
	
	public static void altaEmpleado(String nombreFichero) {
		//Conexón a la base de datos
        Connection con = ConexionBD.getConnection();
  
        //Variables
        String line;;
        Empleado e;
        String []datosEmp;
        
        try {
            //Fichero de entrada
            File fentrada = new File(nombreFichero);
            FileReader fr = new FileReader(fentrada);        
            BufferedReader br = new BufferedReader(fr);
            
	        Statement st=con.createStatement();

	        while (br.ready()) {
	        	//Leemos línea por línea el fichero de entrada
	        	line = br.readLine();
	        	datosEmp = line.split(";");
	        	if (datosEmp.length == 3) //en el caso de que en la línea solo haya 3 datos del empleado
	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0]);
	        	else //en el caso de que vayan todos los datos
	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0], Integer.parseInt(datosEmp[3]), Integer.parseInt(datosEmp[4]));

				//Insertamos el empleado
		        st.execute("insert into Empleados values ('"+e.nombre+"','"+e.dni+"','"+e.sexo+"',"+e.getCategoria()+","+e.anyos);
		        //Insertamos el sueldo del empleado
				st.execute("insert into nominas values ('"+e.dni+"',"+Nomina.sueldo(e)+")");
				
	        }	
        }catch (FileNotFoundException ex){
        	ex.printStackTrace();
        }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }catch (IOException ex) {
	    	ex.printStackTrace();
	    }catch (DatosNoCorrectosException ex) {
	    	ex.printStackTrace();
	    }
	}

}
