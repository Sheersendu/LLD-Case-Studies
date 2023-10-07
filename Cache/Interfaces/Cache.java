package Cache.Interfaces;

public interface Cache<KEY, VALUE> {
	void create(KEY key, VALUE value);
	VALUE get(KEY key);
	void update(KEY key, VALUE value);
	void delete(KEY key);
}
// Create a cache with string key and integer value
// new Cache<String, Integer>