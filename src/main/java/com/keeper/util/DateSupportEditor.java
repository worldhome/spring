package com.keeper.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSupportEditor extends PropertyEditorSupport {
	private String format;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			Date date = dateFormat.parse(text);
			this.setValue(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
