package hs.dcl.test.controller;

import hs.dcl.test.common.ResultBody;
import hs.dcl.test.service.FileUploadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dacl30868
 * @description: 文件上传
 * @date 2020/7/30 10:33
 */
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传测试
     * @return
     */
    @ApiOperation(value = "上传文档", notes = "上传文档")
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public ResultBody uploadFile(@RequestParam("file") MultipartFile file) {
        return fileUploadService.fileupload(file);
    }
}
