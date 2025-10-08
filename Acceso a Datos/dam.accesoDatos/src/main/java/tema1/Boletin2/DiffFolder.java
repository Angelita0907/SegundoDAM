package tema1.Boletin2;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiffFolder {
	private static final Logger logger = LogManager.getLogger(DiffFolder.class);

	private File directorio1;
	private File directorio2;
	
	public DiffFolder(File directorio1, File directorio2) {
		super();
		this.directorio1 = directorio1;
		this.directorio2 = directorio2;
	}

	public File getDirectorio1() {
		return directorio1;
	}

	public void setDirectorio1(File directorio1) {
		this.directorio1 = directorio1;
	}

	public File getDirectorio2() {
		return directorio2;
	}

	public void setDirectorio2(File directorio2) {
		this.directorio2 = directorio2;
	}
	
	

}
