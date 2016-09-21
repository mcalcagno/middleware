package middleware.grupo01.aggregator;

import java.util.Iterator;
import java.util.List;

public class Aggregator {

	public String aggregate(List<String> list){
		String ret = "<ItemsOrden>";
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			ret += it.next().replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "");
		}
		ret += "</ItemsOrden>";
		return ret;
	}
	
}
