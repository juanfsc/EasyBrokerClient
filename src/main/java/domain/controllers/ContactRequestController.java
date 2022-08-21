package domain.controllers;

import com.google.gson.Gson;
import domain.EasyBroker.ContactRequest;
import domain.EasyBroker.ContactRequestResponse;
import domain.EasyBroker.EasyBrokerService;
import domain.utils.TokenPropertiesUtil;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class ContactRequestController {
  String url = TokenPropertiesUtil.getInstance().getString("t.easyBrokerURL");
  String token = TokenPropertiesUtil.getInstance().getString("t.easyBrokerToken");
  EasyBrokerService easyBrokeService = new EasyBrokerService(url, token);
  Gson gson = new Gson();
  public Response sendContactRequest(Request request, Response response) {
    ContactRequest contactRequest = gson.fromJson(
        request.body(), ContactRequest.class);
    ContactRequestResponse contactRequestResponse = easyBrokeService.putRequest(contactRequest);
    HashMap<String, Object> props = new HashMap<>();
    response.redirect("/empty",200);
    return response;
  }

  public ModelAndView contactRequestSent(Request request, Response response) {
    HashMap<String, Object> props = new HashMap<>();
    return new ModelAndView(props,"/contactado.hbs");
  }
}
