package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

import java.io.Serializable;

public class JSONUtils {
    public static String toJSON(Serializable object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String xml = mapper.writeValueAsString(object);
        return xml;
    }

    public static Request JSONtoRequest(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Request request = mapper.readValue(json, Request.class);
        return request;
    }

    public static Response JSONtoResponse(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(json, Response.class);
        return response;
    }

}
