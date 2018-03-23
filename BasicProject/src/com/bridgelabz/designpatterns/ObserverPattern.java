package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.MyTopic;
import com.bridgelabz.utility.MyTopicSubscriber;

public class ObserverPattern 
{
	public static void main(String[] args) 
	{
		MyTopic topic = new MyTopic();
		
		MyTopicSubscriber subscriber1 = new MyTopicSubscriber("Subscriber1");
		MyTopicSubscriber subscriber2 = new MyTopicSubscriber("Subscriber2");
		MyTopicSubscriber subscriber3 = new MyTopicSubscriber("Subscriber3");
		
		topic.register(subscriber1);
		topic.register(subscriber2);
		topic.register(subscriber3);
		
		subscriber1.setSubject(topic);
		subscriber2.setSubject(topic);
		subscriber3.setSubject(topic);
		
		subscriber1.update();
		
		topic.postMessage("New Message");
	}
}