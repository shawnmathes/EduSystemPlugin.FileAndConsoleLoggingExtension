package edusystemplugin.fileandconsoleloggingextension;

import edusystemplugin.extensions.IEduLogging;

public class ConsoleLogging implements IEduLogging {

	public ConsoleLogging() {

	}

	@Override
	public void writeLog(String message) {
		System.out.println(message);
	}

	@Override
	public void writeDebug(String message) {
		System.out.println("DEBUG: " + message);
	}

	@Override
	public void writeInfo(String message) {
		System.out.println("INFO:  " + message);
	}

	@Override
	public void writeError(String message) {
		System.out.println("ERROR: " + message);
	}

	@Override
	public void writeAudit(String message) {
		System.out.println("AUDIT: " + message);
	}

}
