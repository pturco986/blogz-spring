package org.launchcode.blogz.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.blogz.models.Post;
import org.launchcode.blogz.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController extends AbstractController {

	@RequestMapping(value = "/blog/newpost", method = RequestMethod.GET)
	public String newPostForm() {
		return "newpost";
	}
	
	@RequestMapping(value = "/blog/newpost", method = RequestMethod.POST)
	public String newPost(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		User author = Post.getAuthor();
		// TODO - implement newPost 
		// get request parameters (CHECK)
		// validate parameters (CHECK)
		// if valid, create new Post (CHECK)
		// if not valid, send them back to form with error message CHECK)
		if (title != null && body != null && title != "" && body != "") {
		Post post = new Post(title, body, author);
		
		postDao.save(post);
		return "post/{username}/{uid}"; //need to figure out what goes here so it goes to the specific post
		}
		if (title == null || title == "" || body == null || body == ""){
			model.addAttribute("error", "You cannot leave a field blank");
		}
		return "newpost";
		; // TODO - this redirect should go to the new post's page (this is done)		
	}
	//handles request like /blog/chris/5
	@RequestMapping(value = "/blog/{username}/{uid}", method = RequestMethod.GET)
	public String singlePost(@PathVariable String username, @PathVariable int uid, Model model) {
		
		// TODO - implement singlePost
		// get the given post
		// pass the post into the template
		//then return the name of the template
		
		return "post/{uid}";
	}
	
	@RequestMapping(value = "/blog/{username}", method = RequestMethod.GET)
	public String userPosts(@PathVariable String username, Model model) {
		
		// TODO - implement userPosts
		
		// get all of the user's posts
		
		//pass the posts into the template
		//model.addAttribute("name", listOfPosts);
		
		return "blog";
	}
	
}
