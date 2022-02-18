package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class database {
	private ArrayList<movie> movies;
	private ArrayList<String> titles;
	private ArrayList<String> actors1;
	private ArrayList<String> actors2;
	private ArrayList<Integer> years;
	private ArrayList<Integer> runtimes;
	private ArrayList<String> directors;
	private int z;
	
	
	// Constructor
	public database(String filename) throws IOException{
		fileread fr=new fileread(filename);
		movies = new ArrayList<>();
		titles = new ArrayList<>();
		actors1 = new ArrayList<>();
		actors2 = new ArrayList<>();
		years = new ArrayList<>();
		runtimes = new ArrayList<>();
		directors = new ArrayList<>();
		for(int n = 0; n < fr.getNumberOfLines(); n++){
			String raw = fr.getLine(n);
			StringTokenizer st=new StringTokenizer(raw,"/");
			String t=st.nextToken();
			titles.add(t);
			String a1=st.nextToken();
			actors1.add(a1);
			String a2=st.nextToken();
			actors2.add(a2);
			int y=Integer.parseInt(st.nextToken());
			years.add(y);
			int r=Integer.parseInt(st.nextToken());
			runtimes.add(r);
			String d=st.nextToken();
			directors.add(d);
			movie mo=new movie(t,a1,a2,y,r,d);
			movies.add(mo);
		}
	}
	
	// Methods
	public void addEntry(movie m){
		movies.add(m);
	}
	
	public void searchByTitle(String title){
		z=titles.indexOf(title);
		if(z>-1){
			pl(CString(z));
		} else 
			pl("No titles found");
	}
	
	public void searchByActor(String actor){
		z=actors1.indexOf(actor);
		int c=0;
		int k=0;
		if(z>-1){
			while(z>-1){
				pl(titles.get(z));
				if(z!=actors1.lastIndexOf(z)){
					String[] s=new String[actors1.size()];
					int[] i=new int[actors1.size()];
					s[c]=actors1.get(z);
					i[c]=z;
					c++;
					actors1.set(z,"");
					z=actors1.indexOf(actor);
					if(z==-1){
						for(int p=c;p>=0;p--){
							actors1.set(i[p],s[p]);
						}
					}
				} else 
					z=-1;
			}
		} else
			k++;
		z=actors2.indexOf(actor);
		c=0;
		if(z>-1){
			while(z>-1){
				pl(titles.get(z));
				if(z!=actors2.lastIndexOf(z)){
					String[] s=new String[actors2.size()];
					int[] i=new int[actors2.size()];
					s[c]=actors2.get(z);
					i[c]=z;
					c++;
					actors2.set(z,"");
					z=actors2.indexOf(actor);
					if(z==-1){
						for(int p=c;p>=0;p--){
							actors2.set(i[p],s[p]);
						}
					}
				} else 
					z=-1;
			}
		} else
			k++;
		if(k==2)
			pl("No titles found for actor");
	}
	public void searchByYear(int year){
		z=years.indexOf(year);
		int c=0;
		if(z>-1){
			while(z>-1){
				pl(titles.get(z));
				if(z!=years.lastIndexOf(z)){
					int[] s=new int[years.size()];
					int[] i=new int[years.size()];
					s[c]=years.get(z);
					i[c]=z;
					c++;
					years.set(z,0);
					z=years.indexOf(year);
					if(z==-1){
						for(int p=c;p>=0;p--){
							years.set(i[p],s[p]);
						}
					}
				} else 
					z=-1;
			}
		} else 
			pl("No titles found for years");
	}

	public void searchByRuntime(int runtime){
		z=runtimes.indexOf(runtime);
		int c=0;
		if(z>-1){
			while(z>-1){
				pl(titles.get(z));
				if(z!=runtimes.lastIndexOf(z)){
					int[] s=new int[runtimes.size()];
					int[] i=new int[runtimes.size()];
					s[c]=runtimes.get(z);
					i[c]=z;
					c++;
					runtimes.set(z,0);
					z=runtimes.indexOf(runtimes);
					if(z==-1){
						for(int p=c;p>=0;p--){
							runtimes.set(i[p],s[p]);
						}
					}
				} else 
					z=-1;
			}
		} else 
			pl("No titles found for runtimes");
	}
	
	public void searchByDirector(String director){
		z=directors.indexOf(director);
		int c=0;
		if(z>-1){
			while(z>-1){
				pl(titles.get(z));
				if(z!=directors.lastIndexOf(z)){
					String[] s=new String[directors.size()];
					int[] i=new int[directors.size()];
					s[c]=directors.get(z);
					i[c]=z;
					c++;
					directors.set(z,"");
					z=directors.indexOf(director);
					if(z==-1){
						for(int p=c;p>=0;p--){
							directors.set(i[p],s[p]);
						}
					}
				} else 
					z=-1;
			}
		} else 
			pl("No titles found for director");
	}
	public static <E> void pl(E item){
		System.out.println(item);
	}
	public static <E> void p(E item){
		System.out.print(item);
	}
	public String CString(int z){
		return actors1.get(z)+" "+actors2.get(z)+" "+String.valueOf(years.get(z))+" "+String.valueOf(runtimes.get(z))+" "+directors.get(z);
	}
}
