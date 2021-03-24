import java.io.*;
import java.nio.charset.Charset;

public class sharding
{
    public static void main(String[] args) throws Exception
    {
        //读取文件
        File fileReader = new File("E:\\gitHub\\shardingTable\\2.txt");
        //写入文件
        FileWriter fileWriter = new FileWriter("E:\\gitHub\\shardingTable\\3.txt");

        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(fileReader),Charset.forName("utf-8")));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((line = bufr.readLine())!=null) {
            sb.append(line).append("\r\n");
        }
        //System.out.println(sb.toString());
        String sbTemp = sb.toString();
        for (int i = 0; i <32 ; i++)
        {
            String match="_0".concat(String.valueOf(i));
            if(i<10){
                match="_00".concat(String.valueOf(i));
            }

            //System.out.println(match);
            String sbTemp2 = sbTemp.replaceAll("_000",match);
            fileWriter.write(sbTemp2);
        }




    }
}
