package com.mathew.corejava.cache;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Stack;

public class LRUCacheImpl {

  private int cacheSize = 5;

  Hashtable<String, CachePage> cache = null;
  Stack<String> stack = null;

  public LRUCacheImpl(int cSize) {
    cacheSize = cSize;
    cache = new Hashtable<String, CachePage>(cacheSize);
    stack = new Stack<String>();
  }

  public static void main(String[] args) {
    CachePage[] pages = new CachePage[10];
    for(int ii = 0; ii < 10; ii++) {
      pages[ii] = new CachePage(String.valueOf(ii), "Content" + ii);
    }
    LRUCacheImpl cacheImpl = new LRUCacheImpl(3);
    cacheImpl.put(pages[0]);
    cacheImpl.put(pages[0]);
    cacheImpl.put(pages[0]);
    cacheImpl.put(pages[1]);
    cacheImpl.put(pages[2]);
    cacheImpl.put(pages[3]);
    cacheImpl.get(pages[1].getTitle());
    cacheImpl.put(pages[4]);
    System.out.println("DONE");
  }

  public CachePage get(String tit) {
    if(cache.containsKey(tit)) {
      stack.remove(tit);
      stack.push(tit);
      return cache.get(tit);
    }
    return null;
  }

  public void put(CachePage page) {
    if(isCacheFull()) {
      String key = stack.firstElement();
      cache.remove(key);
      stack.remove(key);
      cache.put(page.getTitle(), page);
      stack.push(page.getTitle());
    }
    else if(cache.containsKey(page.getTitle())) {
      stack.pop();
      stack.push(page.getTitle());
    } else {
      cache.put(page.getTitle(), page);
      stack.push(page.getTitle());
    }
  }

  public boolean isCacheFull() {
    return cache.size() == cacheSize;
  }

}

class CachePage implements Serializable, Comparable {

  private static final long serialVersionUID = -1575554923592345781L;
  private String title;
  private String content;
  private transient int accessCount;

  public CachePage(String t, String c) {
    title = t;
    content = c;
    accessCount = 0;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getAccessCount() {
    return accessCount;
  }

  public void incrementAccessCount() {
    accessCount++;
  }

  @Override
  public int compareTo(Object o) {
    CachePage other = (CachePage) o;
    Integer accessNumOther = other.getAccessCount();
    Integer accessNumthis = this.getAccessCount();
    return accessNumthis.compareTo(accessNumOther);
  }
}
