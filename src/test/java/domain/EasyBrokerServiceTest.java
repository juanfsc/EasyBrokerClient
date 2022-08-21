package domain;

import domain.EasyBroker.EasyBrokerService;
import domain.EasyBroker.PaginatedProperty;
import domain.EasyBroker.PropertiesResponse;
import domain.EasyBroker.SingleProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class EasyBrokerServiceTest {
  EasyBrokerService easyBrokerService;

  @BeforeEach
  void init(){
    easyBrokerService = mock(EasyBrokerService.class);
    easyBrokerService.setUrlApi("test");
    List<PaginatedProperty> properties = new ArrayList<>();
    properties.add(new PaginatedProperty());
    properties.add(new PaginatedProperty());
    when(easyBrokerService.getProperties(2,1)).thenReturn(new PropertiesResponse(properties));
  }

  @Test
  void canGetProperties() {
    Assertions.assertEquals(2, easyBrokerService.getProperties(2,1).getContent().stream().count());
  }
  @Test
  void canGetProperty() {
    when(easyBrokerService.getProperty("EB-2000")).thenReturn(new SingleProperty());
    Assertions.assertNotNull(easyBrokerService.getProperty("EB-2000"));
  }

    @Test
  void printProperties() {
    easyBrokerService.getProperties(2,1).getContent().forEach(p->System.out.println(p.getTitle()));
  }
}