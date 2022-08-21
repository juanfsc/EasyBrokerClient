package domain;

import domain.EasyBroker.Pagination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaginationTest {

  @Test
  void getPages() {
    Pagination pagination = new Pagination();
    pagination.total = 52;
    pagination.limit=15;

    Assertions.assertEquals(4, pagination.getPages().stream().count());
    Assertions.assertEquals(1, pagination.getPages().get(0).getPage());
  }
}