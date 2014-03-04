package edusystemplugin.fileandconsoleloggingextension;

import edusystemplugin.extensions.IEduLogging;

public class FileLogging implements IEduLogging {

	private static String logfile = Configuration.getDataRoot()
			+ "edusystem.log";
	
	public FileLogging() {
		
	}

	@Override
	public void writeLog(String message) {
		WriteFile writefile = new WriteFile();
		writefile.writeString(message, logfile);
	}
}
