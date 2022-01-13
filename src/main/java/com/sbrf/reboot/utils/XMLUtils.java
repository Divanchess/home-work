package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

import java.io.Serializable;

public class XMLUtils {
    public static String toXML(Serializable object) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String xml = mapper.writeValueAsString(object);
        return xml;
    }

    public static Request XMLtoRequest(String xml) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        Request request = mapper.readValue(xml, Request.class);
        return request;
    }

    public static Response XMLtoResponse(String xml) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        Response response = mapper.readValue(xml, Response.class);
        return response;
    }

}
