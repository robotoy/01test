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
//	             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
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
            // ��һ����������ļ���������д��ʽ
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // �ļ����ȣ��ֽ���
            long fileLength = randomFile.length();
            //��д�ļ�ָ���Ƶ��ļ�β��
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void readFile() {
        String pathname = "input.txt"; // ����·�������·�������ԣ�д���ļ�ʱ��ʾ���·��,��ȡ����·����input.txt�ļ�
        //��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw;
        //���ر��ļ��ᵼ����Դ��й¶����д�ļ���ͬ��
        //Java7��try-with-resources�������Źر��ļ����쳣ʱ�Զ��ر��ļ�����ϸ���https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
        ) {
            String line;
            //�����Ƽ����Ӽ���д��
            while ((line = br.readLine()) != null) {
                // һ�ζ���һ������
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
