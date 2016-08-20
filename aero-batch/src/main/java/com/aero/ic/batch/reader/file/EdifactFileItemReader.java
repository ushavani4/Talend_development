package com.aero.ic.batch.reader.file;

import com.aero.ic.batch.config.EdifactTerminatorPolicy;
import com.aero.ic.batch.exception.BatchException;
import com.aero.ic.batch.reader.message.DefaultEdifactMessageReaderFactory;
import com.aero.ic.batch.mapper.EdifactMessageMapper;
import com.aero.ic.batch.reader.message.EdifactMessageReader;
import com.aero.ic.batch.reader.message.EdifactMessageReaderFactory;
import com.aero.ic.message.base.EdifactMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by nairr5 on 7/25/16.
 */

public class EdifactFileItemReader extends AbstractItemCountingItemStreamItemReader<EdifactMessage> implements ResourceAwareItemReaderItemStream<EdifactMessage>, InitializingBean {

    private Log log = LogFactory.getLog(EdifactFileItemReader.class);

    private Resource resource;

    private EdifactTerminatorPolicy edifactTerminatorPolicy;

    private boolean noInput;

    private boolean strict;

    private String encoding = "UTF-8";

    private EdifactMessageReaderFactory messageReaderFactory = new DefaultEdifactMessageReaderFactory();

    private EdifactMessageReader messageReader;

    private EdifactMessageMapper edifactMessageMapper;

    private List<String> readRecord() throws BatchException {

        if(noInput) {
            return null;
        }

        if(this.messageReader == null) {
            throw new BatchException("Reader must be open before it can be read.");
        }

        return this.messageReader.readMessage();
    }

    @Override
    protected EdifactMessage doRead() throws BatchException {
        Assert.notNull(this.edifactMessageMapper, "Edifact Message mapper must be set");
        List<String> lines = this.readRecord();
        if(CollectionUtils.isEmpty(lines)) {
            return null;
        }
        try {
            return this.edifactMessageMapper.map(lines);
        } catch (Exception e) {
            throw new BatchException("Caught exception while mapping edi message ", e);
        }
    }

    @Override
    protected void doOpen() throws Exception {
        Assert.notNull(this.resource, "Input resource must be set");
        Assert.notNull(this.edifactTerminatorPolicy, "Edifact Terminator policy must be set");
        log.info("Opening resource [" + this.resource.getDescription() + "] for parsing ...");
        this.noInput = true;
        if(! this.resource.exists()) {
            if(this.strict) {
                throw new IllegalStateException("Input resource must exist (reader is in \'strict\' mode): " + this.resource);
            } else {
                log.warn("Input resource does not exist " + this.resource.getDescription());
            }
        } else if(!this.resource.isReadable()) {
            if(this.strict) {
                throw new IllegalStateException("Input resource must be readable (reader is in \'strict\' mode): " + this.resource);
            } else {
                log.warn("Input resource is not readable " + this.resource.getDescription());
            }
        } else {
            //check the content length, if its 0 then we don't need to read further
            this.noInput = resource.contentLength() <= 0;
            this.messageReader = messageReaderFactory.create(resource, edifactTerminatorPolicy, encoding);
            log.debug("Created Message Reader for resource [" + this.resource.getDescription() + "]");
        }
    }

    @Override
    protected void doClose() throws Exception {
        if(this.messageReader != null) {
            this.messageReader.close();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.edifactMessageMapper, "Edifact Message mapper must be set");
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setEdifactTerminatorPolicy(EdifactTerminatorPolicy edifactTerminatorPolicy) {
        this.edifactTerminatorPolicy = edifactTerminatorPolicy;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setEdifactMessageMapper(EdifactMessageMapper edifactMessageMapper) {
        this.edifactMessageMapper = edifactMessageMapper;
    }

    public void setMessageReaderFactory(EdifactMessageReaderFactory messageReaderFactory) {
        this.messageReaderFactory = messageReaderFactory;
    }
}
