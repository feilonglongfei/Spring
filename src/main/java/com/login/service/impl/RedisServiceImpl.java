/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;

import com.login.service.RedisService;

import redis.clients.jedis.*;

/**
 * @author Administrator
 *
 */
@Service("RedisService")
public class RedisServiceImpl implements RedisService {
	
	private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
	
	public void redisString() {
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.connect();
		Transaction transaction = jedis.multi();
		transaction.set("myString", "hello");
		transaction.set("myString1", "world");
		transaction.discard();
		
		logger.info(jedis.get("myString"));
		logger.info(jedis.get("myString1"));
		jedis.close();
		
	}

	public void redisList() {
		
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.connect();
//		jedis.lpush("mylist", "hello");
//		jedis.lpush("mylist", "world");
//		jedis.linsert("mylist", BinaryClient.LIST_POSITION.AFTER, "hello", "this");
		logger.info(String.valueOf(jedis.lrange("mylist", 0, 10)));
		jedis.close();
		
	}
	
	public void redisHash(){
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.connect();
		HashMap hashMap = new HashMap();
		hashMap.put("name", "userName");
		jedis.hmset("myHash", hashMap);
		String fields = "name";
		List<String> userName = jedis.hmget("myHash", fields);
		logger.info(userName.get(0));
		jedis.close();
	}
}
