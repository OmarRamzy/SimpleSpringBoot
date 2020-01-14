package my.packages.starter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired(required = true)
	private TopicService topicService ;
	 
	@RequestMapping("/hello")
	public String heelo() {
		return "Hello";
	}
	
	@CrossOrigin(origins="http://127.0.0.1:5500")
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/topics")
	public Topic addTopic(@RequestBody Topic t) {
		this.topicService.addTopic(t);
		return t;
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
	public Topic updateTopic(@RequestBody Topic t , @PathVariable String id) {
	 Topic tt =	this.topicService.updateTopic(t , id);
		return tt;
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
	public Topic deleteTopic(@PathVariable String id) {
	 Topic tt =	this.topicService.deleteTopic(id);
		return tt;
	}
	
	
	
}
