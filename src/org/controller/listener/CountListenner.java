package org.controller.listener;

import java.sql.SQLException;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.service.impl.CountService;

@WebListener
public class CountListenner implements HttpSessionAttributeListener {
	
	CountService service = new CountService();
	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	HttpSession session = event.getSession();
    	String visit= (String) session.getAttribute("visit");
    	if(!visit.equals("")){
    		try {
				service.updateCount();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

	
}
