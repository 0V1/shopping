package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @ClassName: redisTest
 * @Description: redis链接测试
 * @author qinf QQ:908247035
 * @date 2016年12月9日
 * @version V1.0
 */
public class redisTest {

	//单实例连接
	@Test
	public void testJedisSingle() {
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.set("keySingle", "test");
		String re = jedis.get("keySingle");
		
		System.out.println(re);
		jedis.close();
	}
	
	//连接池链接
	@SuppressWarnings("resource")
	@Test
	public void testJedisPoll() {
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(20);
		//设置最大空闲数
		config.setMaxIdle(2);
		//设置最大保存期
		config.setMaxWaitMillis(1000);
		JedisPool poll = new JedisPool(config,"127.0.0.1",6379);
		Jedis jedis = poll.getResource();
		
		jedis.set("keyPoll", "test");
		String re = jedis.get("keyPoll");
		System.out.println(re);
		//关闭连接
		jedis.close();
	}
	
	//redis整合进spring 添加配置文件spring-redis.xml
	@SuppressWarnings("resource")
	@Test
	public void testJedisConfig() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
		JedisPool poll = (JedisPool) applicationContext.getBean("jedisPool");
		Jedis jedis = poll.getResource();
		
		jedis.set("keyPoll", "test");
		String re = jedis.get("keyPoll");
		System.out.println(re);
		//关闭连接
		jedis.close();
		poll.close();
	}
	
	// 连接redis集群
	@SuppressWarnings({ "resource", "unused" })
	@Test
	public void testJedisCluster() {

		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数
		config.setMaxTotal(30);
		// 最大连接空闲数
		config.setMaxIdle(2);

		//集群结点
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7001));
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7002));
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7003));
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7004));
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7005));
		jedisClusterNode.add(new HostAndPort("127.0.0.1", 7006));
		JedisCluster jc = new JedisCluster(jedisClusterNode, config);
		
		JedisCluster jcd = new JedisCluster(jedisClusterNode);
		jcd.set("name", "zhangsan");
		String value = jcd.get("name");
		System.out.println(value);
		//集群不需要关闭链接
	}
	
	//redis集群使用，redis整合进spring 添加配置文件spring-redis.xml
	@SuppressWarnings("resource")
	@Test
	public void testJedisConfigCluster() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
		JedisCluster cluster = (JedisCluster) applicationContext.getBean("jedisPool");
		cluster.set("name", "zhangsan");
		String value = cluster.get("name");
		System.out.println(value);
	}
}
