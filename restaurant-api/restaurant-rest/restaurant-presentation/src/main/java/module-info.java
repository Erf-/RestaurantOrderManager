module restaurant.presentation {
    exports com.restaurant.rest.presentation.mapper;
    exports com.restaurant.rest.presentation.dto;
    requires restaurant.domain;
    requires static lombok;

    // presentation layer: represents how ressources are presented to the outside.
    // Contains DTOs/ressources and mapping logic to the domain (business) objects.
    // Could also contain controllers that are agnostic to the IOC.
}