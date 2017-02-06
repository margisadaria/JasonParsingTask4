package com.margi.tak4json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity
{
    TextView textView1,textview2;
    public  String ParsingData="{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView)findViewById(R.id.txt1);
        textview2=(TextView)findViewById(R.id.txt2);
        loadJson();

    }

    public void loadJson()
    {

        try{
            JSONObject rootobject = new JSONObject(ParsingData);
           JSONObject glossaryobject = rootobject.getJSONObject("glossary");

            String titleglossary = glossaryobject.getString("title");
            textView1.setText("titleglossary:"+titleglossary);
           // Log.d("tag", "Title: "+titleglossary);

            JSONObject glossdivobject = glossaryobject.getJSONObject("GlossDiv");
            String titlediv = glossdivobject.getString("title");
            //Log.d("tag","Title"+titlediv);
            textview2.setText("titlediv"+titlediv);

            JSONObject glossListObject =glossdivobject.getJSONObject("GlossList");
            JSONObject glossentryobject =glossListObject.getJSONObject("GlossEntry") ;

            String id = glossentryobject.getString("ID");
            Log.d("tag","Id"+id);

            String sort = glossentryobject.getString("SortAs");
            Log.d("tag","SortAs:"+sort);

            String glossTerm = glossentryobject.getString("GlossTerm");
            Log.d("tag","GlossTerm:"+glossTerm);

            String acr = glossentryobject.getString("Acronym");
            Log.d("tag","Accronym:"+acr);


            String abv = glossentryobject.getString("Abbrev");
            Log.d("tag","Abbrevation:"+abv);


            JSONObject GlossdefObject = glossentryobject.getJSONObject("GlossDef");
            String para = GlossdefObject.getString("para");
            Log.d("tag","para:"+para);

            JSONArray jsonarray = GlossdefObject.getJSONArray("GlossSeeAlso");
            for (int i=0;i<jsonarray.length();i++) {
                String gloseealso = "\n" + jsonarray.getString(i);
                Log.d("tag", "gloseealso:" + gloseealso);

            }
            String Glosssee = glossentryobject.getString("GlossSee");
            Log.d("tag","Glosssee:"+Glosssee);

            glossaryobject.get("Glossary");







        }
        catch(JSONException e)
        {

            e.printStackTrace();
        }
    }
    }






