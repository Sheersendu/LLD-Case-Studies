package Cache;

import Cache.Interfaces.Cache;
import Cache.eviction.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<KEY, VALUE> implements Cache<KEY, VALUE> {
	private Integer capacity;
	private Integer ttl;

//	private Map<KEY, VALUE> values = new HashMap();
	private Map<KEY, VALUE> values = new ConcurrentHashMap<>(); // Multi-thread safe(Atomic data type)
	private EvictionStrategy<KEY> evictionStrategy;

	public InMemoryCache(Integer capacity, Integer ttl, EvictionStrategy<KEY> evictionStrategy) {
		this.capacity = capacity;
		this.ttl = ttl;
		this.evictionStrategy = evictionStrategy;
	}

@Override
	public void create(KEY key, VALUE value) {
		// Add capacity check
//		if (capacity >= values.size()) {
//			throw new RuntimeException("Cache is full!");
//			// Instead of throwing exception we should remove item : Eviction!
//		}

		if (capacity >= values.size()) {
			KEY keyToRemove = evictionStrategy.evict();
			delete(keyToRemove);
		}
		values.put(key, value);
	}

	@Override
	public VALUE get(KEY key) {
		return values.get(key);
	}

	@Override
	public void update(KEY key, VALUE value) {
		values.put(key, value);
	}

	@Override
	public void delete(KEY key) {
		values.remove(key);
	}
}
// Ways to tackle concurrency
// 1. LOCK : slow
// 2. Synchronized block(provided by JAVA, last used in singleton [Just need to add synchronized keyword in every method!]) : slow
// 3. Semaphores
// 4. Atomic data types(implements synchronisation internally)