
public class Event {
	String event;
	int position;
	boolean deletion;

	

	public Event(String event, int position, boolean deletion) {
		this.event = event;
		this.position = position;
		this.deletion = deletion;		
	}
	
	//get
	public String getEvent() {
		return event;
	}
	
	public int getPosition() {
		return position;
	}
	
	public boolean checkDeletion(){
		return deletion;
	}

	/**@Override
	public String toString() {
		return "Event" + event;
	}*/
	
}
