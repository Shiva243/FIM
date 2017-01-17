package com.fin.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

public class ResponseUtil {
	@SuppressWarnings("unchecked")
	public static JSONObject getJsonObject(String status, String errorCode, String errorMesg) {
		JSONObject obj = new JSONObject();
		obj.put("status", status);
		obj.put("errorCode", errorCode);
		obj.put("errorMesg", errorMesg);
		return obj;
	}
	public static Long getCurrentDateTime(){
		return Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYddHHmmssSSS")));
	}
}
