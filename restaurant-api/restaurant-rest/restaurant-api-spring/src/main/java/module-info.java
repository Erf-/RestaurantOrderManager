module restaurant.api.spring {
    requires restaurant.presentation;
    requires restaurant.service;
    requires restaurant.domain;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;

    // IOC framework configuration layer.
    // It is an adaptation layer to the IOC framework.
}