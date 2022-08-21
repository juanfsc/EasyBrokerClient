package domain.controllers;

import domain.EasyBroker.*;
import domain.utils.TokenPropertiesUtil;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.HashMap;

public class PropertiesController {
  String url = TokenPropertiesUtil.getInstance().getString("t.easyBrokerURL");
  String token = TokenPropertiesUtil.getInstance().getString("t.easyBrokerToken");
  EasyBrokerService easyBrokeService = new EasyBrokerService(url, token);

  public ModelAndView showProperties(Request request, Response response) {
    String paramPage = request.params("page");

    System.out.println(paramPage);

    Integer page = 1;
    if(paramPage!=null) {
      page = Integer.parseInt(paramPage);
    }
    System.out.println(page);
    PropertiesResponse properties = easyBrokeService.getProperties(15, page);
    Pagination pagination = properties.pagination;

    HashMap<String, Object> props = new HashMap<>();
    props.put("properties", properties.getContent());
    props.put("pages", properties.pagination.getPages());


    return new ModelAndView(props,"/properties.hbs");
  }

  public ModelAndView showProperty(Request request, Response response) {
    String id = request.params("property_id");
    System.out.println(id);
    SingleProperty property = easyBrokeService.getProperty(id);

    HashMap<String, Object> props = new HashMap<>();
    props.put("property", property);

    return new ModelAndView(props,"/property.hbs");
  }
}
