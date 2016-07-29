package com.edi.service;

import com.edi.config.ApplicationConfiguration;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nairr5 on 7/6/16.
 */

@Component
public class EdifactParser {

    private Logger log = LoggerFactory.getLogger(EdifactParser.class);

    @Autowired
    private ApplicationConfiguration applicationConfiguration;


    public void useScanner() throws Exception {

        File dropLocation = new File(applicationConfiguration.getDropLocation());

        log.debug("Drop location at [" + dropLocation + "] looking for Edifact files...");

        File [] files = dropLocation.listFiles();
        Arrays.stream(files).forEach(f -> {
            try {
                parse(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void parse(File f) throws Exception {
        InputStream stream = Files.newInputStream(f.toPath(), StandardOpenOption.READ);

        Scanner scanner = new Scanner(stream, "UTF-8");

        //this is the segment terminator '
        scanner.useDelimiter("\\x1C");
        String str = null;

        log.debug("Starting to read file from location [" + f.getAbsolutePath() + "]");

        File outFile = new File(FilenameUtils.concat(applicationConfiguration.getOutputLocation(), f.getName() + ".txt"));
        FileUtils.deleteQuietly(outFile);
        //FileUtils.touch(outFile);

        BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(outFile.getPath()),
                Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);

        //read each line and replace the Hex character with : and +
        while (scanner.hasNext()) {

            str = scanner.next();
            str = str.replaceAll("\\x1F", ":");
            str = str.replaceAll("\\x1D", "+");

            writer.write(str);
        }

        IOUtils.closeQuietly(writer);
    }

}

