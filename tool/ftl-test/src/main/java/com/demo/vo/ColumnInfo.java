package com.demo.vo;

public class ColumnInfo {
	/** 数据库字段名称 **/
    private String columnName;

    /** 允许空值 **/
    private Object isNullable;

    /** 数据库字段类型 **/
    private String columnType;

    /** 数据库字段注释 **/
    private String columnComment;

    /** 数据库字段键类型 **/
    private Object columnKey;

    /** 额外的参数 **/
    private Object extra;
    
    

	public ColumnInfo(String columnName, 
			Object isNullable, 
			String columnType, 
			String columnComment, 
			Object columnKey,
			Object extra) {
		super();
		this.columnName = columnName;
		this.isNullable = isNullable;
		this.columnType = columnType;
		this.columnComment = columnComment;
		this.columnKey = columnKey;
		this.extra = extra;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Object getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(Object isNullable) {
		this.isNullable = isNullable;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public Object getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(Object columnKey) {
		this.columnKey = columnKey;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}  
    
}
