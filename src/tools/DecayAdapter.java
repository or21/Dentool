package tools;

import java.util.ArrayList;


import com.example.dentool.NewPatient;
import com.example.dentool.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DecayAdapter extends ArrayAdapter<Tooth> implements OnClickListener{

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


	Button topButton;
	Button leftButton;
	Button rightButton;
	Button middleButton;
	Button bottomButton;


	private static class ViewHolder {
		private ListView itemView;



		@SuppressWarnings("unused")
		public ListView getItemView() {
			return itemView;
		}
	}

	int index;

	public DecayAdapter(Context context, int textViewResourceId, ArrayList<Tooth> items, int pictureId) {
		super(context, textViewResourceId, items);
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		index = position;
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext())
					.inflate(R.layout.decay_layout, parent, false);

			viewHolder = new ViewHolder();

			topButton = (Button)convertView.findViewById(R.id.topButton);
			topButton.setOnClickListener(this);

			rightButton = (Button)convertView.findViewById(R.id.rightButton);
			rightButton.setOnClickListener(this);

			bottomButton = (Button)convertView.findViewById(R.id.bottomButton);
			bottomButton.setOnClickListener(this);


			leftButton = (Button)convertView.findViewById(R.id.leftButton);
			leftButton.setOnClickListener(this);



			middleButton = (Button)convertView.findViewById(R.id.middleButton);

			middleButton.setOnClickListener(this);




			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}



	@Override
	public void onClick(View v) {
		status = NewPatient.patient.getTeeth()[index].getDecay();
		switch(v.getId()){
		case (R.id.middleButton): {
			if (status[0]){
				v.setBackgroundResource(R.drawable.button_normal);
				v.setBackgroundResource(Color.TRANSPARENT);
			} else {
				v.setBackgroundResource(R.drawable.button_selected);
				v.setBackgroundColor(Color.RED);
			}
			NewPatient.patient.getTeeth()[index].setDecay(
					new Boolean[] {!status[0], status[1], status[2], status[3],status[4]});
			break;
		}
		case (R.id.topButton): {
			if (status[1]){
				v.setBackgroundResource(R.drawable.button_normal);
			} else {
				v.setBackgroundResource(Color.TRANSPARENT);
			}
			NewPatient.patient.getTeeth()[index].setDecay(
					new Boolean[] {status[0], !status[1], status[2], status[3],status[4]});
			break;
		}
		case (R.id.rightButton): {
			if (status[2]){
				v.setBackgroundResource(R.drawable.button_normal);
			} else {
				v.setBackgroundResource(Color.TRANSPARENT);
			}
			NewPatient.patient.getTeeth()[index].setDecay(
					new Boolean[] {status[0], status[1], !status[2], status[3],status[4]});
			break;
		}
		case (R.id.bottomButton): {
			if (status[3]){
				v.setBackgroundResource(R.drawable.button_normal);
			} else {
				v.setBackgroundResource(Color.TRANSPARENT);
			}
			NewPatient.patient.getTeeth()[index].setDecay(
					new Boolean[] {status[0], status[1], status[2], !status[3],status[4]});
			break;
		}
		case (R.id.leftButton): {
			if (status[4]){
				v.setBackgroundResource(R.drawable.button_normal);
			} else {
				v.setBackgroundResource(Color.TRANSPARENT);
			}
			NewPatient.patient.getTeeth()[index].setDecay(
					new Boolean[] {status[0], status[1], status[2], status[3], !status[4]});
			break;
		}
		}
	}
}