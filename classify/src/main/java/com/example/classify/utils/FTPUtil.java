package com.example.classify.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.utils
 * @file FTPUtil 创建时间:2020-3-31
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class FTPUtil {

    //ftp服务器ip地址 net:192.168.15.128 桥接:192.168.43.90 阿里:39.106.209.58
    private static final String FTP_ADDRESS = "39.106.209.58";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "ftpuser";
    //密码
    private static final String FTP_PASSWORD = "ftp221710"; //cc221710 ftp221710
    //图片路径
    private static final String FTP_BASEPATH = "./www/images/";

    public static String[] uploadFile(List<MultipartFile> images){
        String[] result = new String[images.size()];
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            Boolean flag = ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            ftp.changeWorkingDirectory(FTP_BASEPATH );
            int i = 0;
            InputStream inputStream = null;
            for(MultipartFile image:images){
                try{
                    if (!image.isEmpty()) {
                        //获取图片或文件的后缀名
                        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
                        //拼接图片或文件名称，32位随机uuid+后缀名
                        String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase() + suffix;
                        result[i++] = "http://"+ FTP_ADDRESS +"/images/"+fileName;
                        inputStream = image.getInputStream();
                        ftp.storeFile(fileName,inputStream);
                        System.out.println(fileName);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            inputStream.close();
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
}
