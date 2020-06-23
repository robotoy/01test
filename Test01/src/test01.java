import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class test01 
{

	public static void main(String[] args) throws IOException 
	{
		String ss = args[0];
		String ss2 = args[1];
		
		File dirFile = new File(ss);
		File endFile = new File(ss2);
		
		
		if(!endFile.exists())endFile.createNewFile();
		
//		appendMethodA("./test.txt","---asdasd---");
		
		mainFunc(dirFile,endFile);
		
	}
	
	
	public static void mainFunc(File ff,File endFile)
	{
		
		File[] list = ff.listFiles();
		for(int i = 0 ; i<list.length ; i++)
		{
			
			if(!list[i].getName().endsWith("txt"))continue;
			if(list[i].getName().equals(endFile.getName()))continue;
			
			appendMethodA(endFile.getPath(), list[i].getName());
			appendMethodA(endFile.getPath(), "\r\n");
			String pathname = list[i].getPath(); 
	        try (
//	        		FileReader reader = new FileReader(pathname);
//	             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
	        		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(list[i]),"UTF-8"))
	        ) 
	        {
	            String line;
	            while ((line = br.readLine()) != null)
	            {
	                appendMethodA(endFile.getPath(), line);
	                appendMethodA(endFile.getPath(), "\r\n");
	            }
	            appendMethodA(endFile.getPath(), "\r\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
	}
	
	public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void readFile() {
        String pathname = "input.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
