package net.lw.meetlove.web.admin.goods.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.meetlove.api.entity.IGoodsClassify;

public class ClassifyTreeForm {

	private long id;
	private String text;
	private boolean leaf = true;

	public ClassifyTreeForm() {
	}

	public ClassifyTreeForm(IGoodsClassify classify) {
		id = classify.getId();
		text = classify.getName();
		leaf = !(classify.listClassifyChildren().size()>0);
	}

	public static ClassifyTreeForm toForm(IGoodsClassify classify){
		ClassifyTreeForm form = new ClassifyTreeForm(classify);
		return form;
	}

	public static List<ClassifyTreeForm> toForms(List<IGoodsClassify> classifies){
		List<ClassifyTreeForm> forms = new ArrayList<ClassifyTreeForm>();
		for(IGoodsClassify classify : classifies){
			forms.add(toForm(classify));
		}
		return forms;
	}



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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}


}
