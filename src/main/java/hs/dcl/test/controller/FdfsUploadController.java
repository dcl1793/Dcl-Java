package hs.dcl.test.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hs.dcl.test.common.CommonEnum;
import hs.dcl.test.common.ResultBody;
import hs.dcl.test.util.FastDFSClientUtil;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dacl30868
 * @description:fdfs相关
 * @date 2020/9/21 10:20
 */
@RestController
@Api(value = "fastdfs", description = "文件管理")
@RequestMapping(value = "/fDfs")
public class FdfsUploadController {

    @Autowired
    private FastDFSClientUtil dfsClient;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultBody fdfsUpload(@RequestParam("file") MultipartFile file) {

        try {
            String fileUrl = dfsClient.uploadFile(file);
            System.out.println(fileUrl);
            return ResultBody.success();
        } catch (IOException e) {
            e.printStackTrace();
            return ResultBody.failed(CommonEnum.INTERNAL_SERVER_ERROR,"上传失败！");
        }
    }

    /**
     * http://localhost/download?filePath=group1/M00/00/00/wKgIZVzZEF2ATP08ABC9j8AnNSs744.jpg
     */
    @PostMapping("/download")
    public ResultBody download(String filePath ,HttpServletRequest request ,HttpServletResponse response) throws IOException {

        //group1/M00/00/00/wKgIZVzZEF2ATP08ABC9j8AnNSs744.jpg
        String[] paths = filePath.split("/");
        String groupName = null ;
        for (String item : paths) {
            if (item.indexOf("group") != -1) {
                groupName = item;
                break ;
            }
        }
        //获取组内文件路径
        String path = filePath.substring(filePath.indexOf(groupName) + groupName.length() + 1);
        InputStream input = dfsClient.download(groupName, path);

        //根据文件名获取 MIME 类型
        String fileName = paths[paths.length-1] ;
        String contentType = request.getServletContext().getMimeType(fileName);
        String contentDisposition = "attachment;filename=" + fileName;
        // 设置头
        response.setHeader("Content-Type",contentType);
        response.setHeader("Content-Disposition",contentDisposition);
        // 获取绑定了客户端的流
        ServletOutputStream output = response.getOutputStream();
        // 把输入流中的数据写入到输出流中
        IOUtils.copy(input,output);
        input.close();
        return ResultBody.success();
    }

    /**
     * http://localhost/deleteFile?filePath=group1/M00/00/00/wKgIZVzZaRiAZemtAARpYjHP9j4930.jpg
     * @param filePath  group1/M00/00/00/wKgIZVzZaRiAZemtAARpYjHP9j4930.jpg
     * @return
     */
    @DeleteMapping("/deleteFile")
    public ResultBody delFile(String filePath)  {
        try {
            dfsClient.delFile(filePath);
        } catch(Exception e) {
            e.printStackTrace();
            return ResultBody.failed(CommonEnum.INTERNAL_SERVER_ERROR,"删除失败！");
        }
        return ResultBody.success();
    }
}
