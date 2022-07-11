package com.AppendLog.service.log;

import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadLog2 {

    public static void main(String[] args) throws IOException {

        // 파일 불러오기
        BufferedReader reader = new BufferedReader(
                new FileReader("./Input.log")
        );

        // 파일 생성 후 파일에 출력
        File file = new File("Output.log");
        PrintStream printStream = new PrintStream(new FileOutputStream(file));
//        System.setOut(printStream);


        List<String> urlList = new ArrayList();
        List<String> browserList = new ArrayList();
        List<String> apiList = new ArrayList();
        HashSet urlSet = new HashSet();
        int requestCount = 0;
        String str;
        String[] str1;

        while ((str = reader.readLine()) != null) {

            // 로그 형식 : [상태코드][URL][웹브라우저][호출시각]
            // 로그에서 [호출시각] 제거
            str = str.substring(0, str.length() - 21);

            // 정상 호출값[200], 정상 URL("http://apis.daum.net/search/") 제거
            if (str.contains("[200]")) {
                str = str.replace("[200]", "").replace("http://apis.daum.net/search/", "");
                requestCount = requestCount + 1; // 정상호출 카운트

                // apikey값 apiList에 저장
                String apikeyNeedCut = StringUtils.substringAfter(str, "apikey=");
                String apikey = StringUtils.substringBefore(apikeyNeedCut, "&q");
                apiList.add(apikey);

                // url값 urlList에 저장
                String urlNeedCut = StringUtils.substringBefore(str, "?apikey");
                String url = StringUtils.substringAfter(urlNeedCut, "[");
                urlList.add(url);

                // browser 값 browserList에 저장
                String browserNeedCut = StringUtils.substringAfter(str, "][");
                String browser = browserNeedCut.replace("]","");
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

        System.out.println("최다호출 API KEY\n" + MaxApiKey);
        System.out.println("");

        Map<String, Integer> urlMap = new TreeMap<>();
        Set<String> RequestNumber2 = new HashSet<>(urlList);

        for (String UrlName : RequestNumber2) {
            Integer requestNumber2 = Collections.frequency(urlList, UrlName);
            urlMap.put(UrlName, requestNumber2);
        }
        int count = 0;
        System.out.println("상위 3개의 API Service ID와 각각의 요청 수");
        Map sortedUrlMap = sorted.valueSort(urlMap);
        Set set1 = sortedUrlMap.entrySet();
        Iterator i1 = set1.iterator();
        while (i1.hasNext()) {
            count = count + 1;
            Map.Entry mp1 = (Map.Entry) i1.next();
            System.out.println(mp1.getKey() + ":" + mp1.getValue());
            if (count == 3) {
                break;
            }
        }


        Map<String, Integer> browserMap = new TreeMap<>();
        Set<String> BrowserRequestNum = new HashSet<>(browserList);

        for (String BrowserName : BrowserRequestNum) {
            Integer browserRequestNum = Collections.frequency(browserList, BrowserName);
            browserMap.put(BrowserName, browserRequestNum);
        }
        Map sortedBrowserMap = sorted.valueSort(browserMap);
//        sortedBrowserMap.values() = (sortedBrowserMap.values() / 30);
        Set browserSet = sortedBrowserMap.entrySet();
        Iterator j = browserSet.iterator();

        System.out.println("");
        System.out.println("웹브라우저별 사용 비율");
        while (j.hasNext()) {
            Map.Entry browserMp = (Map.Entry) j.next();

            System.out.println(browserMp.getKey()+":"+browserMp.getValue()+"%");
        }
    }
}




