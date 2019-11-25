package all.json;

import all.aa.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller返回json给前端
 * Title:
 * Description:
 * Create time  2018/6/18 19:36
 * Author：程序汪@Scope("request")
 */
@Controller
//@Scope("prototype")
public class JsonController {
    //方式一   ResponseBody
    @ResponseBody
    @RequestMapping("/test4")
    public Student queryUser4(HttpServletRequest request, HttpServletResponse response){
/*     String aa=   JSON.toJSONString( new Student(1,"注解ResponseBody方式"));
System.out.println("aa"+aa);
       //将对象集合转换成为字符串


        List<Student> ls =new ArrayList<>();
        ls.add(new Student(3,"注解ResponseBody方式3"));
        ls.add(new Student(2,"注解ResponseBody方式2"));
        System.out.println("users"+ls);
        String users = JSON.toJSONString(ls);
        System.out.println("users"+users);
        //将字符串转换成为对象集合
        List<Student> userList = JSON.parseArray(users, Student.class);
System.out.println(userList);

       // String 转 Json对象
        JSONObject jsonObject = JSONObject.parseObject(aa);
        Map    map   =(Map) jsonObject;
        System.out.println("map0"+map);
        System.out.println(jsonObject);
        String jsonString = jsonObject.toJSONString();
        System.out.println("json对象转字符串 "+jsonString);


        //map转json对象
        Map<String,Object> map1 = new HashMap<>();
        map1.put("age", 24);
        map1.put("name", "cool_summer_moon");
        System.out.println("map---"+map);
        JSONObject json = new JSONObject(map1);
        System.out.println("json---"+json);*/
        return new Student(1,"注解ResponseBody方式");
    }


    //方式二  自己控制返回具体信息
    @RequestMapping("/check")
    public void queryUser(HttpServletRequest request, HttpServletResponse response){
        try {
            setJsonResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方式三  ModelMap
    @RequestMapping("/test8")
    public void queryUser8(ModelMap model,String name){
        model.addAttribute("data",new Student(1,"小米"));
    }

    @RequestMapping("/test2")
    public ModelAndView queryUser2(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", "0001");
        attributes.put("msg", "hello");
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }

    @RequestMapping("/test3")
    public void queryUser3(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JSON.toJSONString(new Student(1,"程序汪汪")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return
     */
    @RequestMapping("/test6")
    public Map<String, String> queryUser6()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value-1");
        map.put("key2", "value-2");
        return map;
    }

    @RequestMapping("/test7")
    public ModelAndView queryUser7(ModelMap model, String name){
        ModelAndView modelAndView=new ModelAndView();
        model.addAttribute("name",name);
        modelAndView.setViewName("hello");
        return modelAndView;
    }


    void setJsonResponse(HttpServletResponse httpServletResponse) throws IOException {
        Map map = Maps.newHashMap();
        map.put("status", "success");
        map.put("errorCode", "");
        map.put("errorMsg", "");
        map.put("data", new Student(1,"程序汪汪"));
        httpServletResponse.addHeader("Content-Type", "application/json;chaset=UTF-8");
        httpServletResponse.getOutputStream().write(JSON.toJSONBytes(map));
    }}