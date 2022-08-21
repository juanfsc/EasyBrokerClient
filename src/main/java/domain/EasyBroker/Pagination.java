package domain.EasyBroker;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
  public int limit;
  public int total;
  public int page;

  public List<Page> getPages() {
    int numberPages = (int) Math.ceil(total/limit + 0.5);
    ArrayList<Page> pages = new ArrayList<>();
    for(int i=1; i<=numberPages; i++){
      pages.add(new Page(i));
    }
    return pages;
  }
}