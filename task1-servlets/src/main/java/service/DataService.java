package service;

import java.util.List;

public interface DataService {

  String createData(String data);

  void deleteData(Integer id);

  List<String> getAllData();

  void putData(Integer id,  String newData);

  String getValue (Integer id);

}
