package com.aero.ic.batch.writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.List;

/**
 * Created by nairr5 on 7/25/16.
 */
public abstract class EdifactFileItemWriter<EdifactMessage> extends AbstractItemStreamItemWriter<EdifactMessage> implements ResourceAwareItemWriterItemStream<EdifactMessage>, InitializingBean {

    private Log log = LogFactory.getLog(EdifactFileItemWriter.class);

    @Override
    public void write(List<? extends EdifactMessage> messages) throws Exception {
        doWrite(messages);
    }

    protected abstract void doWrite(List<? extends EdifactMessage> messages);

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
