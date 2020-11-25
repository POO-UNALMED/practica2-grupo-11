package basedatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/*
 * Clase de utilidad durante el desarrollo de la aplicacion, no agrega ningun tipo de valor a la misma. 
 */
public class BorradorDeArchivos {

	private static File rutaTemp = new File("src\\basedatos\\temp");

	public static void borrarContArchivos() {
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;

		// Este for borra lo que contengan los archivos de texto 
		for (File file : docs) {
			try {
				// Al crear este objeto de PrintWriter y pasarle como parámetro la ruta de cada
				// archivo
				// borra lo que haya en ellos automáticamente.
				pw = new PrintWriter(file);
				//System.out.println(file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}