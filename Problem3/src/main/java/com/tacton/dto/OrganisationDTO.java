package com.tacton.dto;

public class OrganisationDTO {

private String orgName;

private int row;

private int column;

private int maxRow;

public int getMaxColumn() {
	return maxColumn;
}

public void setMaxColumn(int maxColumn) {
	this.maxColumn = maxColumn;
}

public int getMaxRow() {
	return maxRow;
}

public void setMaxRow(int maxRow) {
	this.maxRow = maxRow;
}

private int maxColumn;

public String getOrgName() {
	return orgName;
}

public void setOrgName(String orgName) {
	this.orgName = orgName;
}

public int getRow() {
	return row;
}

public void setRow(int row) {
	this.row = row;
}

public int getColumn() {
	return column;
}

public void setColumn(int column) {
	this.column = column;
}
	
	
}
