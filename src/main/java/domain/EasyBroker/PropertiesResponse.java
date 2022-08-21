package domain.EasyBroker;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class PropertiesResponse {
    public Pagination pagination;
    private List<PaginatedProperty> content;

    public PropertiesResponse(List<PaginatedProperty> content){
        this.content = content;
    }
    public List<PaginatedProperty> getContent() {
        return this.content;
    }
}
