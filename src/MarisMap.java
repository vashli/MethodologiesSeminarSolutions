import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MarisMap implements Map{
	
	private ArrayList<Object> keys;
	private ArrayList<Object> values;
	
	public MarisMap() {
		keys = new ArrayList<Object>();
		values = new ArrayList<Object>();
	}
	
	
	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i).equals(key)) {
				Object prevValue = values.get(i);
				values.set(i, value);
				return prevValue;
			}
		}
		keys.add(key);
		values.add(value);
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}