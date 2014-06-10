package controllers;

import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	@Transactional
	public static Result resFinder() {
		double a = 0, b = 0, c = 0;
		String x1="", x2="";
		DynamicForm frm = Form.form().bindFromRequest();
		a = Double.parseDouble(frm.get("a"));
		b = Double.parseDouble(frm.get("b"));
		c = Double.parseDouble(frm.get("c"));
		double de = (b*b) - 4 * a * c;
		if (de >= 0) {
			x1 = ((-b + Math.sqrt(de)) / (2 * a)) + "";
			x2 = ((-b - Math.sqrt(de)) / (2 * a)) + "";
		} 
		return ok(show.render(x1, x2));
	}
}
