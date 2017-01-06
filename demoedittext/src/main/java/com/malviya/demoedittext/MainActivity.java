package com.malviya.demoedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CustomEditText mInput;

    ListView mListView;
    ArrayAdapter mAdapter;
    ImageButton bold, italic;
    String eTString;
    List<String> arrayListObj = new ArrayList<>();
    private boolean fBold = true;
    private boolean fItalic = true;
    int startSelection;
    int endSelection;
    Spanned s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.list1);
        mInput = (CustomEditText) findViewById(R.id.customEditText);
        bold = (ImageButton) findViewById(R.id.action_bold);
        italic = (ImageButton) findViewById(R.id.action_italic);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListObj);
        mListView.setAdapter(mAdapter);
        bold.setOnClickListener(this);
        italic.setOnClickListener(this);
        startSelection = mInput.getSelectionStart();
        endSelection = mInput.getSelectionEnd();
    }

    public void onSend(View v) {
        if(s!=null){
        arrayListObj.add( Html.toHtml(s));
        mAdapter.notifyDataSetChanged();}
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_bold:
                eTString = mInput.getText().toString().trim();
                if (!mInput.getText().toString().trim().equals("")) {
                    if (!selectedText(mInput).trim().equals(" ")) {
                        if (fBold) {
                             s = Html.fromHtml("<b> " + eTString + " </b>");
                            mInput.setText(s);
                            eTString=mInput.getText().toString();
                            //      Toast.makeText(this, "Bold", Toast.LENGTH_SHORT).show();
                            //    Toast.makeText(this, "selectedText: " + selectedText(mInput), Toast.LENGTH_SHORT).show();
                            fBold = false;
                        } else {
                            mInput.setText(eTString);
                            // Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show();
                            fBold = true;
                        }
                    }
                } else {
                    Toast.makeText(this, "Plz write something ..", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.action_italic:
                eTString = mInput.getText().toString().trim();
                if (!mInput.getText().toString().trim().equals("")) {
                    if (!selectedText(mInput).trim().equals(" ")) {
                        if (fItalic) {
                             s = Html.fromHtml("<i>" + eTString + "</i>");
                            mInput.setText(s);
                            eTString=mInput.getText().toString();
                            // Toast.makeText(this, "italic", Toast.LENGTH_SHORT).show();
                            //  Toast.makeText(this, "selectedText: " + selectedText(mInput), Toast.LENGTH_SHORT).show();
                            fItalic = false;
                        } else {

                            mInput.setText(eTString);
                            //   Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show();
                            fItalic = true;
                        }
                    }
                } else {
                    Toast.makeText(this, "Plz write something ..", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    private String selectedText(EditText editText) {
        startSelection = editText.getSelectionStart();
        endSelection = editText.getSelectionEnd();
     //   String selectedText = editText.getText().toString().substring(startSelection, endSelection);
        String selectedText = editText.getText().toString();
        return selectedText;
    }


}
