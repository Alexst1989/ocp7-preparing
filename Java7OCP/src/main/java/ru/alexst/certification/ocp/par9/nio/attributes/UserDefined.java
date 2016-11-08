package ru.alexst.certification.ocp.par9.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDefined {
    
    private static final Logger LOG = LogManager.getLogger(UserDefined.class);

    public static void main(String[] args) throws IOException {
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(Paths.get("C:/alexfiles"), UserDefinedFileAttributeView.class);
        List<String> list = userView.list();
        for (String s:list) {
            LOG.info(s);
        }
        LOG.info("END");
        
    }

}
