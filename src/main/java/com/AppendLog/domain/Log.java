package com.AppendLog.domain;

import com.AppendLog.service.log.ReadLog2;
import org.springframework.core.annotation.AliasFor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class Log {
    List<String> urlList = new ArrayList();
    List<String> browserList = new ArrayList();
    List<String> apiList = new ArrayList();

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
