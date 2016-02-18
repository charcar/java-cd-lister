import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/cds", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("cds", CD.all());
    model.put("template", "templates/cds.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("cds/new", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/cd-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

post("/cds", (request,response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  String title = request.queryParams("description");
  CD newCD = new CD(title);
  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

get("/cd/:id", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();

  CD cd = CD.find(Integer.parseInt(request.params(":id")));
  model.put("cd", cd);
  model.put("template", "templates/cd.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
  }
}
