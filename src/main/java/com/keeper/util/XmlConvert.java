package com.keeper.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class XmlConvert {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public Marshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public String convertXml(Object obj) throws XmlMappingException, IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		marshaller.marshal(obj, new StreamResult(output));
		return new String(output.toByteArray(),"utf-8");
	}

	public Object convertObject(String xml) throws XmlMappingException, IOException {
		Object obj = unmarshaller.unmarshal(new StreamSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
		return obj;
	}
}
