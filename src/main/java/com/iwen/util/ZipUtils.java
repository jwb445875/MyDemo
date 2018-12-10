package com.iwen.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



 
/**
 *将文件或是文件夹打包压缩成zip格式
 * @author ysc
 */
public class ZipUtils {
    static Logger logger = LoggerFactory.getLogger(ZipUtils.class);
    private ZipUtils(){}
   /**
     * 创建ZIP文件
     * @param sourcePath 文件或文件夹路径
     * @param zipPath 生成的zip文件存在路径（包括文件名）
     */
    public static Boolean createZip(List<String> sourcePath, String zipPath) {
        FileOutputStream fos;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            for (String string : sourcePath) {
                writeZip(new File(string), "", zos);
            }
        } catch (FileNotFoundException e) {
            logger.error("创建ZIP文件失败:"+e.getLocalizedMessage());
            return false;
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (IOException e) {
                logger.error("创建ZIP文件失败:"+e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }
     
    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {
        if(file.exists()){
            if(file.isDirectory()){//处理文件夹
                parentPath+=file.getName()+File.separator;
                File [] files=file.listFiles();
                for(File f:files){
                    writeZip(f, parentPath, zos);
                }
            }else{
                FileInputStream fis;
                DataInputStream dis=null;
                try {
                    fis=new FileInputStream(file);
                    dis=new DataInputStream(new BufferedInputStream(fis));
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte [] content=new byte[1024];
                    int len;
                    while((len=fis.read(content))!=-1){
                        zos.write(content,0,len);
                        zos.flush();
                    }
                } catch (FileNotFoundException e) {
                    logger.error("创建ZIP文件失败:"+e.getLocalizedMessage());
                } catch (IOException e) {
                    logger.error("创建ZIP文件失败:"+e.getLocalizedMessage());
                }finally{
                    try {
                        if(dis!=null){
                            dis.close();
                        }
                    }catch(IOException e){
                        logger.error("创建ZIP文件失败:"+e.getLocalizedMessage());
                    }
                }
            }
        }
    }   
}