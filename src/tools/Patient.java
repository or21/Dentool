package tools;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.example.dentool.NewPatient;

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

	public static JSONArray getTeethData() {
		JSONArray teethData = new JSONArray();
		Tooth[] teeth = NewPatient.patient.getTeeth();
		JSONObject tooth;

		for (int i = 0; i < teeth.length; i++) {
			try {
				tooth = new JSONObject();
				tooth.put("tooth_num", i + 1);
				tooth.put("existing", teeth[i].getExisting());
				tooth.put("decay", Arrays.toString(teeth[i].getDecay()));
				tooth.put("fillings", Arrays.toString(teeth[i].getFillings()));
				tooth.put("crowns", teeth[i].getCrowns());
				tooth.put("root", teeth[i].getRoot());
				tooth.put("implants", teeth[i].getImplants());
				teethData.put(tooth);

			} catch (Exception e) {
				Log.i("Patient", "Something happened while retreiving patient's data");
			}
		}

		return teethData;
	}

	public String teethToString() {
		String res = "[";
		for (int i = 0; i < teeth.length; i++) {
			res += "{";
			res += "tooth_num:" + (i + 1) + " ";
			res += "existing: " + this.getTeeth()[i].getExisting() + ", ";
			res += "decay: [";
			for (int j = 0; j < 5; j++) {
				if (j == 4) {
					res += this.getTeeth()[i].getDecay()[j];
				}
				else {
					res += this.getTeeth()[i].getDecay()[j] + ", ";
				}
			}
			res += "], ";

			res += "fillings: [";
			for (int j = 0; j < 5; j++) {
				if (j == 4) {
					res += this.getTeeth()[i].getFillings()[j];
				}
				else {
					res += this.getTeeth()[i].getFillings()[j] + ", ";
				}
			}
			res += "], ";
			res += "crowns: " + this.getTeeth()[i].getCrowns() + ", ";
			res += "root: " + this.getTeeth()[i].getRoot() + ", ";
			res += "implants: " + this.getTeeth()[i].getImplants() + ", ";
			res += "}";
		}

		return res;

	}

}
