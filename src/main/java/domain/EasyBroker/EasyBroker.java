package domain.EasyBroker;

import retrofit2.Call;
import retrofit2.http.*;

public interface EasyBroker {

  @GET("properties/")
  Call<PropertiesResponse> properties(
      @Query("page") Integer page
      ,@Query("limit") Integer quantity
      ,@Header("X-Authorization") String token);

  @GET("properties/{property_id}")
  Call<SingleProperty> property(
      @Path("property_id") String id
      ,@Header("X-Authorization") String token);

  @POST("contact_requests")
  Call<ContactRequestResponse> contactRequests(
      @Body ContactRequest request
      ,@Header("X-Authorization") String token);
}