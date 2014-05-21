package controllers;

import java.util.List;

import models.Blog;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.blogs.*;;

public class Blogs extends Controller {

	/*public static Result index() {
        return ok(index.render("Your new blogs is ready!"));
    }*/
	
	static Form<Blog> blogForm = Form.form(Blog.class);
    
	public static Result list() {
    	List<Blog> bloglist = Blog.all();
        return ok(index.render("name", bloglist));
    }
	
	public static Result add() {
		return ok(add.render(blogForm));
    }
	
	public static Result addBlog() {
		
		Blog blog = blogForm.bindFromRequest().get();
    	Blog.create(blog);
        return redirect(controllers.routes.Blogs.list());
    }
	
	public static Result gotoBlogDetail(Long id){
		Blog blog  = Blog.find.byId(id);
		return ok(detail.render(blog));
	}

}
