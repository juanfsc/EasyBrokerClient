package server;

import domain.controllers.ContactRequestController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import domain.controllers.PropertiesController;

public class Router {
  private static HandlebarsTemplateEngine engine;

  public static void init() {
    Router.initEngine();
    Spark.staticFileLocation("/public");
    Router.configure();
  }

  private static void initEngine() {
    engine = new HandlebarsTemplateEngine();
  }

  private static void configure() {
    PropertiesController propertiesController = new PropertiesController();
    ContactRequestController contactRequestController = new ContactRequestController();
    Spark.get("/properties", propertiesController::showProperties, Router.engine);

    Spark.get("/properties/page/:page", propertiesController::showProperties, Router.engine);

    Spark.get("/property/:property_id", propertiesController::showProperty, Router.engine);

    Spark.post("/contact", contactRequestController::sendContactRequest);

    Spark.get("/empty", contactRequestController::contactRequestSent, Router.engine);
  }
}
