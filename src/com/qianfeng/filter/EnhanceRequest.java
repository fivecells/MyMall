package com.qianfeng.filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EnhanceRequest  extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	
	public EnhanceRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
		
	}

	@Override
	    public String getParameter(String name) {
		String name_old = request.getParameter(name);
		String name_new = null;
		if(name_old!=null){
			try {
				name_new = new String(name_old.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("name_new"+name_new);
	        return name_new;
	    }
	@Override
	    public Map<String, String[]> getParameterMap() {
		    Map<String, String[]> map_old = request.getParameterMap();
		    Map<String, String[]> map_new = new HashMap<String, String[]>();
		    if (map_old!=null) {
			Set<Entry<String, String[]>> entrySet = map_old.entrySet();
			Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
			try {
				while (iterator.hasNext()) {
					Entry<String, String[]> entry = iterator.next();
					String key = entry.getKey();
					String key_new = new String(key.getBytes("iso-8859-1"),
							"utf-8");
					String[] value = entry.getValue();
					String[] value_new = new String[value.length];
					for (int i = 0; i < value.length; i++) {
						String str = value[i];
						String str_new = new String(
								str.getBytes("iso-8859-1"),
								"utf-8");
						value_new[i] = str_new;
					}
					map_new.put(key_new, value_new);
				}
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			} 
		}
	       return map_new;
	   }
	
}
