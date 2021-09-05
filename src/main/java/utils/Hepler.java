package utils;



import model.Nguoidung;
import model.Video;

public class Hepler {
	public static boolean checkRong(Nguoidung x) {
		if(x.getEmail().equals("")) {
			
			return true;
		}
		if(x.getFullname().equals("")) {
			
			return true;
		}
		if(x.getId().equals("")) {
			
			return true;
		}
		if(x.getPassword().equals("")) {
			
			return true;
		}
		return false;
	}
	public static boolean checkRong(Video x) {
		if(x.getDescripiton().equals("")) {
			
			return true;
		}
		if(x.getPoster().equals("")) {
			
			return true;
		}
		if(x.getId().equals("")) {
			
			return true;
		}
		if(x.getTitle().equals("")) {
			
			return true;
		}
		if(String.valueOf(x.getViews()).equals("")) {
			
			return true;
		}
		return false;
	}

}
