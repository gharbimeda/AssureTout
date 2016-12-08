package tn.esprit.assuretout.managedbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@SessionScoped
public class FileUploadView {

	private File file;
	static String filePath = new String();

	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			
			
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		
		try {
			file = new File(path + "/resources/sinistreImg/" + event.getFile().getFileName());
			filePath=event.getFile().getFileName();
			InputStream is = event.getFile().getInputstream();
		    OutputStream out = new FileOutputStream(file);
		    byte buf[] = new byte[1024];
		    int len;
		    while ((len = is.read(buf)) > 0)
		        out.write(buf, 0, len);
		    is.close();
		    out.close();
			
			
			FacesMessage msg = new FacesMessage("Succesful", event.getFile()
					.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getFilePath() {
		return filePath;
	}

}
