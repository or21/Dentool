package tools;

import java.util.ArrayList;
import java.util.HashMap;

import tools.Tooth.State;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.dentool.NewPatient;
import com.example.dentool.R;

public class ImplantsAdapter extends ArrayAdapter<Tooth>{
	
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
	
	private int[] damage = {R.drawable.dental_implants__damage_18, R.drawable.dental_implants__damage_17, R.drawable.dental_implants__damage_16,
			R.drawable.dental_implants__damage_15, R.drawable.dental_implants__damage_14, R.drawable.dental_implants__damage_13, R.drawable.dental_implants__damage_12,
			R.drawable.dental_implants__damage_11, R.drawable.dental_implants__damage_21, R.drawable.dental_implants__damage_22, R.drawable.dental_implants__damage_23,
			R.drawable.dental_implants__damage_24, R.drawable.dental_implants__damage_25, R.drawable.dental_implants__damage_26, R.drawable.dental_implants__damage_27, R.drawable.dental_implants__damage_28,
			R.drawable.dental_implants_damage_48, R.drawable.dental_implants__damage_47, R.drawable.dental_implants__damage_46, R.drawable.dental_implants__damage_45, R.drawable.dental_implants__damage_44,
			R.drawable.dental_implants__damage_43, R.drawable.dental_implants__damage_42, R.drawable.dental_implants__damage_41, R.drawable.dental_implants__damage_31, R.drawable.dental_implants__damage_32,
			R.drawable.dental_implants__damage_33, R.drawable.dental_implants__damage_34, R.drawable.dental_implants__damage_35, R.drawable.dental_implants__damage_36,
			R.drawable.dental_implants__damage_37, R.drawable.dental_implants__damage_38 };
	private int[] fix = {R.drawable.dental_implants_fix_18, R.drawable.dental_implants_fix_17, R.drawable.dental_implants_fix_16, R.drawable.dental_implants_fix_15, R.drawable.dental_implants_fix_14,
			R.drawable.dental_implants_fix_13, R.drawable.dental_implants_fix_12, R.drawable.dental_implants_fix_11, R.drawable.dental_implants_fix_21, R.drawable.dental_implants_fix_22, R.drawable.dental_implants_fix_23,
			R.drawable.dental_implants_fix_24, R.drawable.dental_implants_fix_25, R.drawable.dental_implants_fix_26, R.drawable.dental_implants_fix_27, R.drawable.dental_implants_fix_28, R.drawable.dental_implants_fix_48,
			R.drawable.dental_implants_fix_47, R.drawable.dental_implants_fix_46, R.drawable.dental_implants_fix_45, R.drawable.dental_implants_fix_44, R.drawable.dental_implants_fix_43, R.drawable.dental_implants_fix_42,
			R.drawable.dental_implants_fix_41, R.drawable.dental_implants_fix_31, R.drawable.dental_implants_fix_32, R.drawable.dental_implants_fix_33, R.drawable.dental_implants_fix_34, R.drawable.dental_implants_fix_35, 
			R.drawable.dental_implants_fix_36, R.drawable.dental_implants_fix_37, R.drawable.dental_implants_fix_38 };
	private int[] fixAndDamage = {R.drawable.dental_implants_fixanddamage_18, R.drawable.dental_implants_fixanddamage_17, R.drawable.dental_implants_fixanddamage_16, R.drawable.dental_implants_fixanddamage_15,
			R.drawable.dental_implants_fixanddamage_14, R.drawable.dental_implants_fixanddamage_13, R.drawable.dental_implants_fixanddamage_12, R.drawable.dental_implants_fixanddamage_11, R.drawable.dental_implants_fixanddamage_21,
			R.drawable.dental_implants_fixanddamage_22, R.drawable.dental_implants_fixanddamage_23, R.drawable.dental_implants_fixanddamage_24, R.drawable.dental_implants_fixanddamage_25, R.drawable.dental_implants_fixanddamage_26,
			R.drawable.dental_implants_fixanddamage_27, R.drawable.dental_implants_fixanddamage_28, R.drawable.dental_implants_fixanddamage_48, R.drawable.dental_implants_fixanddamage_47, R.drawable.dental_implants_fixanddamage_46,
			R.drawable.dental_implants_fixanddamage_45, R.drawable.dental_implants_fixanddamage_44, R.drawable.dental_implants_fixanddamage_43, R.drawable.dental_implants_fixanddamage_42, R.drawable.dental_implants_fixanddamage_41,
			R.drawable.dental_implants_fixanddamage_31, R.drawable.dental_implants_fixanddamage_32, R.drawable.dental_implants_fixanddamage_33, R.drawable.dental_implants_fixanddamage_34, R.drawable.dental_implants_fixanddamage_35,
			R.drawable.dental_implants_fixanddamage_36, R.drawable.dental_implants_fixanddamage_37, R.drawable.dental_implants_fixanddamage_38 };
	
	HashMap<Integer, State> map = new HashMap<Integer, State>();
	int afterChoose;
	private State state;
	private int index;

	public ImplantsAdapter(Context context, int textViewResourceId, ArrayList<Tooth> items, int index) {
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
		state = NewPatient.patient.getTeeth()[position].getCrowns();

		if (convertView == null) {
			convertView = LayoutInflater.from(this.getContext())
					.inflate(R.layout.implants_layout, parent, false);
			viewHolder = new ViewHolder();

			viewHolder.tb1 = (ToggleButton) convertView.findViewById(R.id.tb1);
			viewHolder.tb1.setBackgroundResource(CrownTeethAdapter.nullArray[newpos]);

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
								viewHolder.tb1.setBackgroundResource(CrownTeethAdapter.nullArray[newpos]);
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
