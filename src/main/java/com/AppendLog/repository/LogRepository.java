package com.AppendLog.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface LogRepository {
    List<String> urlList = new ArrayList();
    List<String> browserList = new ArrayList();
    List<String> apiList = new ArrayList();
    HashSet urlSet = new HashSet();
}
