package com.example.redisdemo;
import com.example.redisdemo.dto.User;
import com.example.redisdemo.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void testUtils(){
		redisUtils.set("test","util");
	}

	@Test
	void contextLoads() {
		// 在企业开发中，我们80%的情况下都不会使用原生的方式去编写代码！
		// RedisUtils

		// redisTemplate 操作不同的数据类型，api和我们的指令是一样的
		// opsForValue   操作字符串 类似String
		// opsForList    操作List  类似List
		// opsForSet     操作Set   类似Set
		// opsForHash
		// opsForZSet
		// opsForGeo
		// opsForHyperLogLog

		// 除了基本的操作，我们常用的方法都可以直接通过RedisTemplate操作，比如事务
		//获取redis连接  很少使用
		//RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		//connection.flushDb();
		//connection.flushAll();

//		redisTemplate.opsForValue().set("mykey","test");
//		System.out.println(redisTemplate.opsForValue().get("mykey"));

		User user = new User();
		user.setName("user");
		user.setAddress("address");

		redisTemplate.opsForValue().set("user",user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
