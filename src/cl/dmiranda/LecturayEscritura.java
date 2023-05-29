//Desafio M2.2 Lectoescritura de Archivos

package cl.dmiranda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class LecturayEscritura {

	public static void main(String[] args) {
		crearArchivo("carpetaEscondida", "losDateaos.txt");
		buscarTexto("carpetaEscondida/losDateaos.txt", "Perro");
		System.out.println("prueba de commit");
	}

	public static ArrayList<String> lista() {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniela");
		lista.add("Camila");
		return lista;
	}

	public static void crearArchivo(String dirPath, String archPath) {
		File directorio = new File("src/" + dirPath);
		if (directorio.exists() == false) {
			directorio.mkdir();
		} else {
			System.out.println("Error al crear directorio");
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + dirPath + "/" + archPath));
			for (int i = 0; i < lista().size(); i++) {
				writer.write(lista().get(i));
				writer.newLine();
			}
			writer.close();
			System.out.println("ArrayList guardado correctamente en el archivo.");
		} catch (Exception e) {
			System.out.println("Error al guardar el ArrayList en el archivo");
		}

	}

	public static void buscarTexto(String nombreFichero, String texto) {
		int repeticiones = 0;
		String linea;
		try {
			BufferedReader lector = new BufferedReader(new FileReader("src/" + nombreFichero));

			while ((linea = lector.readLine()) != null) {
				if (linea.equals(texto)) {
					repeticiones += 1;
				}
			}
			lector.close();

			System.out.println("cantidad de repeticiones del texto -> " + repeticiones);

		} catch (Exception e) {
			System.out.println("El fichero ingresado no existe");
		}
	}

}
