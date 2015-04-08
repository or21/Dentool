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

public class DecayAdapter extends ArrayAdapter<Tooth> {

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
		status = NewPatient.patient.getTeeth()[index].getDecay();
		
		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext())
					.inflate(R.layout.decay_layout, parent, false);

			viewHolder = new ViewHolder();

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}
}