import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.*;
import com.huaban.analysis.jieba.JiebaSegmenter;
public class httptext {

	public static void main(String[] args)throws IOException {
	      String url = "http://www.en8848.com.cn/CET6/tl/mw100/132744.html";
	      Document document = Jsoup.connect(url).userAgent("").get();
	      List<String> str2 = new LinkedList<String>();
	      String element = document.text();//获取网站信息
	      String  str = element.replaceAll("[^a-zA-Z]", " ");//对不是英文的字符用空格代替
	      JiebaSegmenter segmenter = new JiebaSegmenter();
	      str2 = segmenter.sentenceProcess(str);//进行分词
	      /*除去不是英文字母的*/
	      for(int i = 0 ; i < str2.size() ; i++) {
	    	  if(!str2.get(i).matches("[a-zA-Z]") ) {
	    		  str2.remove(i);
	    	  }
	      }
	      int count = 0 , Max = 0,k = 0;
	      for(int i = 0 ; i < str2.size() ; i++) {
	    	  count = 0 ;
	    	  for(int j = 0 ; j < str2.size() ; j++) {
	    		  if(str2.get(i).matches(str2.get(j))) {
	    			  count++;
	    		  }
	    	  }
	    	  if(count > Max) {
	    		  k = i;
	    		  Max = count;
	    	  }
	      }
	      System.out.println("频率次数最多的词:"+str2.get(k)+" "+"次数:"+Max);
	      
	}

}
