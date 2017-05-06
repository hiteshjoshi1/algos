package com.hitesh.learn.ds.old;
/**
 * Java based Generic DS , to be written later
 * @author hitjoshi
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> {
	
	private Entry[] keyArray;
	private static int INIT_SIZE=10;
	
	public HashTable()
	{
		this.keyArray = new Entry[INIT_SIZE]; 
	}
	
	private int hash(K key)
	{
		return 0;
	}
	
	public void put(K key,V value)
	{
		int hashValue=hash(key);
		if (this.keyArray[hashValue] !=null)
		{
			
		}
		
	}
	
	class Entry<K,V>
	{
		int hash;
		V value;
		K key;
		Entry<K,V> nextPtr;
		
		public Entry(int hash, V value, Entry nextValue){
			this.hash = hash;
			this.value = value;
			this.nextPtr = nextValue;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private HashTable getOuterType() {
			return HashTable.this;
		}
		
	}
	
public static void main(String [] args)
{

}
	
}
