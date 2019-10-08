package com.oaoffice.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用commons-fileupload进行处理上传内容
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		PrintWriter out=response.getWriter();
		//factory工厂   ，    FileItem是单个文件
		try {
			List<FileItem> files=fileUpload.parseRequest(request);
			for (FileItem fileItem : files) {
				//文件名
				System.out.println(fileItem.getName());
				System.out.println(fileItem.getSize());
				System.out.println(fileItem.getContentType());
				
				//进行文件写到服务器磁盘
				
				//获取服务器路径
				String parentDir=this.getServletContext().getRealPath("/upload");
				//如果服务器没有upload路径，要创建文件夹
				File file=new File(parentDir, fileItem.getName());
				if(!file.getParentFile().exists()) {
					file.getParentFile().mkdir();
				}
				//进行文件写到服务器磁盘  IO读写
				InputStream is=fileItem.getInputStream();
				
				OutputStream os=new FileOutputStream(file);
				byte[] buf=new byte[1024];
				int len=-1;
				while((len=is.read(buf))!=-1) {
					os.write(buf, 0, len);
				}
				//关闭流
				os.close();
				is.close();
				System.out.println(file.getAbsolutePath());
				out.println("{\"status\":\"1\",\"fpath\":\""+fileItem.getName()+"\"}");
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
