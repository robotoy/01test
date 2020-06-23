package test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class testDELETE
{
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		String ss = "(�<n�٢[�Ǳ(*�";
		String ss2 = "asd";
		test(ss);
		ByteBuffer bf = convertStringToByte(ss);
	}
	public static void test(String ss) throws UnsupportedEncodingException
	{
		byte b[] = ss.getBytes();
		String ss2 = new String(b,"gbk");
		System.out.println(ss2);
	}
	private static ByteBuffer convertStringToByte(String content) throws UnsupportedEncodingException 
	{
		return ByteBuffer.wrap(content.getBytes("utf-8"));
	}
}
