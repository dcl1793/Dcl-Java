package hs.dcl.test.service.impl;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String readTxtFile() {

        try {
            byte[] bytes;

            ClassPathResource classPathResource = new ClassPathResource("c://号码.txt");

            //获取文件流
            InputStream keyStream = classPathResource.getInputStream();
            bytes = IOUtils.toByteArray(keyStream);
            keyStream.read(bytes);
            keyStream.close();

            ByteArrayInputStream certBis = new ByteArrayInputStream(bytes);
            InputStreamReader input = new InputStreamReader(certBis);
            BufferedReader bf = new BufferedReader(input);
            String line = null;
            StringBuilder sb = new StringBuilder();

            List<String> oldList = new ArrayList<>();
            oldList.add("1");
            oldList.add("2");
            oldList.add("3");

            List<String> newList =new ArrayList<String>();
            while((line =bf.readLine()) != null){
                newList.add(line);
            }

            newList.retainAll(oldList);

            System.out.println(newList);

            return sb.toString();
        } catch (IOException e) {
            logger.error("读取文件错误",e);
        }
        return "";
    }

}
