package com.fourB.library.Anouncement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fourB.library.R;

import java.util.ArrayList;

public class AnouncementActivity extends AppCompatActivity {

    private AnouncementAdapter mAdapter;
    private ListView mlistview;
    private ArrayList<AnouncementItem> mitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anouncement_all);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AllFindViewById();

        mAdapter.addItem(new AnouncementItem("제 43회 독서경시대회 장소 안내", "2019-03-21", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("[종료]2019신입생을 위한 학술정보원 스탬프", "2019-03-21", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=917&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("EndNote X9 사용자 온라인 교육", "2019-03-20", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("KER18 대학 라이선스 선정 기념, 이벤트 안내", "2019-03-20", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=917&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("[학술 정보원]조교 모집", "2019-03-18", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("제 6회 전국대학생 퀴즈 응시 안내", "2019-03-18", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=917&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("2018년 대학민국학습원 우수 학술도서 목록", "2019-03-14", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("학술정보원 정기 이용 교육", "2019-03-13", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=917&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("제 43회 독서경시대회 개최", "2019-03-05", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("학부신입생 온라인이용자교육 이수", "2019-03-05", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=917&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));
        mAdapter.addItem(new AnouncementItem("전자책 서비스 일시 중지 안내", "2019-02-21", "http://library.sejong.ac.kr/bbs/Detail.ax?bbsID=1&articleID=918&mode=&type=&page=&currentPage=1&pageSize=10&isSearch=&searchTarget=&searchKeyword=&isMine="));

        mlistview.setAdapter(mAdapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AnoucementDetailActivity.class);
                AnouncementItem item = (AnouncementItem) mAdapter.getItem(position);
                intent.putExtra("Url", item.getAnouncement_Detail_Url());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AllFindViewById(){

        mlistview = findViewById(R.id.listView);
        mAdapter = new AnouncementAdapter();
        mitems = mAdapter.getItems();
    }

    class AnouncementAdapter extends BaseAdapter {

        ArrayList<AnouncementItem> items = new ArrayList<AnouncementItem>();

        public ArrayList<AnouncementItem> getItems() {
            return items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(AnouncementItem item){
            items.add(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            AnouncementItemView view = new AnouncementItemView(getApplicationContext());

            AnouncementItem item = items.get(position);
            view.setmAnouncement_Title(item.getAnouncement_Title());
            view.setmAnouncement_Update_Date(item.getAnouncement_Update_Date());

            return view;
        }
    }
}