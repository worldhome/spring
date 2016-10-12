package com.keeper.util;

import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class DateEditorRegistrar implements PropertyEditorRegistrar {
	private DateSupportEditor editor;

	public DateSupportEditor getEditor() {
		return editor;
	}

	public void setEditor(DateSupportEditor editor) {
		this.editor = editor;
	}

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, editor);
	}

}
