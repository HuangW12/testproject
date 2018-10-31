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
	      String element = document.text();//��ȡ��վ��Ϣ
	      String  str = element.replaceAll("[^a-zA-Z]", " ");//�Բ���Ӣ�ĵ��ַ��ÿո����
	      JiebaSegmenter segmenter = new JiebaSegmenter();
	      str2 = segmenter.sentenceProcess(str);//���зִ�
	      /*��ȥ����Ӣ����ĸ��*/
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
	      System.out.println("Ƶ�ʴ������Ĵ�:"+str2.get(k)+" "+"����:"+Max);
	      
	}

}
