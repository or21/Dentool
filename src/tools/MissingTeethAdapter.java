package tools;

import java.util.ArrayList;

import com.example.dentool.NewPatient;
import com.example.dentool.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.ToggleButton;

public class MissingTeethAdapter extends ArrayAdapter<Tooth>{
	
	@Override
	public int getCount() {
		return 16;
	}
	
	private static class ViewHolder {
        private ListView itemView;
        ToggleButton tb1;

		@SuppressWarnings("unused")
		public ListView getItemView() {
			return itemView;
		}
    }

	private int pictureId;
	
	 public MissingTeethAdapter(Context context, int textViewResourceId, ArrayList<Tooth> items, int pictureId) {
	        super(context, textViewResourceId, items);
	        this.pictureId = pictureId;
	    }

	    public View getView(final int position, View convertView, ViewGroup parent) {
	    	final ViewHolder viewHolder;
	    	
	    	if (convertView == null) {
	            convertView = LayoutInflater.from(this.getContext())
	            .inflate(R.layout.missing_teeth_layout, parent, false);

	            viewHolder = new ViewHolder();
	            
	            viewHolder.tb1 = (ToggleButton) convertView.findViewById(R.id.tb1);
	            
	            viewHolder.tb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (!NewPatient.patient.getTeeth()[position].getExisting()) {
				    		viewHolder.tb1.setBackgroundResource(pictureId);
			        		NewPatient.patient.getTeeth()[position].setExisting(true);
			        	} else {
			        		viewHolder.tb1.setBackgroundResource(Color.TRANSPARENT);
			        		NewPatient.patient.getTeeth()[position].setExisting(false);
			        	}
					}
				});
	            
	            convertView.setTag(viewHolder);
	        } else {
	            viewHolder = (ViewHolder) convertView.getTag();
	        }

	        return convertView;
	    }
}
