module restaurant.service {
    exports com.restaurant.service;
    requires restaurant.domain;
    requires static lombok;

    // service layer: thin layer that only displays what the domain can do.
    // Therefore, the service layer should not have any business logic.
    // It is an adaptation layer to the domain that only forwards/delegate actual operations to the underlying domain (business objects).
}