package all.pachong;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public  static void  writeContent(String data){
        BufferedWriter bw=null;
        FileWriter fileWritter=null;
        try{
//
            File file =new File("E://Bcomment.txt");
            if(!file.exists()){
                file.createNewFile();
            }
//true 每次写入文件是新增的,false只代表存的最后一个。
            fileWritter = new FileWriter(file,true);
            bw= new BufferedWriter(fileWritter);
            bw.write(data);
            bw.newLine();
            System.out.println("Done");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(bw!=null){
                    bw.flush();
                    // bw.close();
                    fileWritter.close();
//先关闭内圈 在关闭外圈  也可以只关闭外圈
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}