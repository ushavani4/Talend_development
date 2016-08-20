package com.aero.ic.batch.reader.message;

import com.aero.ic.batch.config.EdifactTerminatorPolicy;
import com.aero.ic.batch.exception.BatchException;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by nairr5 on 7/25/16.
 */
public class DefaultEdifactMessageReaderFactory implements EdifactMessageReaderFactory {

    @Override
    public EdifactMessageReader create(Resource resource, EdifactTerminatorPolicy policy, String encoding) throws BatchException {
        try {
            return new DefaultEdifactMessageReader(resource, policy, encoding);
        } catch (IOException e) {
            throw new BatchException("Caught exception while setting up Reader", e);
        }
    }
}
