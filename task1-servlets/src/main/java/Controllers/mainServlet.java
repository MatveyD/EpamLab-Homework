package Controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.DataService;
import service.impl.DataServiceImpl;

@WebServlet("/crud")
public class mainServlet extends HttpServlet {

  DataService dataService = new DataServiceImpl();
  private static Gson gson = new Gson();


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    String servletInnerState = "---GET---";
    PrintWriter out = response.getWriter();
    List pack = dataService.getAllData();
    pack.add(0,servletInnerState);
    out.println(gson.toJson(pack));
    out.flush();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    String servletInnerState = "---POST---";
    StringBuilder buffer = new StringBuilder();
    BufferedReader reader = request.getReader();
    PrintWriter out = response.getWriter();

    String line;
    while ((line = reader.readLine()) != null) {
      buffer.append(line);
    }
    line = buffer.toString();
    out.println(gson.toJson(Arrays.asList(servletInnerState, dataService.createData(line))));
    out.flush();
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    String servletInnerState = "---PUT---";
    StringBuilder buffer = new StringBuilder();
    BufferedReader reader = request.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
      buffer.append(line);
    }
    JsonObject jsonObject = new JsonParser().parse(buffer.toString()).getAsJsonObject();
    Integer id = jsonObject.get("id").getAsInt();
    String newValue = jsonObject.get("name").getAsString();
    String oldValue = dataService.getValue(id);

    dataService.putData(
        id,
        newValue
    );

    PrintWriter out = response.getWriter();
    out.println(gson.toJson(Arrays.asList(
        servletInnerState,
        oldValue,
        newValue)));
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    String servletInnerState = "---DELETE---";
    StringBuilder buffer = new StringBuilder();
    BufferedReader reader = request.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
      buffer.append(line);
    }
    Integer id = Integer.parseInt(buffer.toString());
    dataService.deleteData(id);

    PrintWriter out = response.getWriter();
    out.println(gson.toJson(Arrays.asList(
        servletInnerState,
        id)));
  }

}
