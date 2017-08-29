package com.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class FileAction extends BaseAction {
    private File file;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String uploadFile(){
        System.out.println(fileFileName+"***"+file);
        //获得要上传的服务器路径
        String path= ServletActionContext.getServletContext().getRealPath("/images");
        System.out.println(path);
        //将上传的文件拷贝到服务器上
        try {
            FileUtils.copyFile(file, new File(path+"/"+fileFileName));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
