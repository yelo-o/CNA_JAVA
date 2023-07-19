package com.my.test.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

//   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      InputStream is = request.getInputStream();//요청Body영역을 읽어오는 스트림
//      int readValue = -1;
//      while( (readValue = is.read()) != -1) {
//         System.out.print((char)readValue);
//      }
//   }
    private static final String CHARSET = "utf-8";
    private static final String ATTACHES_DIR = "C:\\attaches";
    private static final int LIMIT_SIZE_BYTES = 1024 * 1024;
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      File attachesDir = new File(ATTACHES_DIR);
      if(!attachesDir.exists()) {
         attachesDir.mkdir();
      }
       
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setRepository(attachesDir); //첨부파일저장 경로
        fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES); //첨부파일내용 읽는 단위
        ServletFileUpload fileUpload = 
              new ServletFileUpload(fileItemFactory);
    
        try {
        	fileUpload.setFileSizeMax(LIMIT_SIZE_BYTES);
        	
            List<FileItem> items = fileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) { //일반요청전달데이터
                    System.out.println("파라미터 명 : " + item.getFieldName() //요청전달데이터 이름 f1
                                    +", 파라미터 값 :  "+item.getString(CHARSET));
                }else { //첨부데이터
                   System.out.println(
                         "파일 파라미터 명 : "+ item.getFieldName() //요청전달데이터 이름 f1
                         + ", 파일 명 : "+item.getName() //첨부파일이름
                         + ",  파일 크기 : "+ item.getSize()); //첨부파일크기
                    if (item.getSize() > 0) {
                        //String separator = File.separator;
                        //int index =  item.getName().lastIndexOf(separator);
                        //String fileName = item.getName().substring(index  + 1);
                    	
                    	//UUID.randomUUID();
                    	
                        String fileName = item.getName();
                        File uploadFile = new File(ATTACHES_DIR, fileName);
                        item.write(uploadFile);
                    }
                }
            }
            System.out.println("파일 업로드 완료");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 업로드 중 오류가  발생하였습니다");
        }
    }
}