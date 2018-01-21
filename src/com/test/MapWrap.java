/*
 *---------------------------------------------------------------------------
 *
 * Copyright (C) Ericsson AB 2011
 *
 * The copyright to the computer program(s) herein is the property of Ericsson
 * AB, Sweden. The program and the source code may used and/or copied only
 * with the written permission of Ericsson AB or in accordance with the terms
 * and conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *
 * All rights reserved.
 *
 *
 *---------------------------------------------------------------------------
 */

package com.test;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Wrapper for Map that is strict with key type Methods taking K or V instead of Object are <br>
 * {@link #get(K key)}<br>
 * {@link #containsValue(V value)}<br>
 * {@link #containsKey(K key)}<br>
 * {@link #remove(K key)}<br>
 * 
 * @param <K> Key type
 * @param <V> Value type
 */
public final class MapWrap<K, V> implements Serializable
{
	private static final long serialVersionUID = -397280877367553180L;

	final private Map<K, V> map;

	public MapWrap(Map<K, V> map)
	{
		this.map = map;
	}

	public V get(K key)
	{
		return map.get( key );
	}

	public V put(K key, V value)
	{
		return map.put( key, value );
	}

	public boolean containsValue(V value)
	{
		return map.containsValue( value );
	}

	public boolean containsKey(K key)
	{
		return map.containsKey( key );
	}

	public Set<Map.Entry<K, V>> entrySet()
	{
		return map.entrySet();
	}

	public Set<K> keySet()
	{
		return map.keySet();
	}

	public V remove(K key)
	{
		return map.remove( key );
	}

	public Collection<V> values()
	{
		return map.values();
	}

	public int size()
	{
		return map.size();
	}

	public void clear()
	{
		map.clear();
	}

	public boolean isEmpty()
	{
		return map.isEmpty();
	}

	public void putAll(Map<? extends K, ? extends V> m)
	{
		map.putAll( m );
	}

	/**
	 * @return The wrapped map
	 */
	public Map<K, V> getMap()
	{
		return map;
	}

	public String toString()
	{
		return map.toString();
	}
}