package com.lingjoin.htmlparser;

public class HTMLParser {

	public static int state=0;
	
	public boolean init(String arg){
		state=CHTMLParserLibrary.instance.HPR_Init(arg, "0");
		if(state==1){
			return true;
		}else{
			System.out.println(CHTMLParserLibrary.instance.HPR_GetLastErrMsg());
			return false;
		}
	}
	
	public String getContent(String sHtmlBuffer,int nLen){
		if(state==1){
			CHTMLParserLibrary.instance.HPR_ParseBuffer(sHtmlBuffer, nLen);
			return CHTMLParserLibrary.instance.HPR_GetContent();
		}else{
			System.out.println(CHTMLParserLibrary.instance.HPR_GetLastErrMsg());
			return null;
		}
	}
	
	public String getTitle(String sHtmlBuffer,int nLen){
		if(state==1){
			CHTMLParserLibrary.instance.HPR_ParseBuffer(sHtmlBuffer, nLen);
			return CHTMLParserLibrary.instance.HPR_GetTitle();
		}else{
			System.out.println(CHTMLParserLibrary.instance.HPR_GetLastErrMsg());
			return null;
		}
	}
	
	public String[] getAll(String sHtmlBuffer,int nLen){
		String[] all=new String[2];
		if(state==1){
			CHTMLParserLibrary.instance.HPR_ParseBuffer(sHtmlBuffer, nLen);
			all[0]=CHTMLParserLibrary.instance.HPR_GetTitle();
			all[1]=CHTMLParserLibrary.instance.HPR_GetContent();
			return all;
		}else{
			System.out.println(CHTMLParserLibrary.instance.HPR_GetLastErrMsg());
			return null;
		}
	}
}
