package all.aa;

import com.google.common.collect.Sets;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.util.HashSet;

public class 谷歌的轮子 {

    public static void main(String[] args){

        HashSet<Integer> setF = Sets.newHashSet(7, 6, 6,1);
        HashSet<Integer> setT = Sets.newHashSet(1, 2, 3,4);
       //求并集
        Sets.SetView<Integer> union = Sets.union(setF, setT);
        System.out.println(union);

  //求交集
        Sets.SetView<Integer> intersection = Sets.intersection(setF, setT);
        if(intersection.size()>0){
            System.out.println("有交集元素"+intersection);
        }else{
            System.out.println("无 交集");
        }


    }



}
