package domain.EasyBroker;

import java.util.List;

public class SingleProperty {
  private String public_id;
  private String title;
  private String description;
  private List<Image> property_images;
  private String property_type;;
  private  Location location;

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
    return this.location.getName();
  }

  public List<Image> getImages() {
    return this.property_images;
  }
}
