package com.aero.ic.batch.reader.message;

import com.aero.ic.batch.config.EdifactTerminatorPolicy;
import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nairr5 on 7/25/16.
 */
public class DefaultEdifactMessageReader implements EdifactMessageReader {

    private Log log = LogFactory.getLog(DefaultEdifactMessageReader.class);

    private EdifactTerminatorPolicy policy = new EdifactTerminatorPolicy();

    private Scanner scanner;

    public DefaultEdifactMessageReader(Resource resource, EdifactTerminatorPolicy policy, String encoding) throws IOException {
        this.policy = policy;

        this.scanner = new Scanner(resource.getInputStream(), encoding);
        this.scanner.useDelimiter(policy.getSegmentTerminator());
    }

    @Override
    public List<String> readMessage() {
        List<String> lines = null;
        boolean headerStarted = false;

        String str = null;
        while(scanner.hasNext()) {
            str = scanner.next();
            str = str.replaceAll("\\x1F", ":");
            str = str.replaceAll("\\x1D", "+");

            if(StringUtils.startsWithIgnoreCase(str, "UNH")) {
                log.debug("Found Message start [" + str + "]");
                lines = Lists.newArrayList();
                headerStarted = true;
            }

            if(headerStarted) {
                lines.add(str);
            }

            if(StringUtils.startsWithIgnoreCase(str, "UNT")) {
                log.debug("Reached Message Trailer");
                break;
            }

            if(StringUtils.startsWithIgnoreCase(str, "UNZ")) {
                log.debug("Finished reading file");
                return lines;
            }
        }

        log.debug("Returning lines [" + (CollectionUtils.isEmpty(lines) ? 0 : lines.size()) + "]");
        return lines;
    }

    @Override
    public void close() {
        if(this.scanner != null) {
            this.scanner.close();
        }

    }
}
