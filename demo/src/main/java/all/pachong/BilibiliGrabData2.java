package all.pachong;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringEscapeUtils;


import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 我是程序汪   B站评论抓抓抓
 */
public class BilibiliGrabData2 {
 public  static   TreeSet  set=new TreeSet();
    //public static String TMP_COOKIES="__utma=17226283.2092736312.1512532149.1512532149.1512532149.1; shown_offset=20; kd_user_id=eedac876-3b1b-47aa-9216-3579708158d7; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2216072d2b3654a1-0c88d8227fce53-5b452a1d-1327104-16072d2b3662d6%22%2C%22%24device_id%22%3A%2216072d2b3654a1-0c88d8227fce53-5b452a1d-1327104-16072d2b3662d6%22%2C%22props%22%3A%7B%22%24latest_utm_source%22%3A%221212%22%7D%7D; ARK_ID=JS691aa2a0e5ab7ed771ff273821cdffdd691a; uuid_tt_dd=10_37288900190-1545124986122-712778; UN=u012102536; smidV2=20180424105744a618431f74244c2a80d2b1389f37a9e8002a5f2c1a3489910; _ga=GA1.2.2092736312.1512532149; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=5744*1*u012102536!6525*1*10_37288900190-1545124986122-712778!1788*1*PC_VC; dc_session_id=10_1563428341051.649335; UserName=u012102536; UserNick=qq805549946; AU=B1B; BT=1567585729663; p_uid=U000000; __gads=Test; firstDie=1; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1570873651,1571019576,1571021274,1571021468; dc_tos=pzch9z; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1571023223";
//对应每个页面的cookie
    public static String TMP_COOKIES="buvid3=C655012A-D5A8-488A-8492-C4A81AC5EAC547181infoc; rpdid=kmpqokxppsdossiwpkpxw; CURRENT_FNVAL=16; stardustvideo=1; _uuid=80C29B86-9168-1DB3-4028-BE4E2569A95C29202infoc; LIVE_BUVID=AUTO2215705327345614; sid=dafnoyfg; UM_distinctid=16dbf339654353-0a5dc273d7000e-5c41291e-144000-16dbf3396557f6; finger=b3372c5f; DedeUserID=477006254; DedeUserID__ckMd5=1f050630345a5a3b; bili_jct=ccbc8dc0e09dabc95b81ced6b2a65f38; bp_t_offset_477006254=310451235568045756; CNZZDATA2724999=cnzz_eid%3D166308252-1570865943-https%253A%252F%252Fwww.bilibili.com%252F%26ntime%3D1571705464";
    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();

        try {
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
//遍历一遍，查出所有的数据 例如200条（主要是为了treeset排序）
            for (int i = 0; i <20; i++) {
                Thread.sleep(10);
                System.out.println("开始抓数据 开始"+i+1+"数量"+10);
                getMessage(httpClient,i+1,30);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void getMessage(HttpClient httpClient,
                                   int cursor,int limit) throws IOException {
        //String  dataUrl="https://member.bilibili.com/x/web/replies?order=ctime&filter=-1&is_hidden=0&type=1&pn="+cursor+"&ps="+limit;
        //https://www.toutiao.com/c/user/relation/64874752054/?tab=following
        //https://me.csdn.net/api/favorite/listByFolder?folderID=44805&&page=1&&pageSize=10
       // String  dataUrl="https://me.csdn.net/api/favorite/listByFolder?folderID=44805&&page="+cursor+"&&pageSize="+limit;
       String  dataUrl="https://space.bilibili.com/ajax/member/getSubmitVideos?mid=407040228&pagesize="+limit+"&tid=0&page="+cursor+"&keyword=&order=pubdate";
        PostMethod postMethod=new PostMethod();
        GetMethod getMethod = new GetMethod(dataUrl);
        getMethod.setRequestHeader("cookie", TMP_COOKIES);
        // postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36");
        //Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36
        httpClient.executeMethod(getMethod);
        String text = getMethod.getResponseBodyAsString();
        JSONObject jsonObject=JSONObject.parseObject(text);

//遍历200条数据依次存入treeset
        for (int i = 0; i <31 ; i++) {
            System.out.println(i);
            try {
                String content=null;


//data时json中的数据
                String title=JSONPath.eval(jsonObject,"$.data.vlist["+i+"].title").toString();


                String replier=JSONPath.eval(jsonObject,"$.data.vlist["+i+"].description").toString();
              /*  StringEscapeUtils.escapeJava(content);
                StringEscapeUtils.escapeJava(title);
                StringEscapeUtils.escapeJava(replier);*/
                // if(content.indexOf("根据指定关键字抓取评论")>0)
                // {

                set.add(title);
//set的集合的条数确定时才会写入文件
                System.out.println("set集合：      "+set.size());
//当集合存满数据时开始依次插入文档
                if(set.size()==496){
                    int x=0;
                    Iterator it =set.iterator();
                    while (it.hasNext()){

//利用x++,得到遍历了多少条。
                        FileUtils.writeContent("编号："+(x++)+":"+it.next().toString());

                    }



                }


                System.out.println("题目:"+content+"|"+title+"|"+replier);
                // }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}