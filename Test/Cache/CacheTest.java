package Test.Cache;

import Cache.Interfaces.Cache;
import Cache.InMemoryCache;
import Cache.eviction.RandomEvictionStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class CacheTest {
	private Cache<String, String> cache;

	@Before
	public void Setup() {
		cache = new InMemoryCache<String, String>(10, 1000, new RandomEvictionStrategy<String>());
	}
	@Test
	public void TestInMemoryCacheForCreation(){
		cache.create("Test", "TestString");
		String actual = cache.get("Test");
		Assert.assertEquals("If put is done correctly must return correct value", "TestString", actual);
	}

	@Test(expected = RuntimeException.class)
	public void TestInMemoryCacheOverflow(){
		IntStream.range(0,11).forEach(index -> cache.create("Test_"+index, "Test_String_"+index));
	}
}
