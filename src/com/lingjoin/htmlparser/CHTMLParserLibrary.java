package com.lingjoin.htmlparser;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CHTMLParserLibrary extends Library {

	CHTMLParserLibrary instance=(CHTMLParserLibrary) Native.loadLibrary("LJHtmlParser", CHTMLParserLibrary.class);
	
	public int HPR_Init(String sDataPath,String sLicenseCode);
	
	public boolean HPR_ParseFile(String sHtmlFilename);
	
	public boolean HPR_ParseBuffer(String sHtmlBuffer, int nLen);
	
	public String HPR_GetContent();
	
	public String HPR_GetTitle();
	
	public String HPR_GetLastErrMsg();
	
	public void HPR_Exit();
}
