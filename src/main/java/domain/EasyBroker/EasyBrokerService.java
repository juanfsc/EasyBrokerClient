package domain.EasyBroker;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

public class EasyBrokerService {
  private String urlApi;
  private String token;
  private Retrofit retrofit;
  private EasyBroker easyBroker;

  public EasyBrokerService(String urlApi, String token) {
    this.setUrlApi(urlApi);
    this.token = token;
    this.easyBroker = this.retrofit.create(EasyBroker.class);
  }

  private void configRetrofit(String urlApi) {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(urlApi)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public void setUrlApi(String urlApi) {
    this.urlApi = urlApi;
    this.configRetrofit(urlApi);
  }

  public PropertiesResponse getProperties(int quantity, int page) {

    try{

      Call<PropertiesResponse> requestProperties = easyBroker.properties(page, quantity, token);
      Response<PropertiesResponse> responseProperties = requestProperties.execute();
      if (responseProperties.code() != 200) {
        throw new RuntimeException("Error al buscar propiedades");
      }
      return responseProperties.body();
    }
    catch (IOException e){
      throw new RuntimeException("Hubo un problema de conexion al servidor" + e);
    }

  }

  public SingleProperty getProperty(String id) {

    try{
      Call<SingleProperty> requestProperty = easyBroker.property(id, token);
      Response<SingleProperty> property = requestProperty.execute();
      if (property.code()!=200) {
        throw new RuntimeException("Error al buscar propiedad "+id);
      }
      System.out.println(property.body());
      return property.body();
    }
    catch (IOException e){
      throw new RuntimeException("Hubo un problema de conexion al servidor" + e);
    }

  }

  public ContactRequestResponse putRequest(ContactRequest request) {

    try{
      Call<ContactRequestResponse> requestContactRequest = easyBroker.contactRequests(request, token);
      Response<ContactRequestResponse> contactRequest = requestContactRequest.execute();
      if (contactRequest.code() != 200) {
        throw new RuntimeException("Error al enviar contact request");
      }
      return contactRequest.body();
    }
    catch (IOException e){
      throw new RuntimeException("Hubo un problema de conexion al servidor" + e);
    }

  }

}
