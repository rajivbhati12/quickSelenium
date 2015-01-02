package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VariableFinder {
	protected String currentData;
	protected String beginKey;
	protected String endKey;
	public VariableFinder(String currentData){
		this.currentData = currentData;
	}
	public void setDelimiter(String beginKey, String endKey){
		this.beginKey = beginKey;
		this.endKey = endKey;
	}
	public Set<String> findKeys(){
		Set<String> results = new HashSet();
		int cursor = 0;
		while(true){
			cursor = nextKeyIndex(cursor);
			if(cursor < 0)
				return results;
			int stop = this.currentData.indexOf(this.endKey,cursor);
			if(stop < 0)
				return results;
			int overlapIndexTest = this.currentData.indexOf(this.beginKey,cursor);
			if(overlapIndexTest>= 0 && overlapIndexTest<(stop + this.endKey.length() -1))
				return results;
			String key = this.currentData.substring(cursor,stop);
			cursor = stop + this.endKey.length();
			results.add(key);
		}
	}
	protected int nextKeyIndex(int cursor){
		int start = this.currentData.indexOf(this.beginKey,cursor);
		if(start < 0)
			return start;
		start +=this.beginKey.length();
		if(start + this.endKey.length() > this.currentData.length())
			start = -1;
		return start;
	}
	
}
