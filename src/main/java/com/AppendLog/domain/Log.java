package com.AppendLog.domain;

import com.AppendLog.service.log.ReadLog2;
import org.springframework.core.annotation.AliasFor;

import java.util.*;


public class Log {
    List<String> urlList = new ArrayList();
    List<String> browserList = new ArrayList();
    List<String> apiList = new ArrayList();
    Map<String, Integer> urlMap = new TreeMap<>();

    public Map<String, Integer> getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(Map<String, Integer> urlMap) {
        this.urlMap = urlMap;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public List<String> getBrowserList() {
        return browserList;
    }

    public void setBrowserList(List<String> browserList) {
        this.browserList = browserList;
    }

    public List<String> getApiList() {
        return apiList;
    }

    public void setApiList(List<String> apiList) {
        this.apiList = apiList;
    }

    public HashSet getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(HashSet urlSet) {
        this.urlSet = urlSet;
    }

    HashSet urlSet = new HashSet();
}
