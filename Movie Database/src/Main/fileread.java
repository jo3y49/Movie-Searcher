package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileread {
		private ArrayList<String> lines;
		
		public fileread(String filename) throws IOException{
			lines =new ArrayList<>();
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String s="";
			while (s!=null){
				s=br.readLine();
				lines.add(s);
			} 
			br.close();
		}
		
		public int getNumberOfLines(){
			return lines.size()-1;
		}
		
		public String getLine(int index){
			return lines.get(index);
		}
}
