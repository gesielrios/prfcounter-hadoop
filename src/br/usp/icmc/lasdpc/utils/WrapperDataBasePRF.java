package br.usp.icmc.lasdpc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WrapperDataBasePRF {

	public static void main(String[] args) throws Exception {

		FileReader fileReader = new FileReader("datatran2016_atual.csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		FileWriter fileWriter = new FileWriter("data_base_prf_token.csv");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		// 0-"id";1-"data_inversa";2-"dia_semana";3-"horario";4-"uf";5-"br";6-"km";
		// 7-"municipio";8-"causa_acidente";9-"tipo_acidente";10-"classificacao_acidente";
		// 11-"fase_dia";12-"sentido_via";13-"condicao_metereologica";14-"tipo_pista";
		// 15-"tracado_via";16-"uso_solo";17-"pessoas";18-"mortos";19-"feridos_leves";
		// 20-"feridos_graves";21-"ilesos";22-"ignorados";23-"feridos";24-"veiculos"
		
		bufferedReader.readLine();

		while (bufferedReader.ready()) {

			String line = bufferedReader.readLine();
			String[] data = line.split(";");

			String diaSemana = data[2];
			String causaAcidente = data[8];
			String faseDia = data[11];
			String condicaoMetereologica = data[13];

//			printWriter.println(
//					"DS" + diaSemana + ";CA" + causaAcidente + ";FD" + faseDia + ";CM" + condicaoMetereologica);
//			
//			printWriter.println(
//					diaSemana + ";" + causaAcidente + ";" 
//							+ faseDia + ";" + condicaoMetereologica);
//
//			printWriter.println(diaSemana);
//			printWriter.println(causaAcidente);
//			printWriter.println(faseDia);
//			printWriter.println(condicaoMetereologica);
			
		}

		printWriter.flush();
		printWriter.close();

		bufferedReader.close();

	}

}
