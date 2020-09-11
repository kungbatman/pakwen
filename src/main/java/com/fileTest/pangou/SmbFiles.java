package com.fileTest.pangou;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kung
 * @date 2019-08-21 14:54
 * @Description
 */
public class SmbFiles {
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SmbFiles.class);
    private final static String BASE_URL = "192.168.1.170/ftpTest/20190423/";

    private final static String TEMP_BASE_URL = "smb://ythread:ythread1401@10.226.120.101/test/product_TJ/DATA/GRID/AFTJ/PUB/";

    private final static String GET_URL = "F:/realtime/";
    public static void main(String[] args) throws Exception {
        getRemoteFile("","",BASE_URL,GET_URL);
    }

    /**
     * 获取远程文件
     *
     * @param remoteUsername 远程目录访问用户名
     * @param remotePassword 远程目录访问密码
     * @param remoteFilepath 远程文件地址,该参数需以IP打头,如'192.168.8.2/aa/bb.java'或者'192.168.8.2/aa/',如'192.168.8.2/aa'是不对的
     * @param localDirectory 本地存储目录,该参数需以'/'结尾,如'D:/'或者'D:/mylocal/'
     * @return boolean 是否获取成功
     * @throws Exception
     */
    public static boolean getRemoteFile(String remoteUsername, String remotePassword, String remoteFilepath,
                                        String localDirectory) throws Exception {
        boolean isSuccess = Boolean.FALSE;
        if (remoteFilepath.startsWith("/") || remoteFilepath.startsWith("\\")) {
            return isSuccess;
        }
        if (!(localDirectory.endsWith("/") || localDirectory.endsWith("\\"))) {
            return isSuccess;
        }
        SmbFile smbFile = null;
        if (StringUtils.isNotEmpty(remoteUsername) && StringUtils.isNotEmpty(remotePassword)) {
            smbFile = new SmbFile("smb://" + remoteUsername + ":" + remotePassword + "@" + remoteFilepath);
            System.out.println("smb://" + remoteUsername + ":" + remotePassword + "@" + remoteFilepath);
        } else {
            smbFile = new SmbFile("smb://" + remoteFilepath);
            System.out.println("smb://" + remoteFilepath);
        }

        if (smbFile != null) {
            if (smbFile.isDirectory()) {
                for (SmbFile file : smbFile.listFiles()) {
                    isSuccess = copyRemoteFile(file, localDirectory);
                }
            } else if (smbFile.isFile()) {
                isSuccess = copyRemoteFile(smbFile, localDirectory);
            }
        }

        return isSuccess;
    }

    /**
     * 拷贝远程文件到本地目录
     *
     * @param smbFile        远程SmbFile
     * @param localDirectory 本地存储目录,本地目录不存在时会自动创建,本地目录存在时可自行选择是否清空该目录下的文件,默认为不清空
     * @return boolean 是否拷贝成功
     */
    public static boolean copyRemoteFile(SmbFile smbFile, String localDirectory) {
        SmbFileInputStream in = null;
        FileOutputStream out = null;
        try {
            File[] localFiles = new File(localDirectory).listFiles();
            if (null == localFiles) {
                // 目录不存在的话,就创建目录
                new File(localDirectory).mkdirs();
            }
            in = new SmbFileInputStream(smbFile);
            out = new FileOutputStream(localDirectory + smbFile.getName());
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            System.out.println("拷贝远程文件到本地目录失败"+ e);
            return false;
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
