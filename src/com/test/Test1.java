package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Test1 {
	static Test1 test = null;
	Map<Integer, String> map = new HashMap<Integer, String>();
	private final MapWrap<String, Map<String, Map<String, Test2>>> meters = new MapWrap<String, Map<String, Map<String, Test2>>>( new HashMap<String, Map<String, Map<String, Test2>>>() );
	Object meterLock = new Object();
	
	private Test1(){
	}
	
	public static Test1 getInstance(){
		if(test == null){
		test = new Test1();
		}
		return test;
	}

	
	
	
	public void setValues(String val){
		Map<String, Map<String, Test2>> ownerMap = null;
		if( ownerMap == null )
		{
			ownerMap = new HashMap<String, Map<String, Test2>>();
			synchronized( meterLock )
			{
				meters.put( val, ownerMap );
			}
		}
		Map<String, Test2> flowMap = null;
		if( flowMap == null )
		{
			flowMap = new HashMap<String, Test2>();
			ownerMap.put( val, flowMap );
		}
		Test2 meter = null;
		if( meter == null )
		{
			meter = new Test2(1);
			flowMap.put( val, meter );
		}
		System.out.println(Thread.currentThread() + "- "+ meters.size());
	}
	
	public List<Test2> getValues()
	{
		List<Test2> list = new ArrayList<Test2>();
		Collection<Map<String, Map<String, Test2>>> metersCollection = null;
		synchronized (meterLock) {
			metersCollection = meters.values();
		}
		for( Map<String, Map<String, Test2>> owner : metersCollection )
		{
			
			for( Map<String, Test2> activity : owner.values() )
			{
				
				for( Test2 meter : activity.values() )
				{
					list.add( meter );
				}
			}
		}
		return list;
		
	}
}
