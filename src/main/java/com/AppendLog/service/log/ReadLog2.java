package com.AppendLog.service.log;

import org.thymeleaf.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadLog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("./Input.log")
        );
        List<String> urlList = new ArrayList();
        List<String> browserList = new ArrayList();
        List<String> apiList = new ArrayList();
        HashSet urlSet = new HashSet();
        int requestCount = 0;
        String str;
        String[] str1;
        while ((str = reader.readLine()) != null) {

            // 로그에서 [요청시각] 제거
            str = str.substring(0, str.length() - 21);

            // 정상 호출[200], 정상 URL("http://apis.daum.net/search/") 제거
            if (str.contains("[200]")) {
                str = str.replace("[200]", "").replace("http://apis.daum.net/search/", "");
                requestCount = requestCount + 1; // 정상호출 카운트

                String apikeyNeedCut = StringUtils.substringAfter(str, "apikey=");
                String apikey = StringUtils.substringBefore(apikeyNeedCut, "&q");
                apiList.add(apikey);

                String urlNeedCut = StringUtils.substringBefore(str, "?apikey");
                String url = StringUtils.substringAfter(urlNeedCut, "[");
                urlList.add(url);

                String browser = StringUtils.substringAfter(str, "][");
                browserList.add(browser);
            }
        }


        Map<String, Integer> apiMap = new TreeMap<>();
        Set<String> RequestNumber = new HashSet<>(apiList);

        for (String ApikeyName : RequestNumber) {
            Integer requestNumber = Collections.frequency(apiList, ApikeyName);
            apiMap.put(ApikeyName, requestNumber);
        }
        String MaxApiKey = Collections.max(apiMap.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println("정상호출 카운트 : " + requestCount);
        System.out.println("");
        System.out.println("최다호출 API KEY\n" + MaxApiKey);
        System.out.println(urlSet);

        Map<String, Integer> urlMap = new TreeMap<>();
        Set<String> RequestNumber2 = new HashSet<>(urlList);

        for (String UrlName : RequestNumber2) {
            Integer requestNumber = Collections.frequency(urlList, UrlName);

            urlMap.put(UrlName, requestNumber);
        }
        String MaxUrl = Collections.max(urlMap.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println("최다호출 url\n" + MaxUrl);
    }

    public Map<Integer, Animal> convertListAfterJava8(List<Animal> list) {
        Map<Integer, Animal> map = list.stream()
                .collect(Collectors.toMap(Animal::getId, Function.identity()));
        return map;
    }

}




