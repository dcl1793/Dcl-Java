package hs.dcl.test.service.impl;

import hs.dcl.test.common.ErrorEnum;
import hs.dcl.test.common.Result;
import hs.dcl.test.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author dacl30868
 * @description:
 * @date 2020/7/30 10:37
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${FILE_URL}")
    private String fileUrl;

    @Override
    public Result fileupload(MultipartFile file) {


        String fileName = file.getOriginalFilename();
        long size = file.getSize();

        String url = fileUrl + "/";
        File filePath = new File(url);
        if (!filePath.isDirectory()) {
            filePath.mkdirs();
        }
        File dest = new File(filePath, fileName);
        try {

            //上传文件
            file.transferTo(dest);

//            //设置允许上传文件类型
//            String suffixList = "doc,docx,xls,xlsx,pdf";
//            // 获取文件后缀
//            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//            if (!(suffixList.contains(suffix.trim().toLowerCase()))) {
//                return Result.failed(ErrorEnum.OPERATION_FAILED, "文件格式不支持！");
//            }

        } catch (Exception e) {
            log.error("上传失败", e);
            return Result.failed(ErrorEnum.OPERATION_FAILED, "上传失败！");
        }
        return Result.success();
    }
}
