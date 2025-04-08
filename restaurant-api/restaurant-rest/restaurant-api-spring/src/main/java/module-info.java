module restaurant.api.spring {
    requires restaurant.presentation;
    requires restaurant.service;
    requires restaurant.domain;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires spring.web;
    requires static lombok;

    opens com.restaurant.rest.spring;
    opens com.restaurant.rest.spring.config;
    opens com.restaurant.rest.spring.controller;
    // IOC framework configuration layer.
    // It is an adaptation layer to the IOC framework.
}