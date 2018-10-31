import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.huaban.analysis.jieba.SegToken;
import java.util.*;
public class Start {

	public static void main(String[] args) {
		List<String> str = new LinkedList<String>();
		String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
        JiebaSegmenter segmenter = new JiebaSegmenter();
        str = segmenter.sentenceProcess(text);
        String []a = new String[text.length()];
        a[0] = str.get(0);
        System.out.println(a[0]);
	}

}
