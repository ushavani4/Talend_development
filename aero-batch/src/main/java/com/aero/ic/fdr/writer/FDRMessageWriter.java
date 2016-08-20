package com.aero.ic.fdr.writer;

import com.aero.ic.batch.writer.EdifactFileItemWriter;
import com.aero.ic.fdr.message.FDRMessage;
import com.aero.ic.fdr.message.IFLIRRMessage;
import com.aero.ic.message.base.EdifactMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * Created by nairr5 on 8/20/16.
 */
public class FDRMessageWriter extends EdifactFileItemWriter<EdifactMessage> {

    private Log log = LogFactory.getLog(EdifactFileItemWriter.class);

    private String encoding;

    private Resource resource;

    private String outFolder;

    private boolean writeJson;

    public boolean isWriteJson() {
        return writeJson;
    }

    public void setWriteJson(boolean writeJson) {
        this.writeJson = writeJson;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    protected void doWrite(List<? extends EdifactMessage> edifactMessages) {

        String refNo = null;
        Date date = new Date();
        String fileName = "FDR_%s.%s";
        String jsonFileName = null;
        File fullPath = null;


        for (EdifactMessage message : edifactMessages) {
            refNo = String.valueOf(date.getTime());

            if(writeJson) {
                try {
                    outFolder = resource.getFile().getAbsolutePath();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    jsonFileName = String.format(fileName, refNo, "json");
                    fullPath = new File(outFolder + "/" + jsonFileName);
                    log.debug("Writing Json [" + fullPath + "]");
                    FileUtils.write(fullPath, gson.toJson(message), "UTF-8");
                } catch (Exception e) {
                    log.error("Failed to write Json result", e);
                }
            }
        }

    }
}
