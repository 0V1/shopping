package common_pojo;
/**
 * @ClassName: EUTreeNode
 * @Description: easyUI树
 * @author qinf QQ:908247035
 * @date 2016年12月7日
 * @version V1.0
 */
public class EUTreeNode {

	//节点id
	private long id;
	//内容
	private String text;
	//设置打开状态
	private String state;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}