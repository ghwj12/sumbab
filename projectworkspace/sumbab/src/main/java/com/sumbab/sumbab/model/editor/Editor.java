package com.sumbab.sumbab.model.editor;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("editor")
public class Editor {
	
	private int editorNum;
	private String title;
	private List<Integer> numList;
	
	public Editor() {}

	public Editor(String title, List<Integer> numList) {
		super();
		this.title = title;
		this.numList = numList;
	}

	public int getEditorNum() {
		return editorNum;
	}

	public void setEditorNum(int editorNum) {
		this.editorNum = editorNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getNumList() {
		return numList;
	}

	public void setNumList(List<Integer> numList) {
		this.numList = numList;
	}
	
}
