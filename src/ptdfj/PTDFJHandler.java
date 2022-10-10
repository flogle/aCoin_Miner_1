package ptdfj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import ptdfj.exceptions.runtime.NoDataAssignmentEexception;

public class PTDFJHandler {
	
	public static final char COMMENT_CHAR = '#';
	
	private HashMap<String, String> data;
	private File dataFile;
	
	/**
	 * Loads the data of the file on call
	 * @throws IOException 
	 */
	public PTDFJHandler(File dataFile) throws IOException, NoDataAssignmentEexception {
		
		this.data = new HashMap<String, String>();
		this.dataFile = dataFile;
		
		this.load();
		
	}
	
	/**
	 * Loads the data of the file on call
	 * @throws IOException 
	 */
	public PTDFJHandler(String dataFileString) throws IOException, NoDataAssignmentEexception {
		
		this.data = new HashMap<String, String>();
		this.dataFile = new File(dataFileString);
		
		this.load();
		
	}
	
	/**
	 * Returns and set the data of the load file
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public HashMap<String, String> load() throws IOException, NoDataAssignmentEexception {
		
		HashMap<String, String> temp = new HashMap<String, String>();
		
		
		FileReader fileReader = new FileReader(this.dataFile);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line;
		
		while ((line = reader.readLine()) != null) {
			
			if (line.equalsIgnoreCase("")) continue;
			if (line.toCharArray()[0] == PTDFJHandler.COMMENT_CHAR) continue;
			
			String[] tempData = line.split("=");
			
			try {
				
				String key = tempData[0];
				
				String value = new String("");
				
				for (int i = 1; i < tempData.length; i++) {
					
					if (i == 1) {
						
						value = value.concat(tempData[i]);
						
					} else {
						
						value = value.concat(String.format("=%s", tempData[i]));
						
					}
					
				}
				
				temp.put(key, value);
				
			} catch (IndexOutOfBoundsException ioobe) {
				
				throw new NoDataAssignmentEexception(String.format("Check the file %s for errors", this.dataFile.getPath()));
				
			}
			
			
		}
		
		reader.close();
		
		this.data = temp;
		
		return temp;
		
	}
	
	/**
	 * Returns the string that will be saved to a file
	 */
	public String saveFileString() {
		
		String data = new String("");
		
		Iterator<String> keys = this.data.keySet().iterator();
		
		while (keys.hasNext()) {
			
			String currentData = keys.next();
			String item = currentData;
			
			item = item.concat(String.format("=%s\n", this.data.get(currentData)));
			
			data = data.concat(item);
			
		}
		
		return data;
		
	}
	
	/**
	 * Save data as a .ptdfj file
	 * @throws IOException
	 */
	public void save() throws IOException {
		
		FileWriter fileWriter = new FileWriter(this.dataFile);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		
		writer.write(this.saveFileString());
		
		writer.close();
		
	}

	public HashMap<String, String> getData() {
		return this.data;
	}

	public void setData(HashMap<String, String> data) {
		this.data = data;
	}

	public File getDataFile() {
		return this.dataFile;
	}

	public void setDataFile(File dataFile) {
		this.dataFile = dataFile;
	}

	public String replace(String key, String value) {
		return this.data.replace(key, value);
	}

	public String get(String key) {
		return data.get(key);
	}

}
