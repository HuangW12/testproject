import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.huaban.analysis.jieba.JiebaSegmenter;
public class Chinesetext {

	public static void main(String[] args)throws IOException {
		String url = "https://wenku.baidu.com/view/8d3821df7f1922791688e82f.html";
		Document document = Jsoup.connect(url).userAgent("").get();
		String element = document.body().text();//获取该网站的页面的信息
		List<String> str = new LinkedList<String>();
	    String str2 = element.replaceAll("[^\\u4e00-\\u9fcc]", " ");//除去不是中文的字符用空格代替
	    JiebaSegmenter segmenter = new JiebaSegmenter();
	    str = segmenter.sentenceProcess(str2);//对str进行分词
        /*除去非中文的字符*/
	    for(int i = 0 ; i < str.size() ; i++) {
	    	if(!str.get(i).matches("[\\u4e00-\\u9fcc]" )) {
	    		str.remove(i);
	    	}	
	    }
	    /*除去空格*/
	    for(int i = 0 ; i < str.size() ; i++) {
	    	if(str.get(i).matches("\\s")) {
	    		str.remove(i);
	    	}
	    }
	    for(int i = 0 ; i < str.size() ; i++)
	    {
	    	System.out.print(str.get(i));
	    }
	    /*int count = 0 , Max = 0,k = 0;
	    for(int i = 0 ; i < str.size() ; i++) {
	    	count = 0;
	    	for(int j = 0 ; j < str.size() ; j++) {
	    		if(str.get(i).matches(str.get(j))) {
	    			count++;
	    		}
	    	}
	    	if(count > Max) {
    			k = i;
    			Max = count;
    		}
	    }
	    System.out.println("频率次数最多的词:"+str.get(k)+"  "+"次数:"+Max);*/
	}

}
