package Membri.springBoot.empleos.Util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utiles {
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal.replace(" ", "_");
		String nombreFinal = caracteresAleatorios(8)  +  nombreOriginal;
		try {

			// formamos el nombre del archivo para guardarlo en el disco duro
			File archivoImagen = new File(nombreFinal);
			System.out.println("Archivo " + archivoImagen.getAbsolutePath());

			// Guardamos fisicamente el archivo
			multiPart.transferTo(archivoImagen);

			return nombreFinal;

		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	/**
	 * Metodo para generar una cadena aleatoria de la longitud del numero N
	 * @param count
	 * @return
	 */
	
	public static String caracteresAleatorios(int count) {
		String caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		//mientras que el while funcione, vamos a generar caracteres aleatorios y los vamos añadiendo al StringBuilder
		// uso Stringbuilder por un tema de eficiencia en lugar de usar la concatenacion de String
		while(count-- !=0) {
			int caracterAleatorio = (int) (Math.random() * caracteres.length());
			builder.append(caracteres.charAt(caracterAleatorio));
		}
		return builder.toString();
	}
}