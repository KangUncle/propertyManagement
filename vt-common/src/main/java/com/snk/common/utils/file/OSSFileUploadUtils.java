package com.snk.common.utils.file;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.snk.common.constant.OssConstant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OSSFileUploadUtils {


    /**
     * 文件上传
     * @param objectKey
     * @param multipartFile
     * @throws OSSException
     * @throws ClientException
     * @throws FileNotFoundException
     */
    public static void uploadFile(String objectKey , MultipartFile multipartFile)
    throws OSSException, ClientException, FileNotFoundException {
        OSS ossClient = new OSSClientBuilder().build(OssConstant.endpoint, OssConstant.accessKeyId, OssConstant.accessKeySecret);
        try{
            InputStream inputStream = multipartFile.getInputStream();
            PutObjectRequest putObjectRequest = new PutObjectRequest(OssConstant.publicBucketName, objectKey, inputStream);
            ossClient.putObject(putObjectRequest);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            ossClient.shutdown();


        }
    }

}
