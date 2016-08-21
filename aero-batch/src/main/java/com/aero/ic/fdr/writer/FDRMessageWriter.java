package com.aero.ic.fdr.writer;

import com.aero.ic.batch.writer.EdifactFileItemWriter;
import com.aero.ic.fdr.message.FDRMessage;
import com.aero.ic.fdr.message.IFLIRRMessage;
import com.aero.ic.fdr.message.apd.APD;
import com.aero.ic.fdr.message.eqi.EQI00115;
import com.aero.ic.fdr.message.eqi.EQI00116;
import com.aero.ic.fdr.message.stx.STX;
import com.aero.ic.fdr.message.stx.STX00226;
import com.aero.ic.message.base.EdifactMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
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

    private boolean writeXml;

    private XStream xStream;

    public FDRMessageWriter() {
        xStream = new XStream();
        xStream.alias("fdr", FDRMessage.class);
        xStream.alias("apd", APD.class);
        xStream.alias("eqi00116", EQI00116.class);
        xStream.alias("iflirr", IFLIRRMessage.class);
        xStream.alias("stx00226", STX00226.class);
        xStream.alias("eqi00115", EQI00115.class);
        xStream.ignoreUnknownElements("log");

    }

    public boolean isWriteXml() {
        return writeXml;
    }

    public void setWriteXml(boolean writeXml) {
        this.writeXml = writeXml;
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

            if(writeXml) {
                try {
                    outFolder = resource.getFile().getAbsolutePath();
                    jsonFileName = String.format(fileName, refNo, "xml");
                    fullPath = new File(outFolder + "/" + jsonFileName);
                    log.debug("Writing xml [" + fullPath + "]");

                    FileUtils.write(fullPath, xStream.toXML(message), "UTF-8");
                } catch (Exception e) {
                    log.error("Failed to write xml result", e);
                }
            }
        }

    }
}
