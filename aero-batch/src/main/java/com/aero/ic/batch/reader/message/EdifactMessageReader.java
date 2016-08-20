package com.aero.ic.batch.reader.message;

import java.util.List;

/**
 * Created by nairr5 on 7/25/16.
 */
public interface EdifactMessageReader {

    List<String> readMessage();

    void close();
}
