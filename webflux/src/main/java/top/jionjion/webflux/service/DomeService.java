package top.jionjion.webflux.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jion
 */
@Service
@SuppressWarnings("unused")
public class DomeService {

    public String findById (String id) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>(4);
        map.put("id", id);
        map.put("name", "Jion");
        map.put("age", "26");
        return new ObjectMapper().writeValueAsString(map);
    }
}
