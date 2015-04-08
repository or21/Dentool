package tools;

import java.util.ArrayList;


import com.example.dentool.NewPatient;
import com.example.dentool.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class DecayAdapter extends ArrayAdapter<Tooth> implements OnCheckedChangeListener{

	//Image array holder
	int[][] images = {{R.drawable.decay_00, R.drawable.decay_01, 
		R.drawable.decay_02, R.drawable.decay_03, R.drawable.decay_04},
		{R.drawable.decay_10, R.drawable.decay_11, R.drawable.decay_12, 
			R.drawable.decay_13, R.drawable.decay_14}};

	Boolean[] status;

	@Override
	public int getCount() {
		return 8;
	}

	private static class ViewHolder {
		private ListView itemView;
		ImageView back;

		ToggleButton tb1;
		ToggleButton tb2;
		ToggleButton tb3;
		ToggleButton tb4;
		ToggleButton tb5;

		@SuppressWarnings("unused")
		public ListView getItemView() {
			return itemView;
		}
	}

	private int pictureId;
	int index;
	ViewHolder viewHolder = null;

	public DecayAdapter(Context context, int textViewResourceId, ArrayList<Tooth> items, int pictureId) {
		super(context, textViewResourceId, items);
		this.pictureId = pictureId;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		index = position;

		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext())
					.inflate(R.layout.decay_layout, parent, false);

			viewHolder = new ViewHolder();

			//load ImageView button - background
			viewHolder.back = (ImageView) convertView.findViewById(R.id.toggleHolder);

			status = NewPatient.patient.getTeeth()[position].getDecay();

			//load toggle buttons
			viewHolder.tb1 = (ToggleButton) convertView.findViewById(R.id.middleButton);
			viewHolder.tb2 = (ToggleButton) convertView.findViewById(R.id.topButton);
			viewHolder.tb3 = (ToggleButton) convertView.findViewById(R.id.rightButton);
			viewHolder.tb4 = (ToggleButton) convertView.findViewById(R.id.bottomButton);
			viewHolder.tb5 = (ToggleButton) convertView.findViewById(R.id.leftButton);

			viewHolder.tb1.setOnCheckedChangeListener(this); 
			viewHolder.tb2.setOnCheckedChangeListener(this); 
			viewHolder.tb3.setOnCheckedChangeListener(this); 
			viewHolder.tb4.setOnCheckedChangeListener(this); 
			viewHolder.tb5.setOnCheckedChangeListener(this); 







			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		switch (buttonView.getId()){
		case (R.id.middleButton):
			if (!status[0]){
				viewHolder.tb1.setBackgroundResource(images[1][0]);
			} else {
				viewHolder.tb1.setBackgroundResource(images[0][0]);
			}
		NewPatient.patient.getTeeth()[index].setDecay(
				new Boolean[] {!status[0], status[1], status[2], status[3],status[4]});
		case (R.id.topButton):
			if (!status[1]){
				viewHolder.tb2.setBackgroundResource(images[1][1]);
			} else {
				viewHolder.tb2.setBackgroundResource(images[0][1]);
			}
		NewPatient.patient.getTeeth()[index].setDecay(
				new Boolean[] {status[0], !status[1], status[2], status[3],status[4]});
		case (R.id.rightButton):
			if (!status[2]){
				viewHolder.tb3.setBackgroundResource(images[1][2]);
			} else {
				viewHolder.tb3.setBackgroundResource(images[0][2]);
			}
		NewPatient.patient.getTeeth()[index].setDecay(
				new Boolean[] {status[0], status[1], !status[2], status[3],status[4]});
		case (R.id.bottomButton):
			if (!status[3]){
				viewHolder.tb4.setBackgroundResource(images[1][3]);
			} else {
				viewHolder.tb4.setBackgroundResource(images[0][3]);
			}
		NewPatient.patient.getTeeth()[index].setDecay(
				new Boolean[] {status[0], status[1], status[2], !status[3],status[4]});
		case (R.id.leftButton):
			if (!status[4]){
				viewHolder.tb5.setBackgroundResource(images[1][4]);
			} else {
				viewHolder.tb5.setBackgroundResource(images[0][4]);
			}
		NewPatient.patient.getTeeth()[index].setDecay(
				new Boolean[] {status[0], status[1], status[2], status[3], !status[4]});

		}
	}
}