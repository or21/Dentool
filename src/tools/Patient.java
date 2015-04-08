package tools;

public class Patient {
	
	private Tooth[] teeth;
	private String firstName;
	private String lastName;
	private String uid;
	
	public Patient(String firstName, String lastName, String uid) {
		teeth = new Tooth[32];
		for (int i = 0; i < 32; i++) {
			teeth[i] = new Tooth();
		}
		
		setFirstName(firstName);
		setLastName(lastName);
		setUid(uid);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public Tooth[] getTeeth() {
		return teeth;
	}

	public void setTeeth(Tooth[] teeth) {
		this.teeth = teeth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
