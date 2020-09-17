package hs.dcl.test.service;

import hs.dcl.test.common.ResultBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dacl30868
 * @date 2020/7/30 10:36
 */
public interface FileUploadService {

    ResultBody fileupload(MultipartFile file);
}
