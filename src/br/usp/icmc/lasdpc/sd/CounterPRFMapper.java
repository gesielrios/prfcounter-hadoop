package br.usp.icmc.lasdpc.sd;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CounterPRFMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable numberOne = new IntWritable(1);
	private final Text keyword = new Text();

	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		StringTokenizer tk = new StringTokenizer(value.toString(), ";");
		
		while (tk.hasMoreTokens()) {
			String token = tk.nextToken();
			
			//dia_semana
			if (token.startsWith("DS")) {
				keyword.set(getKeyword(token));
				context.write(keyword, numberOne);
			}
			
			//causa_acidente
			if (token.startsWith("CA")) {
				keyword.set(getKeyword(token));
				context.write(keyword, numberOne);
			}
			
			//fase_dia
			if (token.startsWith("FD")) {
				keyword.set(getKeyword(token));
				context.write(keyword, numberOne);
			}
			
			//condicao_metereologica
			if (token.startsWith("CM")) {
				keyword.set(getKeyword(token));
				context.write(keyword, numberOne);
			}
			
		}
	}
	
	private String getKeyword(String token) {
		return token.substring(2).toLowerCase().replaceAll("[^a-zA-Z ]", "").replaceAll(" ", "-");
	}
	
}