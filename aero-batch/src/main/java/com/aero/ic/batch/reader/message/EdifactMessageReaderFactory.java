package com.aero.ic.batch.reader.message;

import com.aero.ic.batch.config.EdifactTerminatorPolicy;
import com.aero.ic.batch.exception.BatchException;
import org.springframework.core.io.Resource;

/**
 * Created by nairr5 on 7/25/16.
 */
public interface EdifactMessageReaderFactory {

    EdifactMessageReader create(Resource resource, EdifactTerminatorPolicy policy, String encoding) throws BatchException;
}
