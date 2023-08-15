package tech.codingclub.helix.entity;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WikipediaDownloader {


    //private static TaskManager taskManager= new TaskManager(20);

    private String Keyword;
    private String result;
    public WikipediaDownloader(){

    }

    public WikipediaDownloader(String Keyword){
        this.Keyword=Keyword;

    }
    public WikiResult getResult() {
        if (this.Keyword == null ||this.Keyword.length() == 0) {
            return null;
        }



        this.Keyword =this.Keyword.trim().replaceAll("[ ]","_");
        String wikiUrl=getWikipediaUrlForQuery(this.Keyword);


        String response ="";
        String image_url="";
        try {
            String wikipediaResponseHTML = HttpURLConnectionExample.sendGet(wikiUrl);
            // System.out.println(wikipediaResponseHTML);



            Document document= (Document) Jsoup.parse(wikipediaResponseHTML,"https://en.wikipedia.org/wiki/");
            Elements childElements=document.body().select(".mw-parser-output > *");
            int state=0;

            for(Element childElement:childElements){
                if(state==0) {
                    if (childElement.tagName().equals("table"))
                        state=1;
                } else if (state==1) {
                    if (childElement.tagName().equals("p"))
                        state=2;
                    response =childElement.text();
                    break;

                }
                // System.out.println(childElement.tagName());
            }
            try {
                image_url= document.body().select(".infobox-image img").get(0).attr("src");
            }catch (Exception ex){

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.result=response;

        WikiResult wikiResult=new WikiResult(this.Keyword,response,image_url);
        //System.out.println(new Gson().toJson(wikiResult));


        //Gson gson =new GsonBuilder().setPrettyPrinting().create();
       // String json =gson.toJson(wikiResult);
        //System.out.println(json);
        return wikiResult;

    }
    private String getWikipediaUrlForQuery (String cleanKeyword){
        return "https://en.wikipedia.org/wiki/" + cleanKeyword;
    }




}

