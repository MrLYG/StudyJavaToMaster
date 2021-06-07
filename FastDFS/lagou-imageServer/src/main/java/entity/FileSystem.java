package entity;

import java.io.Serializable;

/**
 * @BelongsProject: lagou-imageServer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-29 14:31
 * @Description: 上传的文件
 */
public class FileSystem implements Serializable {
    private String fileId;
    private String filePath;
    private String fileName;

    @Override
    public String toString() {
        return "FileSystem{" +
                "fileId='" + fileId + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileSystem() {
    }

    public FileSystem(String fileId, String filePath, String fileName) {
        this.fileId = fileId;
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
