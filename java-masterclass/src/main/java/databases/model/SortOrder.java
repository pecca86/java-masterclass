package databases.model;

public enum SortOrder {
    NONE(""),
    ASC("desc"),
    DESC("asc");
    public final String orderType;
    SortOrder(String orderType) {
        this.orderType = orderType;
    }

}

