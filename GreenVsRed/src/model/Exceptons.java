package model;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ResourceBundle;

public class Exceptons {
Logger logger=new Logger() {
	
	@Override
	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isLoggable(Level level) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
};
}
