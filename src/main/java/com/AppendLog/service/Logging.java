package com.AppendLog.service;

import java.awt.event.ActionListener;
import java.util.*;

public class Logging {
    private String filePath;
    private String fName;
    private String logTxtCreationDate;
    private Map<String, Integer> mapKey;
    private Map<String, Integer> mapKeyBetweenStartAndEnd;
    private Map<String, Integer> mapBrowser;
    private String[] browser = { "opera", "ie", "firefox", "Chrome", "Safari" };
    private int[] browserCnt;
    private Map<String, Integer> mapHour;
    private int code200, code404, code403;
    private int requestNum;
    private String code403Share;
    private Map<String, String> mapBrowserShare;
    private String mostFrequentHour;
    private String mostFrequentKey;
    private String mostFrequentKeyBetweenStartAndEnd;
    private boolean reportFlag;
    private int start;
    private int end;


    public void initInstances() {
        browserCnt = new int[browser.length];
        mapKey = new HashMap<String, Integer>();
        mapKeyBetweenStartAndEnd = new HashMap<String, Integer>();
        mapBrowser = new HashMap<String, Integer>();
        mapHour = new HashMap<String, Integer>();
        mapBrowserShare = new HashMap<String, String>();
        reportFlag = false;
        code200 = 0;
        code404 = 0;
        code403 = 0;
        requestNum = 0;
        start = 0;
        end = 0;
    }


    public String printReport() {
        StringBuilder sb = new StringBuilder();

        Set<String> set = mapBrowser.keySet();
        Iterator<String> it = set.iterator();
        String key = "";
        sb.append("-------------------------------------------------------------\n");
        sb.append("-------------------------------------------------------------\n");
        sb.append("1. 최다호출 APIKEY : ").append(mostFrequentKey).append(" ").append(mapKey.get(mostFrequentKey)).append("회\n");
        sb.append("2. (호출 횟수 기준) 상위 3개의 API Service ID와 각각의 요청 수 : \n");
        while (it.hasNext()) {
            key = it.next();
            sb.append("\t").append(key).append(" : ").append(mapBrowser.get(key)).append("번(")
                    .append(mapBrowserShare.get(key)).append("%)\n");
        }
        sb.append("3. 서비스를 성공적수행(200) 횟수, 실패(404)횟수 : \n").append("\t200 : ").append(code200).append("번 404 : ")
                .append(code404).append("번\n");
        sb.append("5.비정상적인 요청(403)이 발생한 횟수, 비율 : ").append(code403).append("번(").append(code403Share).append("%)\n");
        if (start == 0 && end == 0) {
            sb.append("6. " + (start + 1) + "~" + requestNum + "번째 정보 최다 사용 키의 이름과 횟수 : \n").append("\t")
                    .append(mostFrequentKey).append(mapKey.get(mostFrequentKey));
        } else {
            sb.append("6. " + start + "~" + (end > requestNum ? requestNum : end) + "번째 정보 최다 사용 키의 이름과 횟수 : \n")
                    .append("\t").append(mostFrequentKeyBetweenStartAndEnd).append(" ")
                    .append(mapKeyBetweenStartAndEnd.get(mostFrequentKeyBetweenStartAndEnd)).append("회");
        }

        return sb.toString();
    }

    public void calMostFrequentKey() {
        int maxValue = (Collections.max(mapKey.values())); //
        for (String key : mapKey.keySet()) {
            if (mapKey.get(key) == maxValue) {
                mostFrequentKey = key;
            }
        }
    }

    public void calMostFrequentKeyBetweenStartAndEnd() {
        int maxValue = (Collections.max(mapKeyBetweenStartAndEnd.values()));
        for (String key : mapKeyBetweenStartAndEnd.keySet()) {
            if (mapKeyBetweenStartAndEnd.get(key) == maxValue) {
                mostFrequentKeyBetweenStartAndEnd = key;
            }
        }
    }
}
