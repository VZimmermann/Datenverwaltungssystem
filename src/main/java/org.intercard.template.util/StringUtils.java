package org.intercard.template.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

	public static final String listToString(
			@SuppressWarnings("rawtypes") List list) {
		StringBuilder sb = new StringBuilder();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				String s = o == null ? "<null>" : o.toString();
				sb.append(i == 0 ? s : ", " + s);
			}
		}
		return sb.toString();
	}

	public static final String listToString(Object[] array) {
		return listToString(Arrays.asList(array));
	}

	public static final boolean isMailadress(String mail) {
		return Pattern.matches("[\\w|-]+@\\w[\\w|-]*\\.[a-z]{2,3}", mail);
		//
	}

	public static boolean isNotBlank(String redirectValue) {
		if (!redirectValue.isEmpty()) {
			if (!redirectValue.trim().isEmpty())
				return true;
		}
		return false;
	}
}
