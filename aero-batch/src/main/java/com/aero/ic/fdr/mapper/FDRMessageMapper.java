package com.aero.ic.fdr.mapper;

import com.aero.ic.AeroApplicationConfig;
import com.aero.ic.batch.context.ParserContext;
import com.aero.ic.batch.mapper.EdifactMessageMapper;
import com.aero.ic.fdr.message.IFLIRRMessage;
import com.aero.ic.mapping.EdiMapping;
import com.aero.ic.mapping.SegmentType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import java.io.File;

/**
 * Created by nairr5 on 7/25/16.
 */
public class FDRMessageMapper extends EdifactMessageMapper {

    private Log log = LogFactory.getLog(IFLIRRMessage.class);

    private ParserContext parserContext;

    @Autowired
    private AeroApplicationConfig aeroApplicationConfig;

    public FDRMessageMapper() throws Exception {

    }

    @PostConstruct
    public void postConstruct() throws Exception {
        Assert.notNull(parserContext);
    }

    @Override
    public ParserContext getParserContext() {
        return parserContext;
    }


    public void setParserContext(ParserContext parserContext) {
        this.parserContext = parserContext;
    }

}
