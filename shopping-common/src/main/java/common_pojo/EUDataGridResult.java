package common_pojo;

import java.util.List;

/**
 * @ClassName: EUDataGridResult
 * @Description: 接收分页参数，一个是page一个是rows
 * @author qinf QQ:908247035
 * @date 2016年12月2日
 * @version V1.0
 */
public class EUDataGridResult {

	private long total;
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
