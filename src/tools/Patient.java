package tools;

public class Patient {
	
	private Tooth[] teeth;
	private String userName;
	private String uid;
	
	public Patient(String userName, String uid) {
		this.teeth = new Tooth[32];
		for (int i = 0; i < 32; i++) {
			teeth[i] = new Tooth();
		}
		this.setUserName(userName);
		this.setUid(uid);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
}
