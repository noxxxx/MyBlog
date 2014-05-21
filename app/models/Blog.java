package models;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.Constraints.Required;

@Entity
public class Blog extends Model{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = -8627772057302927724L;

	@Id
    public Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	@Required
    public String title;

    @Required
    public String content;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date lastEditTime;
    
    public Blog(){
    	this.title = "ceshi";
    	this.content = "测试内容";
    }
      
    public Blog(String title, String content,Date datetime){
    	this.title = title;
    	this.content = content;
    	this.lastEditTime = datetime;
    }
    
	public static Model.Finder<Long,Blog> find = new Model.Finder<Long,Blog>(Long.class, Blog.class);

    public static List<Blog> all() {
	return find.all();
    }

    public static void create(Blog blog) {
	blog.save();
    }

    public static void delete(Long id) {
	find.ref(id).delete();
    }

}
