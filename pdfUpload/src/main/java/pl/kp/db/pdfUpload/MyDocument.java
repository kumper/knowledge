package pl.kp.db.pdfUpload;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MyDocument {

	@Id
	@GeneratedValue
	private Long id;
	
	private String filename;
	private Date modified;
	
	@Lob
	private byte[] pdfContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public byte[] getPdfContent() {
		return pdfContent;
	}

	public void setPdfContent(byte[] pdfContent) {
		this.pdfContent = pdfContent;
	}

	@Override
	public String toString() {
		return String.format(
				"MyDocument [id=%s, filename=%s, modified=%s, pdfContent=%s]",
				id, filename, modified, Arrays.toString(pdfContent));
	}

}
