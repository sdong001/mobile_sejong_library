package com.fourB.library.Report;

import android.util.Log;

import com.fourB.library.HttpManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReportManager {
    static Map<String, String> mRoomDic = new HashMap<String, String>();


    private static void init() {
        if( !mRoomDic.isEmpty() ) { return; }
        mRoomDic.put("열람실 A", "A");
        mRoomDic.put("열람실 B", "B");
        mRoomDic.put("열람실 C", "C");
        mRoomDic.put("열람실 D-A", "DA");
        mRoomDic.put("열람실 D-B", "DB");
        mRoomDic.put("3층 열람실 A", "3A");
        mRoomDic.put("3층 열람실 B", "3B");
    }

    public static void report(String seatRoom, String seatNumber, String type, String content) {
        init();
        seatRoom = mRoomDic.get(seatRoom);

        final String[] findIdQuery = {"seat_room=" + seatRoom, "seat=" + seatNumber };
        try {
            String idFindRes = HttpManager.httpRun("user", findIdQuery, "", "GET");
            Log.d("ReportManager", "report: " + idFindRes);

            Gson gson = new Gson();
            idFindRes = idFindRes.substring(1, idFindRes.length() -1);
            User user = gson.fromJson(idFindRes, User.class);
            String token = user.getToken();
            int a =1;
//            final String[] postQuery = {"seat_room=" + seatRoom, "seat=" + seatNumber, "type=" + type, "content=" + content };
//            final String serverRes = HttpManager.httpRun("report", postQuery, "", "POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}