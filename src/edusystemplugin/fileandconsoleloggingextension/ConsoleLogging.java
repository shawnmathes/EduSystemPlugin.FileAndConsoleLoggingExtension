package edusystemplugin.fileandconsoleloggingextension;

import edusystemplugin.extensions.IEduLogging;

public class ConsoleLogging implements IEduLogging {

	public ConsoleLogging() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeLog(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
