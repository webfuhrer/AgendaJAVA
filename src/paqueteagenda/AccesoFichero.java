package paqueteagenda;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {
private static String ruta="T:\\contactos.csv";
private static  String separador=",";
	public static void grabarContacto(Contacto c) {
		try {
			FileWriter fw=new FileWriter(ruta, true);
			String linea=c.getNombre()+separador+c.getEmail()+separador+c.getTelefono()+"\n";
			fw.write(linea);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected static ArrayList<Contacto> recuperarContactos() {
		ArrayList<Contacto> lista_contactos=new ArrayList<Contacto>();
		try {
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(separador);
				String nombre=datos[0];
				String email=datos[1];
				String telefono=datos[2];
				Contacto c=new Contacto(nombre, email, telefono);
				lista_contactos.add(c);
				linea=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_contactos;
	}
	public static ArrayList<Contacto> buscarPorNombre(ArrayList<Contacto> lista_contactos2, String nombre_buscado) {
		ArrayList<Contacto> lista_buscados=new ArrayList<Contacto>();
		for (Contacto contacto : lista_contactos2) {
			if (contacto.getNombre().equalsIgnoreCase(nombre_buscado))
			{
				//Coinciden
				lista_buscados.add(contacto);
			}
		}
		return lista_buscados;
	}

}
