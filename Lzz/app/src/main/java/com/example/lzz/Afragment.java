package com.example.lzz;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Afragment extends Fragment {
    private DBOpenHelper2 dbOpenHelper2;
    MyDatabaseHelper myDatabaseHelper;

    private TextView mTvTitle;
    private Button btnss;
    private EditText ssk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        dbOpenHelper2=new DBOpenHelper2(getActivity(), "dict.db", null, 1);

        myDatabaseHelper=new MyDatabaseHelper(getActivity());

        btnss= (Button)view.findViewById(R.id.btnss);
        final ListView listView = (ListView)view.findViewById(R.id.result_listView);
        final EditText etSearch = (EditText) view.findViewById(R.id.ssk);

        btnss.setOnClickListener(new View.OnClickListener() {  //单击查询按钮，实现查询词库中的单词
            @Override
            public void onClick(View v) {
                myDatabaseHelper.openDatabase();
                myDatabaseHelper.closeDatabase();

                String key = etSearch.getText().toString();  //获取要查询的单词
                //查询单词
                Cursor cursor=dbOpenHelper2.getReadableDatabase().query("dict",null
                        ,"word = ?",new String[]{key},null,null,null);


                ArrayList<Map<String, String>> resultList = new ArrayList<Map<String, String>>();   //创建ArrayList对象，用于保存查询出的结果
                while (cursor.moveToNext()) {  // 遍历Cursor结果集
                    Map<String, String> map = new HashMap<>();  // 将结果集中的数据存入HashMap中
                    // 取出查询记录中第2列、第3列的值
                    map.put("word", cursor.getString(1));
                    map.put("interpret", cursor.getString(2));
                    resultList.add(map);                        //将查询出的数据存入ArrayList中
                }

                if (resultList == null || resultList.size() == 0) {  //如果数据库中没有数据
                    // 显示提示信息，没有相关记录
                    Toast.makeText(getActivity(), "很遗憾，没有相关记录！", Toast.LENGTH_LONG).show();
                } else {
                    // 否则将查询的结果显示到ListView列表中
                    Toast.makeText(getActivity(), "找", Toast.LENGTH_LONG).show();
                    SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), resultList,
                            R.layout.a2,
                            new String[]{"word", "interpret"}, new int[]{
                            R.id.result_word, R.id.result_interpret});
                    listView.setAdapter(simpleAdapter);
                }
            }
        });


        return view;
    }
    public void onDestroy(){  //实现退出应用时，关闭数据库连接
        super.onDestroy();
        if (dbOpenHelper2 != null) {   //如果数据库不为空时
            dbOpenHelper2.close();     //关闭数据库连接
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
