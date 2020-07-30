package hs.dcl.test.service;

import hs.dcl.test.common.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dacl30868
 * @date 2020/7/30 10:36
 */
public interface FileUploadService {

    Result fileupload(MultipartFile file);
}
