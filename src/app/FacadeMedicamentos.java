package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FacadeMedicamentos {

	public String rutaMedicamentos = "/home/marlon97/Documentos/freelance/netbeans/98 429 7362/output/medicamentos.txt";
	private String rutaTemp = "/home/marlon97/Documentos/freelance/netbeans/98 429 7362/output/temp.txt";

	public void removeSeparator() throws IOException {
		String linea = "";
		File original = new File(rutaMedicamentos);
		File temporal = new File(rutaTemp);
		BufferedReader lector = new BufferedReader(new FileReader(original));
		BufferedWriter escritor = new BufferedWriter(new FileWriter(temporal));
		while ((linea = lector.readLine()) != null) {
			if (!linea.trim().equals("")) {
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temporal.renameTo(original);
	}

	private int getCont() {
		int cont = 1;
		String linea = "";
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(rutaMedicamentos));
			while ((linea = lector.readLine()) != null) {
				String[] datos = linea.split(",");
				cont = Integer.parseInt(datos[0]);
			}
			cont++;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				"No se puede leer el archivo de medicamentos para obtener el indice.",
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

	public ArrayList<String> getMedicamentos() {
		ArrayList<String> listaMedicamentos = new ArrayList<>();
		String linea = "";
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(rutaMedicamentos));
			while ((linea = lector.readLine()) != null) {
				listaMedicamentos.add(linea);
			}
		} catch (IOException e) {
			listaMedicamentos = null;
		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaMedicamentos;
	}

	public void setMedicamento(String nombreComercial, String principioActivo,
		String tipo, String peso, String stock) {
		FileWriter lector = null;
		try {
			lector = new FileWriter(rutaMedicamentos, true);
			BufferedWriter escritor = new BufferedWriter(lector);
			escritor.write(getCont() + "," + nombreComercial + "," + principioActivo
				+ "," + tipo + "," + peso + "," + stock + "\n");
			escritor.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(lector != null){
				try{
					lector.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateMedicamento(int id, String nombreComercial, String principioActivo,
		String tipo, String peso, String stock) throws IOException{
		String linea = "";
		File original = new File(rutaMedicamentos);
		File temporal = new File(rutaTemp);
		BufferedReader lector = new BufferedReader(new FileReader(original));
		BufferedWriter escritor = new BufferedWriter(new FileWriter(temporal));
		while((linea = lector.readLine()) != null){
			String [] datos = linea.split(",");
			if(Integer.parseInt(datos[0]) == id){
				escritor.write(id + "," + nombreComercial + "," + principioActivo
				+ "," + tipo + "," + peso + "," + stock + "\n");
			}else{
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temporal.renameTo(original);
	}
	
	public void deleteMedicamento(int id) throws IOException {
		String linea = "";
		File original = new File(rutaMedicamentos);
		File temporal = new File(rutaTemp);
		BufferedReader lector = new BufferedReader(new FileReader(original));
		BufferedWriter escritor = new BufferedWriter(new FileWriter(temporal));
		while((linea = lector.readLine()) != null){
			String [] datos = linea.split(",");
			if(Integer.parseInt(datos[0]) != id){
				escritor.write(linea + "\n");
			}
		}
		escritor.close();
		lector.close();
		original.delete();
		temporal.renameTo(original);
	}
}
