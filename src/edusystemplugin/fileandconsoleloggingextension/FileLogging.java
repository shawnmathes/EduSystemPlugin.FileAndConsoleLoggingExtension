package edusystemplugin.fileandconsoleloggingextension;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import edusystemplugin.extensions.IEduLogging;

public class FileLogging implements IEduLogging {

	private static String logfile = Configuration.getDataRoot()
			+ "edusystem.log";
	private static String auditlog = Configuration.getDataRoot()
			+ "edusystem-audit.log";

	public FileLogging() {

	}

	@Override
	public void writeLog(String message) {
		fileAppend(getDate() + " " + message, logfile);
	}

	@Override
	public void writeDebug(String message) {
		fileAppend(getDate() + " " + message, logfile);
	}

	@Override
	public void writeInfo(String message) {
		fileAppend(getDate() + " " + message, logfile);
	}

	@Override
	public void writeError(String message) {
		fileAppend(getDate() + " " + message, logfile);
	}

	@Override
	public void writeAudit(String message) {
		fileAppend(getDate() + " " + message, auditlog);
	}

	private String getDate() {
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(currentDate);
	}

	private void fileAppend(String text, String filepath) {
		  PrintWriter out = null;
		  BufferedWriter bw = null;
		  FileWriter fw = null;
		  try{
		     fw = new FileWriter(filepath, true);
		     bw = new BufferedWriter(fw);
		     out = new PrintWriter(bw);
		     out.println(text);
		  }
		  catch( IOException e ){
		     // File writing/opening failed at some stage.
		  }
		  finally{
		     try{
		        if( out != null ){
		           out.close(); // Will close bw and fw too
		        }
		        else if( bw != null ){
		           bw.close(); // Will close fw too
		        }
		        else if( fw != null ){
		           fw.close();
		        }
		        else{
		           // Oh boy did it fail hard! :3
		        }
		     }
		     catch( IOException e ){
		        // Closing the file writers failed for some obscure reason
		     }
		  }
	}
}
