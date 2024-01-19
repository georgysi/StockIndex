package demo.service;

import java.util.List;

public interface IndexService {

    List<String> getAllIndex() throws Exception;

    List<String> getAllByName(String name) throws Exception;

}
