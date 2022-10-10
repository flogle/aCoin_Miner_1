package ptdfj;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import ptdfj.exceptions.runtime.NoDataAssignmentEexception;

public class PTDFJHandlerString {

    public static final char COMMENT_CHAR = '#';

    private HashMap<String, String> data;
    private String dataS;

    /**
     * Loads the data of the file on call
     * 
     * @throws IOException
     */
    public PTDFJHandlerString(String dataFileString) throws IOException, NoDataAssignmentEexception {

        this.data = new HashMap<String, String>();
        this.dataS = dataFileString;

        this.load();

    }

    /**
     * Returns and set the data of the load file
     * 
     * @throws IOException
     */
    public HashMap<String, String> load() throws IOException, NoDataAssignmentEexception {

        HashMap<String, String> temp = new HashMap<String, String>();

        String[] dataLines = this.dataS.split("\n");
        
        String line;

        for (int i = 0; i < dataLines.length; i++) {

            line = dataLines[i];

            if (line.equalsIgnoreCase(""))
                continue;
            if (line.toCharArray()[0] == PTDFJHandlerString.COMMENT_CHAR)
                continue;

            String[] tempData = line.split("=");

            try {

                String key = tempData[0];

                String value = new String("");

                for (int j = 1; j < tempData.length; j++) {

                    if (j == 1) {

                        value = value.concat(tempData[j]);

                    } else {

                        value = value.concat(String.format("=%s", tempData[j]));

                    }

                }

                temp.put(key, value);

            } catch (IndexOutOfBoundsException ioobe) {

                throw new NoDataAssignmentEexception(
                        String.format("Check the string %s for errors", this.dataS));

            }

        }

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

    public HashMap<String, String> getData() {
        return this.data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
    public String replace(String key, String value) {
        return this.data.replace(key, value);
    }

    public String get(String key) {
        return data.get(key);
    }

    public String getDataS() {
        return this.dataS;
    }
    
    public void setDataS(String dataS) {
        this.dataS = dataS;
    }

}
