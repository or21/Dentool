package tools;

import java.util.ArrayList;
import java.util.HashMap;

import tools.Tooth.State;

import com.example.dentool.NewPatient;
import com.example.dentool.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CrownTeethAdapter extends ArrayAdapter<Tooth>{
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

	private int[] damage = {R.drawable.existing_crowns_damage_18, R.drawable.existing_crowns_damage_17, R.drawable.existing_crowns_damage_16, R.drawable.existing_crowns_damage_15,
			R.drawable.existing_crowns_damage_14, R.drawable.existing_crowns_damage_13, R.drawable.existing_crowns_damage_12, R.drawable.existing_crowns_damage_11, 
			R.drawable.existing_crowns_damage_21, R.drawable.existing_crowns_damage_22, R.drawable.existing_crowns_damage_23, R.drawable.existing_crowns_damage_24, 
			R.drawable.existing_crowns_damage_25, R.drawable.existing_crowns_damage_26, R.drawable.existing_crowns_damage_27, R.drawable.existing_crowns_damage_28,
			R.drawable.existing_crowns_damage_48, R.drawable.existing_crowns_damage_47, R.drawable.existing_crowns_damage_46, R.drawable.existing_crowns_damage_45, 
			R.drawable.existing_crowns_damage_44, R.drawable.existing_crowns_damage_43, R.drawable.existing_crowns_damage_42, R.drawable.existing_crowns_damage_41, 
			R.drawable.existing_crowns_damage_31, R.drawable.existing_crowns_damage_32, R.drawable.existing_crowns_damage_33, R.drawable.existing_crowns_damage_34, 
			R.drawable.existing_crowns_damage_35, R.drawable.existing_crowns_damage_36, R.drawable.existing_crowns_damage_37, R.drawable.existing_crowns_damage_38 };
	private int[] fix = {R.drawable.existing_crowns_fix_18, R.drawable.existing_crowns_fix_17, R.drawable.existing_crowns_fix_16, R.drawable.existing_crowns_fix_15, 
			R.drawable.existing_crowns_fix_14, R.drawable.existing_crowns_fix_13, R.drawable.existing_crowns_fix_12, R.drawable.existing_crowns_fix_11, R.drawable.existing_crowns_fix_21, 
			R.drawable.existing_crowns_fix_22, R.drawable.existing_crowns_fix_23, R.drawable.existing_crowns_fix_24, R.drawable.existing_crowns_fix_25, R.drawable.existing_crowns_fix_26, 
			R.drawable.existing_crowns_fix_27, R.drawable.existing_crowns_fix_28, R.drawable.existing_crowns_fix_48, R.drawable.existing_crowns_fix_47, R.drawable.existing_crowns_fix_46, 
			R.drawable.existing_crowns_fix_45, R.drawable.existing_crowns_fix_44, R.drawable.existing_crowns_fix_43, R.drawable.existing_crowns_fix_42, R.drawable.existing_crowns_fix_41, 
			R.drawable.existing_crowns_fix_31, R.drawable.existing_crowns_fix_32, R.drawable.existing_crowns_fix_33, R.drawable.existing_crowns_fix_34, R.drawable.existing_crowns_fix_35, 
			R.drawable.existing_crowns_fix_36, R.drawable.existing_crowns_fix_37, R.drawable.existing_crowns_fix_38};
	private int[] fixAndDamage = {R.drawable.existing_crowns_fixanddamage_18, R.drawable.existing_crowns_fixanddamage_17, R.drawable.existing_crowns_fixanddamage_16, 
			R.drawable.existing_crowns_fixanddamage_15, R.drawable.existing_crowns_fixanddamage_14, R.drawable.existing_crowns_fixanddamage_13, R.drawable.existing_crowns_fixanddamage_12,
			R.drawable.existing_crowns_fixanddamage_11, R.drawable.existing_crowns_fixanddamage_21, R.drawable.existing_crowns_fixanddamage_22, R.drawable.existing_crowns_fixanddamage_23, 
			R.drawable.existing_crowns_fixanddamage_24, R.drawable.existing_crowns_fixanddamage_25, R.drawable.existing_crowns_fixanddamage_26, R.drawable.existing_crowns_fixanddamage_27,
			R.drawable.existing_crowns_fixanddamage_28, R.drawable.existing_crowns_fixanddamage_48, R.drawable.existing_crowns_fixanddamage_47, R.drawable.existing_crowns_fixanddamage_46, 
			R.drawable.existing_crowns_fixanddamage_45, R.drawable.existing_crowns_fixanddamage_44, R.drawable.existing_crowns_fixanddamage_44, R.drawable.existing_crowns_fixanddamage_43, 
			R.drawable.existing_crowns_fixanddamage_42, R.drawable.existing_crowns_fixanddamage_41, R.drawable.existing_crowns_fixanddamage_31, R.drawable.existing_crowns_fixanddamage_32, 
			R.drawable.existing_crowns_fixanddamage_33, R.drawable.existing_crowns_fixanddamage_34, R.drawable.existing_crowns_fixanddamage_35, R.drawable.existing_crowns_fixanddamage_36, 
			R.drawable.existing_crowns_fixanddamage_37, R.drawable.existing_crowns_fixanddamage_38};
	public static int[] nullArray = {R.drawable.existing_root_normal_18, R.drawable.existing_root_normal_17, R.drawable.existing_root_normal_16, R.drawable.existing_root_normal_15,R.drawable.existing_root_normal_14,
			R.drawable.existing_root_normal_13,R.drawable.existing_root_normal_12,R.drawable.existing_root_normal_11, R.drawable.existing_root_normal_21, R.drawable.existing_root_normal_22,
			R.drawable.existing_root_normal_23, R.drawable.existing_root_normal_24, R.drawable.existing_root_normal_25, R.drawable.existing_root_normal_26, R.drawable.existing_root_normal_27, R.drawable.existing_root_normal_28,
			R.drawable.existing_root_normal_48, R.drawable.existing_root_normal_47, R.drawable.existing_root_normal_46, R.drawable.existing_root_normal_45, R.drawable.existing_root_normal_44, R.drawable.existing_root_normal_43, 
			R.drawable.existing_root_normal_42, R.drawable.existing_root_normal_41, R.drawable.existing_root_normal_31, R.drawable.existing_root_normal_32, R.drawable.existing_root_normal_33, R.drawable.existing_root_normal_34, 
			R.drawable.existing_root_normal_35, R.drawable.existing_root_normal_36, R.drawable.existing_root_normal_37, R.drawable.existing_root_normal_38};

	HashMap<Integer, State> map = new HashMap<Integer, State>();
	int afterChoose;
	private int index;

	public CrownTeethAdapter(Context context, int textViewResourceId, ArrayList<Tooth> items, int index) {
		super(context, textViewResourceId, items);
		this.index = index;
		map.put(0, State.NULL);
		map.put(1, State.EXISTING);
		map.put(2, State.DEFECTIVE);
		map.put(3, State.NOTURGENT);
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		final int newpos = position + (index * 16);

		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext())
					.inflate(R.layout.crowns_layout, parent, false);
			viewHolder = new ViewHolder();

			viewHolder.tb1 = (ToggleButton) convertView.findViewById(R.id.tb1);
			
			State currState = NewPatient.patient.getTeeth()[position].getCrowns();
			int color = 0;
			if (currState.equals(State.NULL)) {
				color = CrownTeethAdapter.nullArray[newpos];
			}
			else if(currState.equals(State.DEFECTIVE)) {
				color = damage[newpos];
			} 
			else if(currState.equals(State.EXISTING)) {
				color = fix[newpos];
			}
			else if(currState.equals(State.NOTURGENT)) {
				color = fixAndDamage[newpos];
			}
			
			if (NewPatient.patient.getTeeth()[position].getExisting()) {
				viewHolder.tb1.setBackgroundResource(color);
			}
			else {
				viewHolder.tb1.setBackgroundResource(Color.TRANSPARENT);
				viewHolder.tb1.setClickable(false);
			}

			viewHolder.tb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				private String[] items = {"NULL", "EXISTING", "DEFECTIVE", "NOT URGENT"};

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					AlertDialog.Builder builder = new AlertDialog.Builder(viewHolder.tb1.getContext());
					builder.setSingleChoiceItems(items, 0, null)
					.setItems(items , new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {

							afterChoose = ((AlertDialog)dialog).getListView().getCheckedItemPosition();

							State chosenState = map.get(afterChoose);

							if(chosenState.equals(State.NULL)) {
								viewHolder.tb1.setBackgroundResource(nullArray[newpos]);
							}
							else if(chosenState.equals(State.DEFECTIVE)) {
								viewHolder.tb1.setBackgroundResource(damage[newpos]);
							} 
							else if(chosenState.equals(State.EXISTING)) {
								viewHolder.tb1.setBackgroundResource(fix[newpos]);
							}
							else if(chosenState.equals(State.NOTURGENT)) {
								viewHolder.tb1.setBackgroundResource(fixAndDamage[newpos]);
							}
							NewPatient.patient.getTeeth()[newpos].setCrowns(chosenState);
							dialog.dismiss();
						}
					}).create().show();
				}
			});
		}
		else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
}