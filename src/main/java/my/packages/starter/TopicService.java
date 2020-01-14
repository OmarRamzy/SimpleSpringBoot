package my.packages.starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {

	private  List<Topic> topics = new ArrayList<>(  Arrays.asList(new Topic("CS201" , "CS" , "Intro To CS"), new Topic("IT101" , "InternetApps" , "Intro to IT"),
			new Topic("DS201" , "Decsion Support","Intro To DS")));

	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//return this.topics;
		List<Topic> topicss = new ArrayList<>();
//		topicRepository.findAll().forEach(topicss::add);
		return topicss;
	}
	
	public Topic getTopic(String id) {
	if(	topics.stream().filter(t->t.getId().equals(id)).findFirst().isPresent())
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	else
		return new Topic();
	}
	
	
	public void addTopic(Topic t) {
		//this.topics.add(t);
		topicRepository.save(t);
	}

	public Topic updateTopic(Topic t, String id) {
		int idx = this.topics.indexOf(this.topics.stream().filter(p->p.getId().equals(id)).findFirst().get());
		System.out.println("Idxxxxxxxxxxxxxxxxx"+idx);
		this.topics.set(idx, t);
	    return t;
	}

	public Topic deleteTopic(String id) {
	 Topic tt =	topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	 this.topics.remove(tt);
	// this.topics.removeIf(o->o.getId().equals(id));
	 return tt ;
		
	}
}
 