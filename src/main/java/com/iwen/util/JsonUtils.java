package com.iwen.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/12/10.
 */
public class JsonUtils {
    /**
     * 将json字符串转换成java对象
     *
     * @param json
     * @param object
     * @return
     */
    public static Object parseJSONStringToObject(String json, Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, object.getClass());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换成List
     *
     * @param json
     * @param object
     * @return
     */
    public static List<?> parseJSONStringToList(String json, Class<?> object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(List.class, object));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将java对象转换成json字符串
     *
     * @param object
     * @return
     */
    public static String parseObjectToJSONString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
