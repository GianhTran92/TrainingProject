package vn.asiantech.learnenglish.model;

import vn.asiantech.learnenglish.R;

public class TopData {
	static String[] title={"Animal","Vegetables","Transport","Travel"};
	static int[] avatar={
        R.drawable.animal_avatar, R.drawable.animal_avatar, R.drawable.animal_avatar, R.drawable.animal_avatar };

	public static String[] getTitle(){
		return title;
	}
	public static int[] getAvatar(){
		return avatar;
	}


}
