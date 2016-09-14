import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CSVReader to get show information.
 * @author Nicholas Buquicchio
 *
 */
public class CSVReader {
	private String csvName;
	private String line;
	private String splitBy;
	private FileInputStream fis = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	/**
	 * CSVReader for CSV with title.. 
	 * @param name - title of CSV file
	 */
	public CSVReader(String name) {
		this.csvName = name;
		this.line = "";
		this.splitBy = ",";
		
	}
	
	/**
	 * Particular to ToonPicker as it filters out "Show Name, Score" row
	 * @return all useful values from the csv. Show names, weights
	 */
	public ArrayList<String> extractValues() {
		ArrayList<String> values = new ArrayList<String>();
		try {
			this.fis = new FileInputStream(this.csvName);
			this.isr = new InputStreamReader(this.fis, "UTF-8");
			this.br = new BufferedReader(this.isr);
			while((this.line = this.br.readLine()) != null) {
				List<String> readLine = Arrays.asList(
						this.line.split(this.splitBy));
				values.addAll(readLine);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		//TODO: refractor to ToonPicker, generalizing CSVReader 
		ArrayList<String> withoutHeaders = new ArrayList<String>();
		for (int n = 2; n < values.size(); n += 1) {
			withoutHeaders.add(values.get(n));
		}
		
		return withoutHeaders;
	}
	
}
