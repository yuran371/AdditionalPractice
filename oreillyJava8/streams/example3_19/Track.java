package streams.example3_19;

public class Track {
	private String name;
	private int duration;
	
	Track (String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", duration=" + duration + "]";
	}	
}
