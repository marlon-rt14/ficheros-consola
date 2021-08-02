package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FacadeCitas {

	//private int cont;
	public String rutaCitas = "/home/marlon97/Documentos/freelance/netbeans/98 429 7362/output/citas.txt";
	private String rutaTemp = "/home/marlon97/Documentos/freelance/netbeans/98 429 7362/output/temp.txt";
	
	FacadeConsultorios facadeConsultorios = new FacadeConsultorios();

	private int getCont() {
		int cont = 1;
		String linea = "";
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(rutaCitas));
			while ((linea = lector.readLine()) != null) {
				String[] datos = linea.split(",");
				cont = Integer.parseInt(datos[0]);
			}
			cont++;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				"No se puede leer el archivo de citas para obtener el indice.",
				"Advertencia",
				JOptionPane.WARNING_MESSAGE);
			cont = 1;
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cont;
	}

	public void removeSeparator() throws IOException {
		String linea = "";
		File original = new File(rutaCitas);
		File temp = new File(rutaTemp);
		BufferedReader lector = lector = new BufferedReader(new FileReader(original));
		BufferedWriter escritor = escritor = new BufferedWriter(new FileWriter(temp));
		while ((linea = lector.readLine()) != null) {
			if (!linea.trim().equals("")) {
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temp.renameTo(original);
	}

	public ArrayList<String> getCitas() {
		ArrayList<String> listaCitas = new ArrayList<>();
		String linea = "";
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(rutaCitas));
			while ((linea = lector.readLine()) != null) {
				listaCitas.add(linea);
			}
		} catch (IOException e) {
			listaCitas = null;
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaCitas;

	}

	public void setPaciente(String nombre, String apellidoP, String apellidoM,
		String fecha, String hora, String consultorio, String descripcion) {

		FileWriter lector = null;
		try {
			lector = new FileWriter(rutaCitas, true);
			BufferedWriter escritor = new BufferedWriter(lector);
			escritor.write(getCont() + "," + nombre
				+ "," + apellidoP + "," + apellidoM
				+ "," + fecha + "," + hora
				+ "," + consultorio + "," + descripcion
				+ "\n");
			escritor.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void updatePaciente(int id, String nombre, String apellidoP, String apellidoM,
		String fecha, String hora, String consultorio, String descripcion) throws IOException {
		String linea = "";
		File original = new File(rutaCitas);
		File temporal = new File(rutaTemp);
		BufferedReader lector = new BufferedReader(new FileReader(original));;
		BufferedWriter escritor = new BufferedWriter(new FileWriter(temporal));

		while ((linea = lector.readLine()) != null) {
			String[] datos = linea.split(",");
			if (Integer.parseInt(datos[0]) == id) {
				escritor.write(id + "," + nombre
					+ "," + apellidoP + "," + apellidoM
					+ "," + fecha + "," + hora
					+ "," + consultorio + "," + descripcion
					+ "\n");
			}else{
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temporal.renameTo(original);
	}

	public void deletePaciente(int id) throws IOException {
		String linea = "";
		File original = new File(rutaCitas);
		File temporal = new File(rutaTemp);
		BufferedReader lector = new BufferedReader(new FileReader(original));
		BufferedWriter escritor = new BufferedWriter(new FileWriter(temporal));
		while ((linea = lector.readLine()) != null) {
			String[] datos = linea.split(",");
			if (Integer.parseInt(datos[0]) != id) {
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temporal.renameTo(original);
		
		facadeConsultorios.updateConsultorioPaciente(id);
	}
}
