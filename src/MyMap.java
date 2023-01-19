import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {
	private ArrayList<K> keys;
	private ArrayList<V> values;

	public MyMap() {
		keys = new ArrayList<>();
		values = new ArrayList<>();
	}

	@Override
	public void clear() {
		keys.clear();
		values.clear();
	}

	@Override
	public boolean containsKey(Object arg0) {
		return keys.contains(arg0);
	}

	@Override
	public boolean containsValue(Object arg0) {
		return values.contains(arg0);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> entrySet = new HashSet<>();
		for(int i = 0; i < keys.size(); i++){
			entrySet.add(new AbstractMap.SimpleEntry<>(keys.get(i), values.get(i)));
		}
		return entrySet;
	}

	@Override
	public V get(Object key) {
		int index = keys.indexOf(key);
		if (index == -1){
			return null;
		}
		return values.get(index);
	}

	@Override
	public boolean isEmpty() {
		return keys.size() == 0;
	}

	@Override
	public Set<K> keySet() {
		return new HashSet<K>(keys);
	}

	@Override
	public V put(K key, V value) {
		V prevVal = null;
		int index = keys.indexOf(key);
		if(index == -1){
			keys.add(key);
			values.add(value);
		}else{
			prevVal = values.get(index);
			values.set(index, value);
		}
		return prevVal;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(K key: m.keySet()){
			V value = m.get(key);
			this.put(key, value);
		}
	}

	@Override
	public V remove(Object key) {
		V prevVal = null;
		int index = keys.indexOf(key);
		if(index != -1){
			prevVal = values.get(index);
			keys.remove(index);
			values.remove(index);
		}
		return prevVal;
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public Collection<V> values() {
		ArrayList<V> res = new ArrayList<>(values);
		return res;
	}
	
	
	// not a part of map interface
	@Override
	public String toString(){
		String res = "{";
		for(int i = 0; i < keys.size(); i++){
			if(i != 0){
				res += ", ";
			}
			res += keys.get(i).toString();
			res += "=";
			res += values.get(i).toString();
		}
		res += "}";
		return res;
	}
}