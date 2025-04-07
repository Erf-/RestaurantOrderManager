module restaurant.domain {
    exports com.restaurant.domain.model;
    exports com.restaurant.domain.repository;
    requires static lombok;

    // Domain layer: contains all the business logic and is agnostic to IOC frameworks and underlying technical implementation details.
    // Also contains interfaces to the data layer.
}