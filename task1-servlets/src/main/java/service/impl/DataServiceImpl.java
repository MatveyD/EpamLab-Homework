package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.DataService;

public class DataServiceImpl implements DataService {

  Map<Integer, String> dataMap= new HashMap <Integer, String>();

  int lastId =0;

  private int generateInt(){
    do {
      lastId++;
    } while (dataMap.containsKey(lastId));
    return lastId;
  }

  public String createData(String data) {
    int id = generateInt();
    dataMap.put(id, data);
    return (id + " " + dataMap.get(lastId));
  }

  public void deleteData(Integer id) {
    dataMap.remove(id);
  }

  public List<String> getAllData() {
    return dataMap.keySet().stream().map(s-> s + " "+ dataMap.get(s)).collect(Collectors.toList());
  }

  public void putData(Integer id, String newData) {
    dataMap.put(id,newData);

  }

  @Override
  public String getValue(Integer id) {
    return dataMap.get(id);
  }


}
