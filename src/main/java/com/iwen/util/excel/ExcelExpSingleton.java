package com.iwen.util.excel;

import com.google.common.base.Throwables;
import com.iwen.common.AppException;
import com.iwen.common.ErrorCode;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author by hurley
 * @Date 2019/3/12
 */
public class ExcelExpSingleton {

    private static final   Logger logger = LoggerFactory.getLogger(ExcelExpSingleton.getInstance().getClass());

    private static volatile ExcelExpSingleton excelExpSingleton;

    private ExcelExpSingleton() {}

    public static ExcelExpSingleton getInstance() {
        if (excelExpSingleton == null) {
            synchronized (ExcelExpSingleton.class) {
                if (excelExpSingleton == null) {
                    excelExpSingleton = new ExcelExpSingleton();
                }
            }
        }
        return excelExpSingleton;
    }


    public static void createDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void init(String fileName, Map<String ,Object> beans, String exportName, HttpServletResponse response){
        //加载excel模板文件
        File somethingFile=null;
        InputStream in=null;
        try{
            exportName=exportName.replaceAll("/",",");
            ClassPathResource cpr = new ClassPathResource("temps"+File.separator+fileName);
            in = cpr.getInputStream();
            somethingFile = File.createTempFile("template_export_copy",".xls");
            FileUtils.copyInputStreamToFile(in,somethingFile);
        }catch(Exception e){
            logger.error("NodeController.exportXLS Error Log_"+ Throwables.getStackTraceAsString(e));
        }finally {
            IOUtils.closeQuietly(in);
        }
        //配置下载路径
        String path="download";
        createDir(new File(path));
        //根据模板生成新的excel
        File excelFile = createNewFile(beans,exportName, somethingFile, path);
        try{
            downloadFile(response,excelFile);
        }catch(Exception e){
            logger.error("exportXLS Error Log_"+ Throwables.getStackTraceAsString(e));
        }
        deleteFile(excelFile);
    }


    /**
     * 将服务器新生成的excel从浏览器下载
     *
     * @param response
     * @param excelFile
     */
    public static void downloadFile(HttpServletResponse response, File excelFile) throws  Exception {
        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
        response.setContentType("multipart/form-data");
        /* 设置文件头：最后一个参数是设置下载文件名 */
        String excelFileName = URLEncoder.encode(excelFile.getName(), "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + excelFileName );
        response.setCharacterEncoding("UTF-8");
        InputStream ins = null;
        OutputStream os = null;
        try{
            ins = new FileInputStream(excelFile);
            os = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = ins.read(b)) > 0) {
                os.write(b, 0, len);
            }
            os.flush();
        }catch (IOException e) {
            logger.error(e.getMessage(),e.getCause());
        }finally {
            if (ins!=null){try {ins.close();} catch (IOException e) {}}
            if (os!=null){try {os.close();} catch (IOException e) {}}
        }

    }

    public static void deleteFile(File excelFile){
        boolean deFlag =  excelFile.delete();
        if(!deFlag){
            throw new AppException(ErrorCode.Delete_file.getCode());
        }
    }



    /**
     * 根据excel模板生成新的excel
     *
     * @param beans
     * @param file
     * @param path
     * @return
     */
    private File createNewFile(Map<String, Object> beans, String aliasName, File file, String path) {
        XLSTransformer transformer = new XLSTransformer();
        //可以写工具类来生成命名规则
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNowStr = sdf.format(new Date());
        String name = aliasName+dateNowStr+".xls";
        File newFile = new File(""+name);
        InputStream ins=null;
        OutputStream os=null;
        try {
            ins = new BufferedInputStream(new FileInputStream(file));
            os = new FileOutputStream(newFile) ;
            Workbook workbook = transformer.transformXLS(ins, beans);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
            workbook.write(os);
            return newFile;
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        } finally {
            if (ins!=null){try {ins.close();} catch (IOException e) {}}
            if (os!=null){try {os.close();} catch (IOException e) {}}
        }
        return newFile;
    }

}


