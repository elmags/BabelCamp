package negocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.json.JSONException;

import com.google.gson.Gson;

import datos.Coche;
import datos.Coches;
import datos.Validado;
import persistencia.DaoCocheMySql;
import persistencia.interfaces.DaoCoche;

public class GestorCoche {

	private DaoCoche dc = new DaoCocheMySql();

	/*
	 * Muchas de estas cosas ya están controladas en la base de datos, pero tambien
	 * lo he hecho aquí.
	 */

	/**
	 * El método da de alta un coche en una base de datos. Comprueba que la
	 * matrícula tiene longitud 7 y no se encuentra ya insertada en la bbdd. El
	 * número de kilometros no puede ser negativo.
	 * 
	 * @param c -> Coche que se quiere dar de alta.
	 * @return 0 -> En caso de que el coche se cree con éxito. 1 -> En caso de que
	 *         la matrícula ya se encuentre en la bbdd. 2 -> En caso de no haberse
	 *         podido establecer correctamente la conexión con la bbdd. 3 -> En caso
	 *         de que la matrícula del coche tenga una longitud distinta de 7. 4 ->
	 *         En caso de que el número de kilometros sea negativo.
	 */
	public int alta(Coche c) {
		if (c.getKm() < 0)
			return 4;
		String matricula = c.getMatricula();
		if (matricula.length() == 7) {
			Coches coches = dc.get();
			for (Coche coche : coches.getCoches())
				if (coche.getMatricula().equals(matricula))
					return 1;
			boolean creado = dc.alta(c);
			if (creado)
				return 0;
			else
				return 2;
		}
		return 3;
	}

	/**
	 * El método da de baja un coche en una base de datos.
	 * 
	 * @param id -> Identificador del coche que se quiere dar de baja.
	 * @return true -> En caso de que se haya podido establecer con éxito la
	 *         conexión con la bbdd y se haya dado de baja el coche. false -> En
	 *         caso contrario.
	 */
	public boolean baja(int id) {
		boolean borrado = dc.baja(id);
		return borrado;
	}

	/**
	 * El método modifica un coche de la bbdd. Comprueba que la matrícula tiene
	 * longitud 7 y no se encuentra ya insertada en la bbdd. El número de kilometros
	 * no puede ser negativo.
	 * 
	 * @param c -> Coche que se quiere modificar.
	 * @return 0 -> En caso de que el coche se modifique con éxito. 1 -> En caso de
	 *         que la matrícula ya se encuentre en la bbdd. 2 -> En caso de no
	 *         haberse podido establecer correctamente la conexión con la bbdd. 3 ->
	 *         En caso de que la matrícula del coche tenga una longitud distinta de
	 *         7. 4 -> En caso de que el número de kilometros sea negativo.
	 */
	public int modificar(Coche c) {
		if (c.getKm() < 0)
			return 4;
		String matricula = c.getMatricula();
		if (matricula.length() == 7) {
			Coches coches = dc.get();
			for (Coche coche : coches.getCoches())
				if (coche.getId() != c.getId() && coche.getMatricula().equals(matricula))
					return 1;
			boolean modificado = dc.modificar(c);
			if (modificado)
				return 0;
			else
				return 2;
		}
		return 3;
	}

	/**
	 * El método busca en la base de datos un coche por id.
	 * 
	 * @param id -> Identificador del coche que se quiere encontrar.
	 * @return Devuelve el coche si lo encuentra, en caso contario null.
	 */
	public Coche buscar(int id) {
		Coche coche = dc.buscar(id);
		return coche;
	}

	/**
	 * El método busca en la base de datos un coche por matrícula.
	 * 
	 * @param matricula -> Matrícula del coche que se quiere encontrar.
	 * @return Devuelve el coche si lo encuentra, en caso contario null.
	 */
	public Coche buscar_matricula(String matricula) {
		Coche coche = dc.buscar_matricula(matricula);
		return coche;
	}

	/**
	 * El método busca en la base de datos coches por marca.
	 * 
	 * @param marca -> Marca del coche que se quiere encontrar.
	 * @return Devuelve los coches encontrado, si no encuentra devuelve null.
	 */
	public Coches buscar_marca(String marca) {
		Coches coches = dc.buscar_marca(marca);
		return coches;
	}

	/**
	 * El método busca en la base de datos coches por modelo.
	 * 
	 * @param modelo -> Modelo del coche que se quiere encontrar.
	 * @return Devuelve los coches encontrado, si no encuentra devuelve null.
	 */
	public Coches buscar_modelo(String modelo) {
		Coches coches = dc.buscar_modelo(modelo);
		return coches;
	}

	/**
	 * El método devuelve los coches de la bbdd.
	 * 
	 * @return Devuelve el listado de coches, si no es posible devuelve null.
	 */
	public Coches get() {
		Coches coches = dc.get();
		return coches;
	}

	/**
	 * Método que almacena la lista de coches en un fichero TXT con formato JSON
	 * @param csjson : lista de coches de la base de datos
	 */
	public void ficheroJson(Coches csjson) {
		String path = "src/main/resources/json.txt";
		try (FileWriter fw = new FileWriter(path)) {
			if (csjson != null) {
				Gson gs = new Gson();
				fw.write(gs.toJson(csjson.getCoches()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (new File(path).exists())
			System.out.println("El fichero JSON se ha creado correctamente\n");
		else
			System.out.println("El fichero JSON no se ha podido crear\n");
	}

	/**
	 * Método que almacena la lista de coches en un fichero PDF
	 * @param cspdf : lista de coches de la base de datos
	 */
	public void ficheroPdf(Coches cspdf) {
		String path = "src/main/resources/coches.pdf";
		try (PDDocument pdf = new PDDocument()) {
			PDPage page = new PDPage();
			pdf.addPage(page);

			PDPageContentStream cs = new PDPageContentStream(pdf, page);

			cs.beginText();
			cs.setFont(PDType1Font.TIMES_ROMAN, 11);
			cs.setLeading(14.5f);
			cs.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);
			for (Coche c : cspdf.getCoches()) {
				cs.showText(c.toString());
				cs.newLine();
			}
			cs.endText();
			cs.close();

			pdf.save(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (new File(path).exists())
			System.out.println("El fichero PDF se ha creado correctamente\n");
		else
			System.out.println("El fichero PDF no se ha podido crear\n");
	}

	/**
	 * Método que almacena la lista de coches en un fichero Excel
	 * @param csexcel : lista de coches de la base de datos
	 */
	public void ficheroExcel(Coches csexcel) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = (HSSFSheet) wb.createSheet("coches");

		String[] hs = new String[] { "ID", "MATRICULA", "MARCA", "MODELO", "KM" };

		CellStyle hStyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBold(true);
		hStyle.setFont(font);

		HSSFRow hRow = sheet.createRow(0);
		for (int i = 0; i < hs.length; i++) {
			String h = hs[i];
			HSSFCell cell = hRow.createCell(i);
			cell.setCellValue(h);
			cell.setCellStyle(hStyle);
		}

		for (int i = 0; i < csexcel.getCoches().size(); i++) {
			HSSFRow dRow = sheet.createRow(i + 1);
			Coche cs = csexcel.getCoches().get(i);

			dRow.createCell(0).setCellValue(cs.getId());
			dRow.createCell(1).setCellValue(cs.getMatricula());
			dRow.createCell(2).setCellValue(cs.getMarca());
			dRow.createCell(3).setCellValue(cs.getModelo());
			dRow.createCell(4).setCellValue(cs.getKm());
		}

		try (FileOutputStream fo = new FileOutputStream("src/main/resources/coches.xls")) {
			wb.write(fo);
			wb.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que realiza una peticion HTTP GET al servicio rest.
	 * @param username : Nombre que el usuario introduce
	 * @param password : Contraseña que el usuario introduce
	 * @return
	 * 			- True, en el caso de que el usuario se encuentre en la base de datos.
	 * 			- False, en caso contrario.
	 */
	public boolean validar(String username, String password) {
		boolean valido = false;
			
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://localhost:8080/Ejercicio21_WebLogin/usuarios/login?username=" + username + "&password=" + password))
					.GET()
					.build();
	
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			Gson gson = new Gson();
			Validado validado = gson.fromJson(response.body(), Validado.class);
			valido = validado.isValidado();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JSONException e){
            e.printStackTrace();
        }
		return valido;
	}
}
