package vn.asiantech.learnenglish.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.asiantech.learnenglish.R;
import vn.asiantech.learnenglish.model.TopModel;

public class ListTopAdapter extends BaseAdapter {
	
	Context mContext;
	ArrayList<TopModel> mListContacts=new ArrayList<TopModel>();
	/**
	 * 
	 * @param mContext
	 * @param arr
	 */
	public ListTopAdapter(Context mContext, ArrayList<TopModel> arr){
		super();
		this.mContext=mContext;
		this.mListContacts=arr;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListContacts.size();
	}

	@Override
	public TopModel getItem(int position) {
		// TODO Auto-generated method stub
		return mListContacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public class ViewHolder {
		ImageView mAvatar;
		TextView mTitle;
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {
				
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_top, parent, false);
            holder = new ViewHolder();            
            holder.mAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);
            holder.mTitle = (TextView) convertView.findViewById(R.id.txtTitle);

            convertView.setTag(holder);
        } else {        	
            holder = (ViewHolder) convertView.getTag();
        }
			final TopModel topModel= getItem(position);
			holder.mAvatar.setImageResource(topModel.getIdAvatar());
		    holder.mTitle.setText(topModel.getTitle());
        return convertView;
	}
}
