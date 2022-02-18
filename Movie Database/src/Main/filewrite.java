package Main;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class filewrite{
		private ArrayList<String> writeBuffer;
		private String filename;
		
		public filewrite(String filename){
			this.filename = filename;
			writeBuffer = new ArrayList<>();
			
		}
		
		//Methods
		public void writeLine(String newLine){
			writeBuffer.add(newLine);
			
		}
		
		public void saveFile() throws IOException{ 
			BufferedWriter write=new BufferedWriter(new FileWriter(filename, true));
			for(int i=0;writeBuffer.size()>i;i++){
				write.append("\n"+writeBuffer.get(i));
			}
			write.close();
		}
}
