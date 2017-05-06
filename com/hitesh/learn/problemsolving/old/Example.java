package com.hitesh.learn.problemsolving.old;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.googlecode.jsonschema2pojo.SchemaMapper;
import com.sun.codemodel.JCodeModel;

public class Example {

    public static void main(String[] args) throws IOException {
        
        // BEGIN EXAMPLE
        
        JCodeModel codeModel = new JCodeModel();
  
        
        URL source = new URL("file://C:/Users/hitjoshi/Desktop/TULI/schema.json");
        
        
        new SchemaMapper().generate(codeModel, "test.java","file://C:/Users/hitjoshi/Desktop/", source);
        
        codeModel.build(new File("output"));
        
        // END EXAMPLE

    }
    
}