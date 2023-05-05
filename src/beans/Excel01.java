package beans;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import dao.BookDao;

public class Excel01 {
	public int excleOut(String id,List<borrow> list) throws Exception {  
		int j=1;
		if(list.size()<=0)
		{
			return j;
		}
		BookDao ncd=new BookDao();
		String namex=ncd.name_get(id);
		String path="d:/"+namex+"的借阅记录.xls";
		File file=new File(path);
        WritableWorkbook book = Workbook.createWorkbook(file);
        WritableSheet sheet=book.createSheet("record1",0);
        Label label=null;
        String[] title={"学号","书号","书名","状态","时间"};
        for (int i=0;i<title.length;i++){
            label=new Label(i,0,title[i]);
            sheet.addCell(label);
        }
        for (borrow nc:list){
        	label=new Label(0,j,nc.getId());
			sheet.addCell(label);
            label=new Label(1,j,nc.getBookid());
            sheet.addCell(label);
            label=new Label(2,j,nc.getBookname());
			sheet.addCell(label);
			label=new Label(3,j,nc.getBookstate());
            sheet.addCell(label);
			label=new Label(4,j,nc.getTime());
            sheet.addCell(label);
            j++;
        }  
        // 写入目标路径  
        book.write();
        book.close();
        return j;
    }
}
