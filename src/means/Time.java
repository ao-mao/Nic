package means;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// aΪam/pm�ı��  
        Date date = new Date();// ��ȡ��ǰʱ��
        return sdf.format(date);
	}
}
