package com.accenture.tmt.common;

public class ValidateObjects {
	
	public static boolean isStringEmpty(String stringAtr) {
		boolean flag = false;
		if ((stringAtr.equals(""))
				|| (stringAtr.equals(null) || (stringAtr.isEmpty()))) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
}
