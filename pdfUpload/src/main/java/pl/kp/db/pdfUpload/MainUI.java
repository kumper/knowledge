package pl.kp.db.pdfUpload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI
public class MainUI extends UI {
	
	private final Logger LOG = LoggerFactory.getLogger(MainUI.class);
	
	@Autowired
	private MyDocumentRepository dao;
	
	private Upload pdfUpload;
	
	private Button downloadBtn = new Button("Download uploaded content", FontAwesome.DOWNLOAD);

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);

		downloadBtn.setEnabled(false);
		
		final MyDocument doc = new MyDocument();
		
		final DbPdfReceiver receiver = new DbPdfReceiver(doc);
		
		pdfUpload = new Upload("Upload PDF", receiver);
		
		layout.addComponent(pdfUpload);
		layout.addComponent(downloadBtn);
		
		pdfUpload.addSucceededListener(receiver);

	}
	
	private class DbPdfReceiver implements Receiver, SucceededListener {
		private MyDocument entity;
		private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		public DbPdfReceiver(MyDocument entity) {
			this.entity = entity;
		}

		@Override
		public OutputStream receiveUpload(String filename, String mimeType) {
			entity.setFilename(filename);
			
			return baos;
		}

		@Override
		public void uploadSucceeded(SucceededEvent event) {
			entity.setModified(new Date());
			
			entity.setPdfContent(baos.toByteArray());
			
			entity = dao.save(entity);
			
			downloadBtn.setEnabled(true);
			
			LOG.info("Successfully wrote entity {}", entity);
			
			LOG.info("Objects in database: {}", dao.findAll().size());
			


			MyDocument doc;
			doc = dao.findAll().get(0);
			
	        StreamSource ss = new StreamSource() {
	            InputStream is = new ByteArrayInputStream(doc.getPdfContent());
	            @Override
	            public InputStream getStream() {
	                return is;
	            }
	        };
	        StreamResource sr = new StreamResource(ss, doc.getFilename());
			FileDownloader fd = new FileDownloader(sr);
	        fd.extend(downloadBtn);
		}
	}

}
