package tools;

public class Tooth {
	
	public enum State {
	    NULL, EXISTING, DEFECTIVE, NOTURGENT
	}
	
	private Boolean existing;
	private Boolean[] decay;
	private State fillings;
	private State root;
	private State crowns;
	private State implants;
	
	// Constructor
	public Tooth() {
		this.setExisting(true);
		this.setDecay(new Boolean[5]);
		this.setFillings(State.NULL);
		this.setRoot(State.NULL);
		this.setCrowns(State.NULL);
		this.setImplants(State.NULL);
	}


	public Boolean getExisting() {
		return existing;
	}


	public void setExisting(Boolean existing) {
		this.existing = existing;
	}


	public Boolean[] getDecay() {
		return decay;
	}


	public void setDecay(Boolean[] decay) {
		this.decay = decay;
	}


	public State getFillings() {
		return fillings;
	}


	public void setFillings(State fillings) {
		this.fillings = fillings;
	}


	public State getRoot() {
		return root;
	}


	public void setRoot(State root) {
		this.root = root;
	}


	public State getCrowns() {
		return crowns;
	}


	public void setCrowns(State crowns) {
		this.crowns = crowns;
	}


	public State getImplants() {
		return implants;
	}


	public void setImplants(State implants) {
		this.implants = implants;
	}
}
