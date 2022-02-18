//Joseph May

package Main;

import java.io.IOException;
import java.util.InputMismatchException;

public class Driver{
	
	public static void main(String[] args) throws IOException{
		keyboardinput in=new keyboardinput();
		database da=new database("db.txt");
		filewrite fw=new filewrite("db.txt");
		
		pl("Welcome to the ultimate movie database!\n");
		String s="";
		do{
			int i=0;
			do{
				if(i!=0){
					pl("Invalid command");
				}
				else
					i++;
				pl("Enter 'new' to enter a new entry");
				pl("To search, enter either 'title', 'actor', 'year', 'runtime', or 'director' to choose a search method");
				pl("Enter 'quit' to exit the program");
				p("Enter command: ");
				s=in.getKbLine();
			} while(!s.equalsIgnoreCase("new") && !s.equalsIgnoreCase("actor") && !s.equalsIgnoreCase("year") && !s.equalsIgnoreCase("runtime") && !s.equalsIgnoreCase("director") && !s.equalsIgnoreCase("title") && !s.equalsIgnoreCase("quit"));
			s.toLowerCase();
			switch(s){
			case "new":
				String t="";
				do{
					p("Enter title: ");
					t=in.getKbLine();
					if (t.length()<3)
						pl("Invalid title, should be at least 3 characters");
				}while(t.length()<3);
				p("Enter actor 1: ");
				String a1=in.getKbLine();
				p("Enter actor 2: ");
				String a2=in.getKbLine();
				int n;
				int y=0;
				int r=0;
				p("Enter year: ");
				do{
					try{
						y=in.getKbInt();
						n=1;
					} 
					catch (InputMismatchException e){
						pl("Please enter a number");
						in.getKbLine();
						n=0;
					}
				} while (n==0);
				p("Enter runtime (in minutes): ");
				do{
					try{
						r=in.getKbInt();
						n=1;
					} 
					catch (InputMismatchException e){
						pl("Please enter a number");
						in.getKbLine();
						n=0;
					}
				} while (n==0);
				p("Enter director: ");
				in.getKbLine();
				String d=in.getKbLine();
				movie m=new movie(t,a1,a2,y,r,d);
				da.addEntry(m);
				String newLine=t+"/"+a1+"/"+a2+"/"+String.valueOf(y)+"/"+String.valueOf(r)+"/"+d+"/";
				fw.writeLine(newLine);
				pl("Entry successfully added");
				fw.saveFile();
				da=new database("db.txt");
				fw=new filewrite("db.txt");
				i=0;
				break;
			case "actor":
				p("Enter actor: ");
				da.searchByActor(in.getKbLine());
				i=0;
				break;
			case "year":
				p("Enter year: ");
				do{
					try{
						i=in.getKbInt();
						n=1;
					} 
					catch (InputMismatchException e){
						pl("Please enter a number");
						in.getKbLine();
						n=0;
					}
				} while (n==0);
				da.searchByYear(i);
				i=0;
				in.getKbLine();
				break;
			case "runtime":
				p("Enter runtime (in minutes): ");
				do{
					try{
						i=in.getKbInt();
						n=1;
					} 
					catch (InputMismatchException e){
						pl("Please enter a number");
						in.getKbLine();
						n=0;
					}
				} while (n==0);
				da.searchByRuntime(i);
				i=0;
				in.getKbLine();
				break;
			case "director":
				p("Enter director: ");
				da.searchByDirector(in.getKbLine());
				i=0;
				break;
			case "title":
				p("Enter title: ");
				da.searchByTitle(in.getKbLine());
				i=0;
				break;
			case "quit":
				fw.saveFile();
				in.closeKeyboard();
			}
		}while(!s.equals("quit"));
	}
	public static <E> void pl(E item){
		System.out.println(item);
	}
	public static <E> void p(E item){
		System.out.print(item);
	}
}
