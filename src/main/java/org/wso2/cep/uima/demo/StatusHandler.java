/*
 *
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * /
 */

package org.wso2.cep.uima.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import twitter4j.*;

import javax.jms.*;

/***
 *  Listener implementation for the Twitter Streamer
 */
public class StatusHandler implements StatusListener{
	
	private MessageProducer producer;
	private Session session;
	private static Logger logger = Logger.getLogger(StatusHandler.class);


	/***
	 *
	 * @param JMSUrl String | URL of the JMS Broker to send the messages to
	 */
	public StatusHandler(String JMSUrl, String topicName) throws JMSException {
		// create the factory for ActiveMQ connection
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(JMSUrl);
		Connection connection = factory.createConnection();
		connection.start();
		logger.info("ActiveMQ connection established for StatusHandler successfully");

		// Create a non-transactional session with automatic acknowledgement
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create a reference to the queue test_queue in this session.
		Topic topic = session.createTopic(topicName);

		// Create a producer for queue
		producer = session.createProducer(topic);
		logger.info("ActiveMQ producer successfully created for TwitterStreamer");
	}


	/***
	 * Method to handle arrival of a status to the stream
	 * @param status Recieved Tweet as a Status Object
	 */
	@Override
	public void onStatus(Status status) {
		Logger.getLogger(StatusHandler.class).info("Tweet Recieved : "+status.getText());
		if(producer == null){
			throw new NullPointerException("ActiveMQ producer not set for StatusHandler");
		}

		// send the tweet to the queue
		try {
			TextMessage tweetMessage = session.createTextMessage(status.getText());
			producer.send(tweetMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void onException(Exception arg0) {
		Logger.getLogger(StatusHandler.class).error("Exception occured while streaming for tweets : "+arg0.getMessage());
		arg0.printStackTrace();
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		Logger.getLogger(StatusHandler.class).error("Track Limitations Exceeded");

	}

}
