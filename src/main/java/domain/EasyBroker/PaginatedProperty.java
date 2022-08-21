package domain.EasyBroker;

public class PaginatedProperty {
  private String public_id;
  private String title;
  private String property_type;
  private String location;
  private String title_image_thumb;

  public String getPublicID() {
    return this.public_id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getType() {
    return this.property_type;
  }

  public String getLocation() {
    return this.location;
  }

  public String getThumbnail() {
    return this.title_image_thumb;
  }
}
