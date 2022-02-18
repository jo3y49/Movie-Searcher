package Main;

public class movie {
	private String title;
	private String actor1;
	private String actor2;
	private int year;
	private int runtime;
	private String director;
	public movie(String t, String a1, String a2, int y, int r, String d){
		title=t;
		actor1=a1;
		actor2=a2;
		year=y;
		runtime=r;
		director=d;
	}
	public String getTitle(){
		return title;
	}
	public String getActor1(){
		return actor1;
	}
	public String getActor2(){
		return actor2;
	}
	public int getYear(){
		return year;
	}
	public int getRuntime(){
		return runtime;
	}
	public String getDirector(){
		return director;
	}
}
