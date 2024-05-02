package org.prash.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.prash.model.AddressList;

/**
 * Project: PojoFactory
 * Author: bittu
 * Date: 02-05-2024
 * <p>
 * Class Usage generates JSON for Pojo Factory Objects
 */

public class JsonFactory {

    private final ObjectMapper mapper;
    private final PojoFactory pf;

    public JsonFactory() {
        this.mapper = new ObjectMapper();
        this.pf = new PojoFactory();
    }

    /**
     * @return A json containing address
     */
    public String getAddress() {
        try {
            return mapper.writeValueAsString(pf.getAddress());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A json list containing N address
     */
    public String getAddress(int N) {
        try {
            return mapper.writeValueAsString(pf.getAddress(N));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     *<b>Description: Return a JSON with root cityList</b>
     */
    public String getCityList(int N) {
        try {
            return mapper.writeValueAsString(new AddressList(pf.getAddress(N)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A json containing employee
     */
    public String getEmployee() {
        try {
            return mapper.writeValueAsString(pf.getEmployee());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A json list containing N employees
     */
    public String getEmployee(int N) {
        try {
            return mapper.writeValueAsString(pf.getEmployee(N));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A json containing person
     */
    public String getPerson() {
        try {
            return mapper.writeValueAsString(pf.getPerson());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return A json list containing N people
     */
    public String getPerson(int N) {
        try {
            return mapper.writeValueAsString(pf.getPeople(N));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
