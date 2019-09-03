package com.iwen.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BatisGeneratorCreate {
	

	static String base="src/main/java/com/iwen/generator/xmls/";
	static String dahua="mybatis-generator_dahua.xml";

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);   
		boolean overwrite = true;
		File configFile = new File(base+dahua);
		try {
            Configuration config = cp.parseConfiguration(configFile);   
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);   
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,   
                    callback, warnings);   
            myBatisGenerator.generate(null);   
            
            System.out.println("mybatis generator succeed!");
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
	}
}