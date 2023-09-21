package com.example.web.component;
/*
 * @author  AmbitionJingH
 * @date  2023/9/19 16:12
 * @version 1.0
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class MyYamlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private ObjectMapper objectMapper = null;

    public MyYamlHttpMessageConverter(){
        //告诉springboot这个MessageConverter支持那种类型
        super(new MediaType("text","yaml", Charset.forName("utf-8")));
        //媒体类型
        //MediaType mediaType = new MediaType("application","yaml", Charset.forName("utf-8"));
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        this.objectMapper = new ObjectMapper(factory);

    }
    @Override
    protected boolean supports(Class<?> clazz) {
        //只要是对象类型 ，不是基本类型
        return true;//false 改 true
    }

    @Override //@RequestBody
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override //@ResponseBody 把对象怎么写出
    protected void writeInternal(Object MethodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream body = outputMessage.getBody();
        try {
            objectMapper.writeValue(body,MethodReturnValue);
        } finally {
            body.close();
        }
    }
}
