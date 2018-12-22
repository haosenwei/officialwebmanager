package com.official.web.tool.tpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerHelper {
    
    public static void generateRequest(Map<String, Object> map,String templeFilePath,String targetFilePath,String fileName) {
    	Configuration freeMarkerCfg = new Configuration();
    	Template template = null;
    	try {
    		template = freeMarkerCfg.getTemplate("tpl/"+templeFilePath);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        try {
        	File file =new File(targetFilePath);
        	mkDir(file);
        	File targetFile=new File(targetFilePath+"/"+fileName);
        	if(targetFile.exists()==false){
        		targetFile.createNewFile();
        	}
        	
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8");
            template.process(map, writer);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public static void mkDir(File file) {  
        if (file.getParentFile().exists()) {  
            file.mkdir();  
        } else {  
            mkDir(file.getParentFile());  
            file.mkdir();    
        }  
    }  
}