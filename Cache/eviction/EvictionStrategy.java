package Cache.eviction;

public interface EvictionStrategy<KEY> {
	KEY evict();
}
